package com.pharma.product.serviceimpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import com.pharma.product.dto.ProductCodesDto;
import com.pharma.product.dto.ProductDto;
import com.pharma.product.entity.ProductEntity;
import com.pharma.product.mapper.ProductCommandMapper;
import com.pharma.product.repository.ProductRepository;
import com.pharma.product.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	public ProductRepository productRepository;

	public ProductCommandMapper productCommandMapper;

	public ProductServiceImpl(ProductRepository productRepository, ProductCommandMapper productCommandMapper) {
		this.productRepository = productRepository;
		this.productCommandMapper = productCommandMapper;
	}

	@Override
	public void createProduct(ProductDto productDto) {
		productRepository.save(productCommandMapper.mapToProductEntity(productDto));
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		productRepository.save(productCommandMapper.mapToProductEntity(productDto));
	}

	@Override
	public void deleteByProductUid(String productUid) {
		productRepository.deleteById(productUid);
	}

	@Override
	public ProductDto findByProductUid(String productUid) {
		Optional<ProductEntity> productEntityOptional = productRepository.findById(productUid);
		if (productEntityOptional.isPresent()) {
			return productCommandMapper.mapToProductDto(productEntityOptional.get());
		} else {
			throw new RuntimeException("product not found with given productUid");
		}
	}

	@Override
	public ProductDto findByProductCode(int productCode) {
		Optional<ProductEntity> productEntityOptional = productRepository.findByProductCode(productCode);
		if (productEntityOptional.isPresent()) {
			return productCommandMapper.mapToProductDto(productEntityOptional.get());
		} else {
			throw new RuntimeException("product not found with given productCode");
		}
	}

	@Override
	public List<ProductDto> findByProductCodes(ProductCodesDto productCodesDto) {
		return productCommandMapper
				.mapToProductDtos(productRepository.findByProductCodeIn(productCodesDto.getProductCodes()));
	}

	@Override
	public List<ProductDto> productTypeAheadSearch(String query) {
		return productCommandMapper.mapToProductDtos(productRepository.productTypeAheadSearch(query));
	}

	@Override
	@Transactional
	public void uploadAndInsertProducts(MultipartFile file) throws IOException, CsvValidationException {
		InputStream inputStream = file.getInputStream();
		CSVReader reader = new CSVReaderBuilder(new InputStreamReader(inputStream)).build();
		reader.skip(1);
		List<ProductDto> productDtos = new ArrayList<>();
		reader.forEach(csvRecord -> {
				var productDto = new ProductDto();
				productDto.setProductCode(Optional.of(csvRecord[0])
						.filter(str -> !str.isEmpty() && str.matches("-?\\d+")).map(Long::parseLong).orElse(0L));
				productDto.setHsnCode(Optional.of(csvRecord[1]).filter(str -> !str.isEmpty() && str.matches("-?\\d+"))
						.map(Long::parseLong).orElse(0L));
				productDto.setProductName(csvRecord[2]);
				productDto.setDescription(csvRecord[3]);
				productDto.setManufacturerName(csvRecord[4]);
				productDto.setManufacturerCode(Optional.of(csvRecord[1])
						.filter(str -> !str.isEmpty() && str.matches("-?\\d+")).map(Long::parseLong).orElse(0L));
				productDto.setPatentCompany(csvRecord[6]);
				productDto.setPatentDate(Optional.of(csvRecord[7])				
						.filter(str -> !str.isEmpty() && str.matches("-?\\d+")).map(Integer::parseInt).orElse(0));
				productDto.setCategoryId(Optional.of(csvRecord[8])
						.filter(str -> !str.isEmpty() && str.matches("-?\\d+")).map(Integer::parseInt).orElse(0));
				productDto.setTypeId(Optional.of(csvRecord[9]).filter(str -> !str.isEmpty() && str.matches("-?\\d+"))
						.map(Integer::parseInt).orElse(0));
				productDto.setCreatedDate(LocalDate.now());
				productDto.setProductUid(csvRecord[11]);
				productDtos.add(productDto);				
			
		});
		productRepository.saveAllAndFlush(this.productCommandMapper.mapToProductEntities(productDtos));
	}
}
