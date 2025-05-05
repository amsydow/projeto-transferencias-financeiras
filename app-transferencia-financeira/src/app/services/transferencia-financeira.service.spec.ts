import { TestBed } from '@angular/core/testing';

import { TransferenciaFinanceiraService } from './transferencia-financeira.service';

describe('TransferenciaFinanceiraService', () => {
  let service: TransferenciaFinanceiraService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TransferenciaFinanceiraService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
