import { Routes } from '@angular/router';
import { ProductListComponent } from './components/product-list/product-list.component';
import { ProductDetailsComponent } from './components/product-details/product-details.component';

export const routes: Routes = [

  {
    path: 'category/:id',
    component: ProductListComponent
  },
  {
    path: 'product',
    component: ProductDetailsComponent
  },
  {
    path: 'search/:keyword',
    component: ProductListComponent
  },
  {
    path: 'category',
    component: ProductListComponent
  },
  {
    path: 'products',
    component: ProductListComponent
  },
  {
    path: 'products',
    redirectTo:'/products',
    pathMatch:'full'
  },
  {
    path: '',
    redirectTo:'/products',
    pathMatch:'full'
  }

];
