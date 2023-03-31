import { Component, OnInit } from '@angular/core';
import {Repair} from "../../models/Repair";
import {ActivatedRoute, Router} from "@angular/router";
import {RepairService} from "../../services/repair.service";

@Component({
  selector: 'app-repair-component',
  templateUrl: './repair.component.html',
  styleUrls: ['./repair.component.css']
})
export class RepairComponent implements OnInit {
  repairForm: Repair = {
    id:0,
    fullName:"",
    date: new Date(),
    price:0,
    email:"",
    phoneNumber:"",
    problemId: 0
  };

  constructor( private route: ActivatedRoute,
               private router: Router,
               private repairService: RepairService) {
  }

  ngOnInit(): void {
    this.repairForm.problemId = this.route.snapshot.params['id'];

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
