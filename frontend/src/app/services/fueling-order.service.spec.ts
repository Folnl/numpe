import { TestBed } from '@angular/core/testing';

import { FuelingOrderService } from './fueling-order.service';

describe('FuelingOrderService', () => {
  let service: FuelingOrderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FuelingOrderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
