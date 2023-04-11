import {Problem} from "./Problem";

export interface WashingMachine{
  id: number;
  name: string;
  company: string;
  finishDate: Date;
  estimatedDate: Date;
  workersFound: boolean;
  problems: Array<Problem>;
}

export class WashingMachineImpl implements WashingMachine{
  company: string = "";
  estimatedDate: Date = new Date();
  finishDate: Date = new Date();
  id: number = -1;
  name: string = "";
  problems: Array<Problem> = [];
  workersFound: boolean = false;

}
