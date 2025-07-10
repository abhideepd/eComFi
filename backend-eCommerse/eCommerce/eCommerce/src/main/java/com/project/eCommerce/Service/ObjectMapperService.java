package com.project.eCommerce.Service;

import com.project.eCommerce.Entity.Product;
import com.project.eCommerce.Entity.ProductCategory;
import com.project.eCommerce.ResponseDTOs.ProductCategoryResponseDTO;
import com.project.eCommerce.ResponseDTOs.ProductResponseDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ObjectMapperService {

    public List<ProductResponseDTO> mapToProductResponseDTO(List<Product> products){
        List<ProductResponseDTO> allProducts=new ArrayList<ProductResponseDTO>();
        for(Product p:products){
            allProducts.add(mapToProductResponseDTO(p));
        }
        return allProducts;
    }

    public ProductResponseDTO mapToProductResponseDTO(Product p){
        ProductResponseDTO productResponseDTO=new ProductResponseDTO();
        productResponseDTO.setId(p.getId());
        productResponseDTO.setSku(p.getSku());
        productResponseDTO.setName(p.getName());
        productResponseDTO.setDescription(p.getDescription());
        productResponseDTO.setUnitPrice(p.getUnitPrice());
        productResponseDTO.setImageUrl(p.getImageUrl());
        productResponseDTO.setActive(p.getActive());
        productResponseDTO.setUnitsInStock(p.getUnitsInStock());
        productResponseDTO.setDataCreated(p.getDataCreated());
        productResponseDTO.setLastUpdated(p.getLastUpdated());
        return productResponseDTO;
    }

    public List<ProductCategoryResponseDTO> mapToProductCategoryResponseDTO(List<ProductCategory> productCategories){
        List<ProductCategoryResponseDTO> allProductCategories=new ArrayList<>();
        for(ProductCategory p:productCategories){
            allProductCategories.add(mapToProductCategoryResponseDTO(p));
        }
        return allProductCategories;
    }

    public ProductCategoryResponseDTO mapToProductCategoryResponseDTO(ProductCategory productCategory){
        ProductCategoryResponseDTO productCategoryResponseDTO=new ProductCategoryResponseDTO();
        productCategoryResponseDTO.setId(productCategory.getId());
        productCategoryResponseDTO.setCategoryName(productCategory.getCategoryName());
        return productCategoryResponseDTO;
    }

}
