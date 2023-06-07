import { TestBed } from '@angular/core/testing';

import { ShampooService } from './shampoo.service';

describe('ShampooService', () => {
  let service: ShampooService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ShampooService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
