import { TestBed } from '@angular/core/testing';

import { CurrentClickedProductService } from './current-clicked-product.service';

describe('CurrentClickedProductService', () => {
  let service: CurrentClickedProductService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(CurrentClickedProductService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
