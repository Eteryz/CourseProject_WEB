export interface Repair {
  id: number;
  phoneNumber: string;
  email: string;
  price: number;
  fullName: string;
  date: Date;
  problemId: number;
}

export class RepairImpl implements Repair{
  date: Date = new Date();
  email: string = "";
  fullName: string = "";
  id: number = -1;
  phoneNumber: string = "";
  price: number = 0;
  problemId: number = -1;

}
