package com.farzaneh.fod.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farzaneh.fod.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("from Product p  where p.productName=?1 and p.productCategory.language='EN'")
	List<Product> findByProductName(String name);

	@Query("from Product p where p.productName=?1 and p.productCategory.categoryId=?2 and p.productCategory.language='EN'")
	List<Product> findBaseProductAndCategory(String productName, Long categoryId);

	@Query("from Product p where p.productCategory.categoryId=?1 and p.productCategory.language='EN'")
	List<Product> findBaseCategory(Long categoryId);

	@Query("from Product p where p.productCategory.language='EN'")
	List<Product> findAllProduct();

	@Query("from Product p  where p.productId=?1 and p.productCategory.language='EN'")
	Optional<Product> findProductById(Long id);

}
