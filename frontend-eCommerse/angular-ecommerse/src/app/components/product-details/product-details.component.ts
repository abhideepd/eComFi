import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CurrencyPipe} from '@angular/common';
import { Product } from '../../common/product';
import { CurrentClickedProductService } from '../../services/current-clicked-product.service';

@Component({
  selector: 'app-product-details',
  imports: [CurrencyPipe],
  templateUrl: './product-details.component.html',
  styleUrl: './product-details.component.css'
})
export class ProductDetailsComponent implements OnInit{

  currentProduct?:Product|null;
  constructor(private route:ActivatedRoute, private router:Router, private currentClickedProductService:CurrentClickedProductService){

  }


  ngOnInit(){
    this.currentProduct=this.currentClickedProductService.getProduct();
  }

  goBack(){
    this.router.navigate(['/products/']);
  }
}
