package com.project.eCommerce.Service;

import com.project.eCommerce.Entity.Product;
import com.project.eCommerce.Entity.ProductCategory;
import com.project.eCommerce.ResponseDTOs.ProductCategoryResponseDTO;
import com.project.eCommerce.ResponseDTOs.ProductResponseDTO;
import com.project.eCommerce.dao.ProductCategoryRepository;
import com.project.eCommerce.dao.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductRepositoryService {

    ProductRepository productRepository;
    ProductCategoryRepository productCategoryRepository;
    ObjectMapperService objectMapperService;

    public ProductRepositoryService(ProductRepository productRepository,
                                    ObjectMapperService objectMapperService,
                                    ProductCategoryRepository productCategoryRepository){
        this.productRepository=productRepository;
        this.objectMapperService=objectMapperService;
        this.productCategoryRepository=productCategoryRepository;
    }

    public List<ProductResponseDTO> getAllProducts(){
        List<Product> products=productRepository.findAll();
        return objectMapperService.mapToProductResponseDTO(products);
    }

    public List<ProductResponseDTO> getAllProductsByCategoryId(Long id){
        if(id==0){
            List<Product> products=productRepository.findAll();
            return objectMapperService.mapToProductResponseDTO(products);
        }
        else{
            List<Product> products=productRepository.findByCategoryId(id);
            return objectMapperService.mapToProductResponseDTO(products);
        }
    }

    public Page<ProductResponseDTO> getAllProductsByCategoryId(Long id, int page, int size, String sortBy){
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
//        Page<Product> products = productService.getAllProducts(pageable);
        if(id==0){
//            List<Product> products=productRepository.findAll();
            Page<Product> products=productRepository.findAll(pageable);
            return objectMapperService.mapToProductResponseDTO(products);
        }
        else{
            List<Product> products=productRepository.findByCategoryId(id);
            return objectMapperService.mapToProductResponseDTO(products);
        }
    }

    public List<ProductCategoryResponseDTO> getAllProductCategories(){
        List<ProductCategory> productCategories=productCategoryRepository.findAll();
        return objectMapperService.mapToProductCategoryResponseDTO(productCategories);
    }

    public List<ProductResponseDTO> getAllProductsByNameContaining(String name){
        List<Product> products=productRepository.findByNameContaining(name);
        return objectMapperService.mapToProductResponseDTO(products);
    }
}
