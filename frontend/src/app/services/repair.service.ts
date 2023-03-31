import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Problem} from "../models/Problem";
import {Repair} from "../models/Repair";

@Injectable({
  providedIn: 'root'
})
export class RepairService {

  configUrl: string = "http://localhost:8080/api/v1/repair";

  constructor(private http: HttpClient) { }

  save(repair: Repair): Observable<Repair>{
    return this.http.post<Repair>(this.configUrl + "/add",repair);
  }
}
