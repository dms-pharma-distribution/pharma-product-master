package com.pharma.product.dto;

import java.util.List;

public class ProductCodesDto {
	private List<Long> productCodes;

	public ProductCodesDto() {
	}

	public ProductCodesDto(List<Long> productCodes) {
		this.productCodes = productCodes;
	}

	public List<Long> getProductCodes() {
		return productCodes;
	}

	public void setProductCodes(List<Long> productCodes) {
		this.productCodes = productCodes;
	}

	@Override
	public String toString() {
		return "ProductCodesDto [productCodes=" + productCodes + "]";
	}

}
