import { Component, OnInit } from '@angular/core';
import {Repair, RepairImpl} from "../../models/Repair";
import {ActivatedRoute, Router} from "@angular/router";
import {RepairService} from "../../services/repair.service";
import {ProblemService} from "../../services/problem.service";
import {Problem, ProblemImpl} from "../../models/Problem";
import {WashingMachineService} from "../../services/washing-machine.service";
import {WashingMachine, WashingMachineImpl} from "../../models/WashingMachine";

@Component({
  selector: 'app-repair-component',
  templateUrl: './repair.component.html',
  styleUrls: ['./repair.component.css']
})
export class RepairComponent implements OnInit {

  repairForm: Repair = new RepairImpl();

  problemInfo: Problem;
  washingMachineInfo: WashingMachine;
  today: string = new Date().toISOString().split("T")[0];

  constructor( private route: ActivatedRoute,
               private router: Router,
               private repairService: RepairService,
               private problemService: ProblemService,
               private washingMachineService: WashingMachineService
               ) {
    this.problemInfo = new ProblemImpl();
    this.washingMachineInfo = new WashingMachineImpl();
  }

  ngOnInit(): void {
    this.repairForm.problemId = this.route.snapshot.params['id'];
    this.problemService.getProblemById(this.repairForm.problemId)
      .subscribe({
        next: value => {
          this.problemInfo = value;
          this.washingMachineService.getByIdWashingMachine(this.problemInfo?.washingMachineId)
            .subscribe({
                next: value => {
                  this.washingMachineInfo = value;
                }
              }
            );
        }
      });

  }


  submit() {
    console.log(this.repairForm)
    this.repairService.save(this.repairForm)
      .subscribe(
      {
        next: data => {
          console.log(data);
          this.router.navigate(["/problems"]);
        },
        error: err => {
          console.log(err)
          const alertPlaceholder = document.getElementById('liveAlertPlaceholder');
          // @ts-ignore
          alertPlaceholder.textContent = "Send data failed"
          // this.errorMessage = err.error.message;
        }
      });
  }
}
