package com.pharma.product.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvValidationException;
import com.pharma.product.dto.ProductCodesDto;
import com.pharma.product.dto.ProductDto;

public interface ProductService {
	public void createProduct(ProductDto productDto);

	public void updateProduct(ProductDto productDto);

	public void deleteByProductUid(String productUid);

	public ProductDto findByProductUid(String productUid);

	public ProductDto findByProductCode(int productCode);
	
	public List<ProductDto> findByProductCodes(ProductCodesDto productCodesDto);
	
	 public List<ProductDto> productTypeAheadSearch(String searchQuery);

	 public void uploadAndInsertProducts(MultipartFile file) throws IOException, CsvValidationException;

}
