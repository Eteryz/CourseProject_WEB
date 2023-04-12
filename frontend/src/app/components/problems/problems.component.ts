import { Component, OnInit } from '@angular/core';
import {ProblemService} from "../../services/problem.service";
import {Problem} from "../../models/Problem";

@Component({
  selector: 'app-problems',
  templateUrl: './problems.component.html',
  styleUrls: ['./problems.component.css']
})
export class ProblemsComponent implements OnInit {

  problems: Array<Problem> = [];
  search: string = "";
  problemsCopy: Array<Problem> = [];

  constructor(private problemService: ProblemService) {
  }

  ngOnInit(): void {
    this.gelProblems();
  }

  searchOnClick() {
    console.log(this.search)
    this.problems = this.problemsCopy.filter(
      value =>
        value.description.indexOf(this.search) >= 0 ||
        value.price.toString().indexOf(this.search) >= 0 ||
        value.finishDate?.toString().indexOf(this.search) >= 0 ||
        ("Problem №"+value.id).toString().indexOf(this.search) >=0
    );
  }


  gelProblems(){
    this.problemService.getAllProblem()
      .subscribe(value => {
        this.problems = value.filter(value1 => !value1.workersFound);
        this.problemsCopy = this.problems;
      });
  }
}
