import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {WashingMachine} from "../models/WashingMachine";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class WashingMachineService {

  configUrl: string = "http://localhost:8080/api/v1/washingMachine";

  constructor(private http: HttpClient) {
  }

  getByIdWashingMachine(id: number | undefined):Observable<WashingMachine> {
    return this.http.get<WashingMachine>(this.configUrl + "/"+id);
  }

  getAllWashingMachines(): Observable<Array<WashingMachine>> {
    return this.http.get<Array<WashingMachine>>(this.configUrl + "");
  }
}
