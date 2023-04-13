import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompletedAuctionProblemsComponent } from './completed-auction-problems.component';

describe('CompletedAuctionProblemsComponent', () => {
  let component: CompletedAuctionProblemsComponent;
  let fixture: ComponentFixture<CompletedAuctionProblemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompletedAuctionProblemsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompletedAuctionProblemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
