import { Component, OnInit } from '@angular/core';
import {ProblemService} from "../../services/problem.service";
import {Problem} from "../../models/Problem";

@Component({
  selector: 'app-problems',
  templateUrl: './problems.component.html',
  styleUrls: ['./problems.component.css']
})
export class ProblemsComponent implements OnInit {

  problems: Array<Problem>;

  constructor(private problemService: ProblemService) {
    this.problems = new Array<Problem>();
  }

  ngOnInit(): void {
    this.problemService.getAllProblem()
      .subscribe(value => {
        this.problems = value;
      });
  }

}
