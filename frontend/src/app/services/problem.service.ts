import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {WashingMachine} from "../models/WashingMachine";
import {Problem} from "../models/Problem";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProblemService {

  configUrl: string = "http://localhost:8080/api/v1/problem";

  constructor(private http: HttpClient) { }

  getAllProblem(): Observable<Array<Problem>>{
    return this.http.get<Array<Problem>>(this.configUrl + "");
  }
}
