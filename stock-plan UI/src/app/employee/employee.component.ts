import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ColDef } from 'ag-grid-community';
import { Employee } from '../employee';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-employee',
  templateUrl: './employee.component.html',
  styleUrls: ['./employee.component.css'],
})
export class EmployeeComponent implements OnInit {
  employees: Employee[] = [];

  constructor(private empService: EmployeeService, private router: Router) {}

  ngOnInit(): void {
    this.getEmployees();
  }

  private getEmployees() {
    this.empService.getEmployeeList().subscribe((data) => {
      this.employees = data;

      console.log(this.employees);
    });
  }

  updateEmployee(employeeNumber: any) {
    this.router.navigate(['update-employee', employeeNumber]);
  }

  deleteEmployee(employeeNumber: any) {
    this.empService.deleteEmployee(employeeNumber).subscribe((data) => {
      this.getEmployees();
    });
  }

  addEmployeeHandler() {
    this.router.navigate(['add-employee']);
  }

  // Each Column Definition results in one Column.
  public columnDefs: ColDef[] = [
    { field: 'employeeId' },
    { field: 'employeeNumber' },
    { field: 'fullName' },
    { field: 'emailId' },
    { field: 'band' },
    { field: 'location' },
    { field: 'employeeStatus' },
    { field: 'yearOfExperience' },
  ];

  // DefaultColDef sets props common to all Columns
  public defaultColDef: ColDef = {
    sortable: true,
    filter: true,
  };
}
