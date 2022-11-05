import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from './employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private http:HttpClient) { }

  private baseUrl="http://localhost:8080/commonController/getByEmployeeNumber";

  private deleteUrl ="http://localhost:8080/commonController/deleteByEmployeeNumber";

  getEmployeeList():Observable<Employee[]>
  {
    return  this.http.get<Employee[]>("http://localhost:8080/commonController/getAllEmployee"); 
  }

  addEmployee(employee : Employee): Observable<object>{
    console.log(employee);
    return this.http.post("http://localhost:8080/commonController/saveEmployeeDetails", employee);
  }

  getEmployeeByEmployeeNumber(employeeNumber:any):Observable<Employee>{
    // console.log(employeeNumber);
    return this.http.get<Employee>(`${this.baseUrl}/${employeeNumber}`);
  }

  updateEmployee(employee : Employee): Observable<Object>{
    return this.http.put("http://localhost:8080/commonController/updateEmployee", employee);
  }
  deleteEmployee(employeeNumber:any):Observable<Object>{
    return this.http.delete(`${this.deleteUrl}/${employeeNumber}`);
  }

}
