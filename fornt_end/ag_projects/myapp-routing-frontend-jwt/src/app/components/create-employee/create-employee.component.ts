import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-employee',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './create-employee.component.html',
  styleUrl: './create-employee.component.css'
})
export class CreateEmployeeComponent implements OnInit {
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, private router: Router) { }
  ngOnInit() {
  }
  saveEmployee(): void {
    this.employeeService.createEmployee(this.employee).subscribe({
      next: data => {
        console.log(data);
        this.goToEmployeeList();
      },
      error: err => console.error(err)
    });
  }

  goToEmployeeList() {
    this.router.navigate(['/employees']);
  }

  onSubmit() {
    console.log(this.employee);
    this.saveEmployee();
  }
}
