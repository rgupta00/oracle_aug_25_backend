import { Component, OnInit } from '@angular/core';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../services/employee.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-emphttp',
  standalone: true,
  imports: [CommonModule],
  template: `
   <h2>Employee List</h2>
    @if (errorMessage) {
      <p style="color:red">{{ errorMessage }}</p>
    }

	@if (employees.length > 0) {
	<table border="1">
	  <tr>
		<th>ID</th><th>Name</th><th>Age</th>
	  </tr>

	  @for ( emp of employees; track emp.id) {
		<tr>
		  <td>{{ emp.id }}</td>
		  <td>{{ emp.name }}</td>
		  <td>{{ emp.salary }}</td>
		</tr>
	  }
	</table>
	}
  `,
  styles: ``
})
export class EmphttpComponent implements OnInit {

  public employees: Employee[] = [];
  public errorMessage = '';

  constructor(private es: EmployeeService) { }

  ngOnInit(): void {
    //observer design pattern: java 
    this.es.getEmployees().subscribe({
      next: data => this.employees = data,
      error: err => this.errorMessage = err
    })
  }

}
