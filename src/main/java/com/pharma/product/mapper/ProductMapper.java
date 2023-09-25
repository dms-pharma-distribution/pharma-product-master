package com.pharma.product.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import com.pharma.product.dto.CategoryDto;
import com.pharma.product.dto.ProductDto;
import com.pharma.product.dto.ProductTypeDto;
import com.pharma.product.entity.CategoryEntity;
import com.pharma.product.entity.ProductEntity;
import com.pharma.product.entity.ProductTypeEntity;

@Mapper(componentModel = "spring")
public interface ProductMapper {

	public ProductEntity dtoToProductEntity(ProductDto ProductDto);

	public ProductTypeEntity dtoToProductTypeEntity(ProductTypeDto ProductTypeDto);

	public CategoryEntity dtoToCategoryEntity(CategoryDto categoryDto);	
	
	public ProductDto entityToProductDto(ProductEntity productEntity);

	public ProductTypeDto entityToProductTypeDto(ProductTypeEntity productTypeEntity);

	public CategoryDto entityToCategoryDto(CategoryEntity categoryEntity);

	default Long generateCodeIfNotExists() {
			long min = 100_000L;
			long max = 999_999L;
			return min + (long) (Math.random() * (max - min + 1));
	}

	default String generateGuidIfNotExists(String existingGuid) {
		if (existingGuid == null) {
			return UUID.randomUUID().toString();
		}
		return existingGuid;

	}
}
