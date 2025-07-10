package com.project.eCommerce.dao;

import com.project.eCommerce.Entity.Product;
import com.project.eCommerce.Entity.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RepositoryRestResource(path="product-category", collectionResourceRel = "productFFCategory")
public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
