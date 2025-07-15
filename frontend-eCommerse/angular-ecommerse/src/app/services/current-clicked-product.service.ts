import { Injectable } from '@angular/core';
import { Product } from '../common/product';

@Injectable({
  providedIn: 'root'
})
export class CurrentClickedProductService {

  constructor() { }

  private product: Product | null=null;

  setProduct(product:Product):void{
    this.product=product;
  }

  getProduct():Product|null{
    return this.product;
  }

  clearProduct(): void{
    this.product=null;
  }
}
