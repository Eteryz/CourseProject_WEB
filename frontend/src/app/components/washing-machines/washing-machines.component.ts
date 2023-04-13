import {Component, OnInit} from '@angular/core';
import {WashingMachineService} from "../../services/washing-machine.service";
import {WashingMachine} from "../../models/WashingMachine";

@Component({
  selector: 'app-washing-machines',
  templateUrl: './washing-machines.component.html',
  styleUrls: ['./washing-machines.component.css']
})
export class WashingMachinesComponent implements OnInit {

  washingMachines: Array<WashingMachine> = [];
  getWashingMachines(): void{
    this.washingMachineService.getAllWashingMachines()
      .subscribe(value => {
        this.washingMachines = value.filter(value1 => !value1.workersFound)
      });
  }


  constructor(public washingMachineService: WashingMachineService) {
  }

  ngOnInit(): void {
    this.getWashingMachines();
  }
}
