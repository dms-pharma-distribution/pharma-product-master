package com.pharma.product.dto;

import java.time.LocalDate;

public class ProductDto {

	private String productUid;
	private Long productCode;
	private String productName;
	private String description;
	private Integer typeId;
	private Integer categoryId;
	private Long hsnCode;
	private String manufacturerName;
	private Long manufacturerCode;
	private LocalDate createdDate;
	private String patentCompany;
	private Integer patentDate;

	public ProductDto() {
	}

	public ProductDto(String productUid, Long productCode, String productName, String description, Integer typeId,
			Integer categoryId, Long hsnCode, String manufacturerName, Long manufacturerCode, LocalDate createdDate,
			String patentCompany, Integer patentDate) {
		super();
		this.productUid = productUid;
		this.productCode = productCode;
		this.productName = productName;
		this.description = description;
		this.typeId = typeId;
		this.categoryId = categoryId;
		this.hsnCode = hsnCode;
		this.manufacturerName = manufacturerName;
		this.manufacturerCode = manufacturerCode;
		this.createdDate = createdDate;
		this.patentCompany = patentCompany;
		this.patentDate = patentDate;
	}

	public String getProductUid() {
		return productUid;
	}

	public void setProductUid(String productUid) {
		this.productUid = productUid;
	}

	public Long getProductCode() {
		return productCode;
	}

	public void setProductCode(Long productCode) {
		this.productCode = productCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Long getHsnCode() {
		return hsnCode;
	}

	public void setHsnCode(Long hsnCode) {
		this.hsnCode = hsnCode;
	}

	public String getManufacturerName() {
		return manufacturerName;
	}

	public void setManufacturerName(String manufacturerName) {
		this.manufacturerName = manufacturerName;
	}

	public Long getManufacturerCode() {
		return manufacturerCode;
	}

	public void setManufacturerCode(Long manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getPatentCompany() {
		return patentCompany;
	}

	public void setPatentCompany(String patentCompany) {
		this.patentCompany = patentCompany;
	}

	public Integer getPatentDate() {
		return patentDate;
	}

	public void setPatentDate(Integer patentDate) {
		this.patentDate = patentDate;
	}

	@Override
	public String toString() {
		return "ProductDto [productUid=" + productUid + ", productCode=" + productCode + ", productName=" + productName
				+ ", description=" + description + ", typeId=" + typeId + ", categoryId=" + categoryId + ", hsnCode="
				+ hsnCode + ", manufacturerName=" + manufacturerName + ", manufacturerCode=" + manufacturerCode
				+ ", createdDate=" + createdDate + ", patentCompany=" + patentCompany + ", patentDate=" + patentDate
				+ "]";
	}

}
