export interface Repair {
  id: number;
  phoneNumber: string;
  email: string;
  price: number | undefined;
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
  price: undefined = undefined;
  problemId: number = -1;

}
