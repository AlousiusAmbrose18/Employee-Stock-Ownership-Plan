import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  constructor(private empService: EmployeeService,
    private router: Router) 
    { }

  employee : Employee = new Employee();
  

  ngOnInit(): void {
  }

  saveEmployee(){
    
    this.empService.addEmployee(this.employee).subscribe( data =>{
      console.log(data);
      this.goToEmployee();
    });
      

  }


  goToEmployee(){
    this.router.navigate(['employees']);
  }

  onSubmit(){
    console.log(this.employee);
    this.saveEmployee();
  }

}
