import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-product-search',
  imports: [],
  templateUrl: './product-search.component.html',
  styleUrl: './product-search.component.css'
})

export class ProductSearchComponent implements OnInit {

  constructor(private router:Router){

  }

  doSearch(value: string){
    this.router.navigate(['/search/',value]);
  }

  ngOnInit(){

  }

}
