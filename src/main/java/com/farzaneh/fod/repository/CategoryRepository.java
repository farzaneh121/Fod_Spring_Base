package com.farzaneh.fod.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farzaneh.fod.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

	@Query("from Category c where c.language='EN'")
	List<Category> findAllCategory();

}
