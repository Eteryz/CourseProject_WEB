import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {WashingMachinesComponent} from "./components/washing-machines/washing-machines.component";
import {ProblemsComponent} from "./components/problems/problems.component";
import {
  WashingMachineProblemsComponent
} from "./components/washing-machine-problems/washing-machine-problems.component";
import {RepairComponent} from "./components/repair-component/repair.component";

const routes: Routes = [
  {path: "", redirectTo: "washingMachines", pathMatch:"full"},
  {path: "washingMachines", component: WashingMachinesComponent},
  {path: "washingMachines/:id", component: WashingMachineProblemsComponent, },
  {path: "problems", component: ProblemsComponent},
  {path: "problem/:id", component: RepairComponent, },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
