import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PensionerDisburseComponent } from './pensioner-disburse.component';

describe('PensionerDisburseComponent', () => {
  let component: PensionerDisburseComponent;
  let fixture: ComponentFixture<PensionerDisburseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PensionerDisburseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PensionerDisburseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
