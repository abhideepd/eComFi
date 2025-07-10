package com.project.eCommerce.dao;

import com.project.eCommerce.Entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;


public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByCategoryId(@Param("id") Long id, Pageable pageable);
    List<Product> findByCategoryId(@Param("id") Long id);
    List<Product> findByNameContaining(@Param("id") String name, Pageable pageable);
    List<Product> findByNameContaining(@Param("id") String name);
}
