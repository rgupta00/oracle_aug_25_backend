import { Routes } from '@angular/router';
import { EmployeeComponent } from './components/employee/employee.component';
import { CreateEmployeeComponent } from './components/create-employee/create-employee.component';
import { UpdateEmployeeComponent } from './components/update-employee/update-employee.component';
import { EmployeeDetailsComponent } from './components/employee-details/employee-details.component';
import { LoginComponent } from './components/login/login.component';
import { LogoutComponent } from './components/logout/logout.component';
import { AuthGaurdService } from './services/auth-gaurd.service';

export const routes: Routes = [
      {path:'employees', component: EmployeeComponent,canActivate:[AuthGaurdService]},
       {path:'create-employee', component: CreateEmployeeComponent, canActivate:[AuthGaurdService]},
       {path:'update-employee/:id', component: UpdateEmployeeComponent, canActivate:[AuthGaurdService]},
       {path:'employee-details/:id', component: EmployeeDetailsComponent, canActivate:[AuthGaurdService]},
       { path: 'login', component: LoginComponent },
       { path: 'logout', component: LogoutComponent , canActivate:[AuthGaurdService]},
       {path:'', redirectTo:'employees', pathMatch:'full'}
];
