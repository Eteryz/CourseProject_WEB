import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WashingMachinesTemplateComponent } from './washing-machines-template.component';

describe('WashingMachinesTemplateComponent', () => {
  let component: WashingMachinesTemplateComponent;
  let fixture: ComponentFixture<WashingMachinesTemplateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WashingMachinesTemplateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WashingMachinesTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
