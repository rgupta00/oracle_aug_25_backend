import { Component } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-update-employee',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './update-employee.component.html',
  styleUrl: './update-employee.component.css'
})
export class UpdateEmployeeComponent {
  id: number = 0;
  employee: Employee = new Employee();
  constructor(private employeeService: EmployeeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.employeeService.getEmployeeById(this.id).subscribe({
      next: data => this.employee = data,
      error: err => console.error(err)
    });
  }
  onSubmit(): void {
    this.employeeService.updateEmployee(this.id, this.employee).subscribe({
      next: () => this.goToEmployeeList(),
      error: err => console.error(err)
    });
  }

  goToEmployeeList(): void {
    this.router.navigate(['/employees']);
  }

}
