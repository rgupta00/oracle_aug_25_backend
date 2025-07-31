import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { EmpService } from '../../services/emp.service';

@Component({
  selector: 'app-emp',
  standalone: true,
  imports: [CommonModule],
  template: `
    <table border="1">
  <tr>
    <th>ID</th>
    <th>Name</th>
  </tr>
  @for (emp of employees; track emp.id) {
    <tr>
      <td>{{ emp.id }}</td>
      <td>{{ emp.name }}</td>
    </tr>
  }
</table>
  `,
  styles: ``
})
export class EmpComponent implements OnInit{
   public employees: { id: number; name: string; salary: number }[] = [];

    //angular is going to do DI
  constructor(private es: EmpService){}

  ngOnInit(): void {
      this.employees = this.es.getEmployees();
  }
}
