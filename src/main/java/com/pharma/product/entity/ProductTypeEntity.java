package com.pharma.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "productType", schema = "product_schema")
public class ProductTypeEntity {

	@Id
	@Column(name = "type_id")
	private int typeId;

	@Column(name = "type_name")
	private String typeName;

	public ProductTypeEntity() {
		super();
	}

	public ProductTypeEntity(int typeId, String typeName) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "ProductTypeEntity [typeId=" + typeId + ", typeName=" + typeName + "]";
	}

}
