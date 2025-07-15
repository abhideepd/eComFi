import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ProductService } from '../../services/product.service';
import { ProductCategory } from '../../common/product-categories';


@Component({
  selector: 'app-product-category-menu',
  imports: [RouterModule, CommonModule],
  templateUrl: './product-category-menu.component.html',
  styleUrl: './product-category-menu.component.css'
})
export class ProductCategoryMenuComponent implements OnInit {

  productCategories: ProductCategory[]=[];

  constructor(private productService: ProductService){

  }

  ngOnInit():void{
    this.listProductCategories();
  }

  listProductCategories(){
    this.productService.getProductCategoriesList().subscribe(
      data=>{
        this.productCategories=data;
      }
    );
  }
}
