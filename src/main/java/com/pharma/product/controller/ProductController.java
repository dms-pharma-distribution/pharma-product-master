package com.pharma.product.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.opencsv.exceptions.CsvValidationException;
import com.pharma.product.dto.ProductCodesDto;
import com.pharma.product.dto.ProductDto;
import com.pharma.product.service.ProductService;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	private ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping("/create")
	public void createProduct(@RequestBody ProductDto productDto) {
		productService.createProduct(productDto);
	}

	@PutMapping("/update")
	public void updateProduct(@RequestBody ProductDto productDto) {
		productService.updateProduct(productDto);
	}

	@DeleteMapping("/deleteByProductId/{productId}")
	public void deleteByProductUid(@PathVariable String productUid) {
		productService.deleteByProductUid(productUid);
	}

	@GetMapping("/findByProductUid/{productUid}")
	public ProductDto findByProductUid(@PathVariable String productUid) {
		return productService.findByProductUid(productUid);
	}

	@GetMapping("/findByProductCode/{productCode}")
	public ProductDto findByProductCode(@PathVariable int productCode) {
		return productService.findByProductCode(productCode);
	}

	@GetMapping("/findByProductCodes")
	public List<ProductDto> findByProductCodes(@RequestBody ProductCodesDto productCodesDto) {
		return productService.findByProductCodes(productCodesDto);
	}

	@GetMapping("/search")
	public List<ProductDto> productTypeAheadSearch(@RequestParam("searchQuery") String searchQuery) {
		return productService.productTypeAheadSearch(searchQuery);
	}

	@PostMapping("/uploadProducts")
	public void uploadAndInsertProducts(@RequestParam("file") MultipartFile file) {
		try {
			productService.uploadAndInsertProducts(file);
		} catch (CsvValidationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}