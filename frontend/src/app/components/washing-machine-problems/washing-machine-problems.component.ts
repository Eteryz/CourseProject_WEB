import {Component, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import { Problem } from 'src/app/models/Problem';
import {WashingMachineService} from "../../services/washing-machine.service";
import {ActivatedRoute, NavigationEnd, Router} from "@angular/router";
import {WashingMachine} from "../../models/WashingMachine";
import {filter} from "rxjs";

@Component({
  selector: 'app-washing-machine-problems',
  templateUrl: './washing-machine-problems.component.html',
  styleUrls: ['./washing-machine-problems.component.css']
})
export class WashingMachineProblemsComponent implements OnInit, OnChanges {

  washingMachine: WashingMachine | undefined;
  problems: Array<Problem>;
  constructor(public washingMachineService: WashingMachineService,
              private route: ActivatedRoute,
              private router: Router,
              ) {
    this.problems = new Array<Problem>();
  }

  ngOnInit(): void {
    let id = this.route.snapshot.params['id'];
    this.washingMachineService.getByIdWashingMachine(id)
      .subscribe(value => {
        this.washingMachine = value;
        this.problems = value.problems.filter(value1 => !value1.workersFound);
      });
  }

  ngOnChanges(changes: SimpleChanges): void {

  }


  clickProblem(a: Problem) {
    this.router.navigate(['problem/'+ a.id]);
  }
}
