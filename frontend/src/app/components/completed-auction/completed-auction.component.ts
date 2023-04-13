import { Component, OnInit } from '@angular/core';
import {WashingMachine} from "../../models/WashingMachine";
import {WashingMachineService} from "../../services/washing-machine.service";

@Component({
  selector: 'app-completed-auction',
  templateUrl: './completed-auction.component.html',
  styleUrls: ['./completed-auction.component.css']
})
export class CompletedAuctionComponent implements OnInit {

  washingMachines: Array<WashingMachine> = [];
  getWashingMachines(): void{
    this.washingMachineService.getAllWashingMachines()
      .subscribe(value => {
        this.washingMachines = value.filter(value1 => value1.workersFound)
      });
  }


  constructor(public washingMachineService: WashingMachineService) {
  }

  ngOnInit(): void {
    this.getWashingMachines();
  }

}
