package com.pharma.product.entity;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product", schema = "product_schema")
public class ProductEntity {

    @Id
    @Column(name = "product_uid")
    private UUID productUid;

    @Column(name = "product_code", nullable = false)
    private Long productCode;

    @Column(name = "product_name", nullable = false)
    private String productName;

    @Column(name = "description")
    private String description;

    @Column(name = "hsn_code", nullable = false)
    private Long hsnCode;

    @Column(name = "manufacturer_name")
    private String manufacturerName;

    @Column(name = "manufacturer_code", nullable = false)
    private Long manufacturerCode;

    @Column(name = "created_date", nullable = false)
    private LocalDate createdDate;

    @Column(name = "patent_company", nullable = false)
    private String patentCompany;

    @Column(name = "patent_date", nullable = false)
    private Integer patentDate;
    
    @OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private CategoryEntity categoryEntity;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "type_id")
	private ProductTypeEntity productTypeEntity;

	public ProductEntity() {}

	public ProductEntity(UUID productUid, Long productCode, String productName, String description,
			Long hsnCode, String manufacturerName, Long manufacturerCode, LocalDate createdDate,
			String patentCompany, Integer patentDate, CategoryEntity categoryEntity,
			ProductTypeEntity productTypeEntity) {
		super();
		this.productUid = productUid;
		this.productCode = productCode;
		this.productName = productName;
		this.description = description;		
		this.hsnCode = hsnCode;
		this.manufacturerName = manufacturerName;
		this.manufacturerCode = manufacturerCode;
		this.createdDate = createdDate;
		this.patentCompany = patentCompany;
		this.patentDate = patentDate;
		this.categoryEntity = categoryEntity;
		this.productTypeEntity = productTypeEntity;
	}

	public UUID getProductUid() {
		return productUid;
	}

	public void setProductUid(UUID productUid) {
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

	public CategoryEntity getCategoryEntity() {
		return categoryEntity;
	}

	public void setCategoryEntity(CategoryEntity categoryEntity) {
		this.categoryEntity = categoryEntity;
	}

	public ProductTypeEntity getProductTypeEntity() {
		return productTypeEntity;
	}

	public void setProductTypeEntity(ProductTypeEntity productTypeEntity) {
		this.productTypeEntity = productTypeEntity;
	}
}