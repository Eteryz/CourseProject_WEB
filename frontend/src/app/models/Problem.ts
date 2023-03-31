import {Repair} from "./Repair";

export interface Problem {
  id: number;
  description: string;
  price: number;
  estimatedDate: Date;
  finishDate:Date;
  washingMachineId: number;
  repairs: Array<Repair>;
}
