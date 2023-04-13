import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { WashingMachinesComponent } from './components/washing-machines/washing-machines.component';
import { ProblemsComponent } from './components/problems/problems.component';
import {HttpClientModule} from "@angular/common/http";
import { WashingMachineProblemsComponent } from './components/washing-machine-problems/washing-machine-problems.component';
import { RepairComponent } from './components/repair-component/repair.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { CompletedAuctionComponent } from './components/completed-auction/completed-auction.component';
import { WashingMachinesTemplateComponent } from './components/washing-machines-template/washing-machines-template.component';
import { CompletedAuctionProblemsComponent } from './components/completed-auction-problems/completed-auction-problems.component';

@NgModule({
  declarations: [
    AppComponent,
    WashingMachinesComponent,
    ProblemsComponent,
    WashingMachineProblemsComponent,
    RepairComponent,
    CompletedAuctionComponent,
    WashingMachinesTemplateComponent,
    CompletedAuctionProblemsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
