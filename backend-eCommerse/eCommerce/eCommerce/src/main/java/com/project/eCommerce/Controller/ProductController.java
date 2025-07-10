package com.project.eCommerce.Controller;

import com.project.eCommerce.ResponseDTOs.ProductResponseDTO;
import com.project.eCommerce.Service.ProductRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins="http://localhost:4200/")
@RequestMapping("/r/products")
public class ProductController {

    ProductRepositoryService productRepositoryService;

    @Autowired
    public ProductController(ProductRepositoryService productRepositoryService){
        this.productRepositoryService=productRepositoryService;
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> getAllProducts(){
        return ResponseEntity.ok(productRepositoryService.getAllProducts());
    }

    @GetMapping("/search/findByCategoryId")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsByCategoryId(@RequestParam Long id){
        return ResponseEntity.ok(productRepositoryService.getAllProductsByCategoryId(id));
    }

    @GetMapping("/search/findByNameContaining")
    public ResponseEntity<List<ProductResponseDTO>> getAllProductsByNameContaining(@RequestParam String name){
        return ResponseEntity.ok(productRepositoryService.getAllProductsByNameContaining(name));
    }
}
