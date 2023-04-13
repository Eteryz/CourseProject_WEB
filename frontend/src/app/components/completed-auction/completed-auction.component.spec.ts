import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CompletedAuctionComponent } from './completed-auction.component';

describe('CompletedAuctionComponent', () => {
  let component: CompletedAuctionComponent;
  let fixture: ComponentFixture<CompletedAuctionComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CompletedAuctionComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CompletedAuctionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
