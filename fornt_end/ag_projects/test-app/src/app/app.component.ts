import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TestComponent } from './components/test/test.component';
import { EmployeelistComponent } from './components/employeelist/employeelist.component';
import { EmpdetailsComponent } from './components/empdetails/empdetails.component';
import { EmpComponent } from './components/emp/emp.component';
import { EmphttpComponent } from './components/emphttp/emphttp.component';


@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,EmphttpComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'oracle training we are champ!';

}
