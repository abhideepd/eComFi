import { ProductCategoryMenuComponent } from './components/product-category-menu/product-category-menu.component';
import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { ProductSearchComponent } from "./components/product-search/product-search.component";

@Component({
  selector: 'app-root',
  imports: [RouterModule, CommonModule, ProductCategoryMenuComponent, ProductSearchComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'angular-ecommerse';

  constructor(){

  }

}
