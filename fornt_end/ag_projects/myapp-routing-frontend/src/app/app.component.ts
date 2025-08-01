import { Component, OnInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { EmployeeComponent } from './component/employee/employee.component';
import { AuthenticationService } from './auth/authentication.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterModule, EmployeeComponent, CommonModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent implements OnInit {
  title = 'myapp-routing';
  constructor(public loginService: AuthenticationService) { }

  ngOnInit() {

  }
}
