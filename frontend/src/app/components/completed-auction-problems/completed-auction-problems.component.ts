import { Component, OnInit } from '@angular/core';
import {Problem} from "../../models/Problem";
import {WashingMachineService} from "../../services/washing-machine.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Repair} from "../../models/Repair";

@Component({
  selector: 'app-completed-auction-problems',
  templateUrl: './completed-auction-problems.component.html',
  styleUrls: ['./completed-auction-problems.component.css']
})
export class CompletedAuctionProblemsComponent implements OnInit {
  problems: Array<Problem> = [];

  constructor(
    public washingMachineService: WashingMachineService,
    private route: ActivatedRoute,
    private router: Router

  ) { }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.washingMachineService.getByIdWashingMachine(id)
      .subscribe(value => {
        this.problems = value.problems.filter(value1 => value1.workersFound);
      });
  }


  getRepairWinner(obj: Array<Repair>):Repair {
    return obj.reduce((r, e) => r.price! < e.price! ? r : e);
  }
}
