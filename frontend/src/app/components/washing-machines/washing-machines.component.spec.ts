import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashingMachinesComponent } from './washing-machines.component';

describe('WashingMachinesComponent', () => {
  let component: WashingMachinesComponent;
  let fixture: ComponentFixture<WashingMachinesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashingMachinesComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WashingMachinesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
