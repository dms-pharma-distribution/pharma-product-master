package com.pharma.product.mapper;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.pharma.product.dto.CategoryDto;
import com.pharma.product.dto.ProductDto;
import com.pharma.product.dto.ProductTypeDto;
import com.pharma.product.entity.CategoryEntity;
import com.pharma.product.entity.ProductEntity;
import com.pharma.product.entity.ProductTypeEntity;

@Component
public class ProductCommandMapper {

	ProductMapper productMapper;

	public ProductCommandMapper(ProductMapper productMapper) {
		this.productMapper = productMapper;
	}

	public List<ProductEntity> mapToProductEntities(List<ProductDto> productDtos) {
		return productDtos.stream().map(productDto -> mapToProductEntity(productDto)).collect(Collectors.toList());
	}

	public ProductEntity mapToProductEntity(ProductDto productDto) {
		productDto.setProductUid(Optional.ofNullable(productDto.getProductUid()).filter(uid -> !uid.trim().isEmpty())
				.orElse(UUID.randomUUID().toString()));

		productDto.setProductCode(Optional.ofNullable(productDto).map(ProductDto::getProductCode)
				.filter(code -> code != null && code != 0L).orElseGet(() -> productMapper.generateCodeIfNotExists()));

		var productEntity = productMapper.dtoToProductEntity(productDto);
		productEntity.setCategoryEntity(mapToCategoryEntity(Optional.ofNullable(productDto)
				.map(ProductDto::getCategoryId).filter(id -> id != null && id != 0).orElse(0)));
		productEntity.setProductTypeEntity(mapToProductTypeEntity(Optional.ofNullable(productDto)
				.map(ProductDto::getTypeId).filter(id -> id != null && id != 0).orElse(0)));
		return productEntity;
	}

	public ProductTypeEntity mapToProductTypeEntity(int typeId) {
		var productTypeEntity = new ProductTypeEntity();
		productTypeEntity.setTypeId(typeId);
		return productTypeEntity;
	}

	public CategoryEntity mapToCategoryEntity(int categoryId) {
		var categoryEntity = new CategoryEntity();
		;
		categoryEntity.setCategoryId(categoryId);
		return categoryEntity;
	}

	public List<ProductDto> mapToProductDtos(List<ProductEntity> productEntities) {
		return productEntities.stream().map(productEntity -> mapToProductDto(productEntity))
				.collect(Collectors.toList());
	}

	public ProductDto mapToProductDto(ProductEntity productEntity) {
		var productDto = productMapper.entityToProductDto(productEntity);
		productDto.setCategoryId(productEntity.getCategoryEntity().getCategoryId());
		productDto.setTypeId(productEntity.getProductTypeEntity().getTypeId());
		return productDto;
	}

	public ProductTypeDto mapToProductTypeDto(ProductTypeEntity productTypeEntity) {
		var productTypeDto = productMapper.entityToProductTypeDto(productTypeEntity);
		return productTypeDto;
	}

	public CategoryDto mapToCategoryDto(CategoryEntity categoryEntity) {
		var categoryDto = productMapper.entityToCategoryDto(categoryEntity);
		return categoryDto;
	}

}
