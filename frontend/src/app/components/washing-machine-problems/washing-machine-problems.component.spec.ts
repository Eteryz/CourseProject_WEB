import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashingMachineProblemsComponent } from './washing-machine-problems.component';

describe('WashingMachineProblemsComponent', () => {
  let component: WashingMachineProblemsComponent;
  let fixture: ComponentFixture<WashingMachineProblemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashingMachineProblemsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WashingMachineProblemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
