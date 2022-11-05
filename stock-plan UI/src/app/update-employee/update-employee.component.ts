import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-update-employee',
  templateUrl: './update-employee.component.html',
  styleUrls: ['./update-employee.component.css']
})
export class UpdateEmployeeComponent implements OnInit {

  constructor(private empService: EmployeeService, private route: ActivatedRoute ,
      private router : Router) { }

  employeeNumber: any;
  employee: Employee = new Employee();

  ngOnInit(): void {

    this.employeeNumber = this.route.snapshot.params['employeeNumber'];
    console.log(this.employeeNumber);
    this.empService.getEmployeeByEmployeeNumber(this.employeeNumber).subscribe(data=>{
      this.employee = data;
    });
    
    
  }
  onSubmit(){
    this.updateEmployee();
  }
  updateEmployee() {
    this.empService.updateEmployee(this.employee).subscribe(data=>{
      this.employee= new Employee();
      this.goToEmployee();
    });
  }

  goToEmployee(){
    this.router.navigate(['employees']);
  }

}
