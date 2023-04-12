import {Repair} from "./Repair";

export interface Problem {
  id: number;
  description: string;
  price: number;
  finishDate:Date;
  washingMachineId: number;
  workersFound: boolean;
  repairs: Array<Repair>;
}

export class ProblemImpl implements Problem{
  description: string = "";
  finishDate: Date = new Date();
  id: number = -1;
  price: number = 0;
  repairs: Array<Repair> = [];
  workersFound = false;
  washingMachineId: number = -1;

}
