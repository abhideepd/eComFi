import { Product } from "./product";
import { Page } from "./page";

export class PagedProductsList {
  constructor(
    public Products:Product[],
    public page:Page
  ){

  }
}
