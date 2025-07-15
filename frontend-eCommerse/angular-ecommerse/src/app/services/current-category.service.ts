import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CurrentCategoryService {

  private currentCategoryId:number=0;
  constructor() { }

  setCurrentCategoryId(id:number):void{
    this.currentCategoryId=id;
  }

  getCurrentCategoryId():number{
    return this.currentCategoryId;
  }
}
