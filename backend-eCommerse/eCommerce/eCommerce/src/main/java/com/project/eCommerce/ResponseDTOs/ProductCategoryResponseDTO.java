package com.project.eCommerce.ResponseDTOs;

import com.project.eCommerce.Entity.Product;

import java.util.Set;

public class ProductCategoryResponseDTO {

    private Long id;

    private String categoryName;

    private Long categoryIndex;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
        setCategoryIndex(id);
    }

    @Override
    public String toString() {
        return "ProductCategoryResponseDTO{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryIndex=" + categoryIndex +
                '}'+'\n';
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Long getCategoryIndex() {
        return categoryIndex;
    }

    public void setCategoryIndex(Long categoryIndex) {
        this.categoryIndex = categoryIndex;
    }
}
