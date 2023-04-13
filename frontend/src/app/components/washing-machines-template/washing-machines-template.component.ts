import {Component, Input, OnInit} from '@angular/core';
import {WashingMachine} from "../../models/WashingMachine";
import {Router} from "@angular/router";

@Component({
  selector: 'app-washing-machines-template',
  templateUrl: './washing-machines-template.component.html',
  styleUrls: ['./washing-machines-template.component.css']
})
export class WashingMachinesTemplateComponent implements OnInit {

  @Input() washingMachines: Array<WashingMachine> = [];

  @Input()
  getWashingMachines(): void{

  }

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  getWashingMachineProblems(id: number) {
    if(this.router.url === '/washingMachines'){
      this.router.navigate(["/washingMachines", id]);
    }
    if(this.router.url === '/completedAuction'){
      this.router.navigate(["/completedAuction", id]);
    }
  }

}
