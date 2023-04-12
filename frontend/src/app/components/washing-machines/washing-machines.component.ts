import {Component, OnInit} from '@angular/core';
import {WashingMachineService} from "../../services/washing-machine.service";
import {WashingMachine} from "../../models/WashingMachine";
import {Router} from "@angular/router";

@Component({
  selector: 'app-washing-machines',
  templateUrl: './washing-machines.component.html',
  styleUrls: ['./washing-machines.component.css']
})
export class WashingMachinesComponent implements OnInit {

  public arr: Array<WashingMachine>;


  constructor(public washingMachineService: WashingMachineService,
              private router: Router,) {
    this.arr = new Array<WashingMachine>();
  }

  ngOnInit(): void {
    this.washingMachineService.getAllWashingMachines()
      .subscribe(value => {
        this.arr = value.filter(value1 => !value1.workersFound)
      });
  }

  getWashingMachineProblems(id: number) {
    this.router.navigate(["/washingMachines", id]);
  }
}
