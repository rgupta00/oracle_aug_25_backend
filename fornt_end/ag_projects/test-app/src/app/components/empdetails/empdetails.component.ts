import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { EmpService } from '../../services/emp.service';

@Component({
  selector: 'app-empdetails',
  standalone: true,
  imports: [CommonModule],
  template: `
    <table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
    <th>Age</th>
  </tr>
  @for (emp of employees; track emp.id) {
    <tr>
      <td>{{ emp.id }}</td>
      <td>{{ emp.name }}</td>
      <td>{{ emp.salary }}</td>
    </tr>
  }
</table>
  `,
  styles: ``
})
export class EmpdetailsComponent implements OnInit{
  public employees: { id: number; name: string; salary: number }[] = [];

  constructor(private es:EmpService){}

  ngOnInit(): void {
      this.employees=this.es.getEmployees();
  }

}
