package com.pharma.product.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pharma.product.entity.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {
	Optional<ProductEntity> findByProductCode(long productCode);

	public List<ProductEntity> findByProductCodeIn(List<Long> productCodes);

	@Query("SELECT p FROM ProductEntity p WHERE " + "LOWER(p.description) LIKE LOWER(CONCAT('%', :query, '%')) OR "
			+ "LOWER(p.productName) LIKE LOWER(CONCAT('%', :query, '%')) OR "
			+ "LOWER(p.patentCompany) LIKE LOWER(CONCAT('%', :query, '%')) OR "
			+ "LOWER(p.manufacturerName) LIKE LOWER(CONCAT('%', :query, '%'))")
	List<ProductEntity> productTypeAheadSearch(@Param("query") String query);

}
