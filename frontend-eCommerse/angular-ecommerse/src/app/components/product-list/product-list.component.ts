import { CurrentCategoryService } from './../../services/current-category.service';
import { CurrentClickedProductService } from '../../services/current-clicked-product.service';
import { Component, OnInit } from '@angular/core';
import { CurrencyPipe, CommonModule } from '@angular/common';
import { ProductService } from '../../services/product.service';
import { Product } from '../../common/product';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';

@Component({
  selector: 'app-product-list',
  imports: [CurrencyPipe, CommonModule, RouterModule],
  templateUrl: './product-list-grid.component.html',
  styleUrl: './product-list.component.css'
})

export class ProductListComponent implements OnInit{

  products: Product[]=[];
  thePageNumber:number=1;
  thePageSize:number=10;
  theTotalElements:number=0;

  constructor(private productService: ProductService, private route:ActivatedRoute, private router:Router, private currentClickedProductService:CurrentClickedProductService, private currentCategoryService:CurrentCategoryService){

  }

  ngOnInit():void{
    this.route.paramMap.subscribe(()=>{
      this.handleProductFilter();
    });
  }

  goInsideProduct(currentProduct:Product){
    this.currentClickedProductService.setProduct(currentProduct);
    this.router.navigate(['/product/']);
  }

  handleProductFilter(){
    const customSearch: boolean = this.route.snapshot.paramMap.has('keyword');
    if(customSearch){
      this.listProductsByName();
    }
    else{
      this.listProducts();
    }
  }

  listProductsByName(){
    const value = this.route.snapshot.paramMap.get('keyword');
    this.productService.getProductListByName(String(value)).subscribe(
      data => {
        this.products=data;
      }
    );
  }

  listProducts(){
    const value = this.route.snapshot.params['id'];
    if(value!=null){
      const temp:number=Number(value);
      this.currentCategoryService.setCurrentCategoryId(temp);
    }
    const currentCategoryId:number=this.currentCategoryService.getCurrentCategoryId();
    this.productService.getProductList(currentCategoryId).subscribe(
        data => {
          this.products=data;
        }
    );
    this.productService.getProductListPaginated(currentCategoryId,
                                                this.thePageNumber,
                                                this.thePageSize).subscribe(
                                                  data=>{
                                                    this.products=data.Products;
                                                    this.thePageNumber=data.page.number;
                                                    this.thePageSize=data.page.size;
                                                    this.theTotalElements=data.page.totalElements;
                                                  }
                                                );
  }

}
