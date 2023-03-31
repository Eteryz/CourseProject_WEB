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
