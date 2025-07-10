package com.project.eCommerce.Controller;

import com.project.eCommerce.ResponseDTOs.ProductCategoryResponseDTO;
import com.project.eCommerce.Service.ProductRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/r/product_category")
public class ProductCategoryController {

    ProductRepositoryService productRepositoryService;

    @Autowired
    public ProductCategoryController(ProductRepositoryService productRepositoryService){
        this.productRepositoryService=productRepositoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductCategoryResponseDTO>> getAllCategories(){
        return ResponseEntity.ok(productRepositoryService.getAllProductCategories());
    }

}
