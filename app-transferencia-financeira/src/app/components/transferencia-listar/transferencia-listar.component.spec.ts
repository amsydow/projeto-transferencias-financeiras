import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TransferenciaListarComponent } from './transferencia-listar.component';

describe('TransferenciaListarComponent', () => {
  let component: TransferenciaListarComponent;
  let fixture: ComponentFixture<TransferenciaListarComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TransferenciaListarComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TransferenciaListarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
