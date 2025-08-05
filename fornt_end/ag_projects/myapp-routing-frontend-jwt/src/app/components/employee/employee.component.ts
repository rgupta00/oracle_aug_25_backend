import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-employee',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './employee.component.html',
  styleUrl: './employee.component.css'
})
export class EmployeeComponent implements OnInit {
  employees: Employee[] = [];

  constructor(private employeeService: EmployeeService, private router: Router) { }
  //when compoent is property file
  ngOnInit() {
    this.getEmployees()
  }
  private getEmployees() {
    this.employeeService.getEmployeesList().subscribe(data => { this.employees = data; });
  }
  updateEmployee(id: number) {
    this.router.navigate(['update-employee', id]);
  }
  deleteEmployee(id: number): void {
    this.employeeService.deleteEmployee(id).subscribe({
      next: () => this.getEmployees(),
      error: err => console.error(err)
    });
  }
  employeeDetails(id: number): void {
    this.router.navigate(['employee-details', id]);
  }
}

