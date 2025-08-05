import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Employee } from '../model/employee';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
 private baseURL = "http://localhost:8080/employees";

  constructor(private httpClient: HttpClient) { }
  
  getEmployeesList(): Observable<Employee[]>{
    let username='raj'
    let password='raj123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.get<Employee[]>(`${this.baseURL}`,{headers});
   // return this.httpClient.get<Employee[]>(`${this.baseURL}`);
  }

  createEmployee(employee: Employee): Observable<Object>{
    let username='raj'
    let password='raj123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.httpClient.post(`${this.baseURL}`, employee,{headers});

    //return this.httpClient.post(`${this.baseURL}`, employee);
  }

  getEmployeeById(id: number): Observable<Employee>{
    // let username='raj'
    // let password='raj123'
    // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    // return this.httpClient.get<Employee>(`${this.baseURL}/${id}`,{headers});
    return this.httpClient.get<Employee>(`${this.baseURL}/${id}`);
  }

  updateEmployee(id: number, employee: Employee): Observable<Object>{
    // let username='raj'
    // let password='raj123'
    // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
   // return this.httpClient.put(`${this.baseURL}/${id}`, employee,{headers});

    return this.httpClient.put(`${this.baseURL}/${id}`, employee);
  }


  deleteEmployee(id: number): Observable<Object>{
    //     let username='raj'
    // let password='raj123'
    // const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    // return this.httpClient.delete(`${this.baseURL}/${id}`,{headers});
    return this.httpClient.delete(`${this.baseURL}/${id}`);
  }
}
