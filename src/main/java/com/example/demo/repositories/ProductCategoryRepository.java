package com.example.demo.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.ProductCategory;

@Repository
@Qualifier(value="productCategoryRespository")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long>{

	List<ProductCategory> findByBestCategory(boolean bestCategory);
}
