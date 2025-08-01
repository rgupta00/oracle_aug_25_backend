import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from '../model/employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
 private baseURL="http://localhost:8080/employees";
  constructor(private httpClient: HttpClient) { }

  getEmployeesList(): Observable<Employee[]>{
     return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }
   createEmployee(employee: Employee): Observable<Object>{
    return this.httpClient.post(`${this.baseURL}`, employee);
  }
  updateEmployee(id: number, employee: Employee): Observable<Object>{
    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }

  getEmployeeById(id: number): Observable<Employee>{
     return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  deleteEmployee(id: number): Observable<Object>{
     return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
