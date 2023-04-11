import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Problem} from "../models/Problem";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment.prod";

@Injectable({
  providedIn: 'root'
})
export class ProblemService {

  configUrl = environment.baseURL + '/api/v1/problem';

  constructor(private http: HttpClient) { }

  getAllProblem(): Observable<Array<Problem>>{
    return this.http.get<Array<Problem>>(this.configUrl + "");
  }

  getProblemById(id: number): Observable<Problem> {
    return this.http.get<Problem>(this.configUrl + "/" + id);
  }
}
