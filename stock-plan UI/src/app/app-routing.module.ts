import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { EmployeeComponent } from './employee/employee.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';


const routes: Routes = [
  { path: 'employees', component: EmployeeComponent },
  {path:'add-employee', component: AddEmployeeComponent},
  // { path:'', redirectTo:'employees', pathMatch:'full'},
  {path:'update-employee/:employeeNumber', component:UpdateEmployeeComponent}
  {
    path:'newrouting',
    loadChildren :()=>import('./new-module/new-module.module').then(m=>m.NewModuleModule) 
  }
  
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
