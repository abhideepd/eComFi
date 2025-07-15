import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map, tap } from 'rxjs/operators';
import { Product } from '../common/product';
import { ProductCategory } from '../common/product-categories';
import { PagedProductsList } from '../common/paged-products-list';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  private baseUrl='http://localhost:8080/r';

  constructor(private httpClient: HttpClient) { }

  getProductList(theCategoryId: number): Observable<Product[]>{
    const searchUrl = `${this.baseUrl}/products/search/findByCategoryId?id=${theCategoryId}`;
    return this.httpClient.get<Product[]>(searchUrl);
  }

  getProductCategoriesList(): Observable<ProductCategory[]>{
    const searchUrl = `${this.baseUrl}/product_category`;
    return this.httpClient.get<ProductCategory[]>(searchUrl);
  }

  getProductListByName(theName: string): Observable<Product[]>{
    const searchUrl = `${this.baseUrl}/products/search/findByNameContaining?name=${theName}`;
    return this.httpClient.get<Product[]>(searchUrl);
  }

  getProductListPaginated(thePage:number,
                          thePageSize:number,
                          theCategoryId:number): Observable<PagedProductsList>{
    const searchUrl = `${this.baseUrl}/products/search/findByCategoryId?id=${theCategoryId}`
                        + `&page=${thePage}` + `&size=${thePageSize}`;
    return this.httpClient.get<PagedProductsList>(searchUrl);
  }

}
