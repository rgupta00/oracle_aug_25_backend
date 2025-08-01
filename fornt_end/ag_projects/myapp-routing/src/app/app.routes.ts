import { Routes } from '@angular/router';
import { DeptlistComponent } from './component/deptlist/deptlist.component';
import { EmplistComponent } from './component/emplist/emplist.component';
import { PageNotFoundComponent } from './component/page-not-found/page-not-found.component';
import { DeptDetailComponent } from './component/dept-detail/dept-detail.component';
import { HomeComponent } from './component/home/home.component';
import { AdminComponent } from './component/admin/admin.component';
import { activateGuard } from './auth/activate.guard';

export const routes: Routes = [
    // { path: '', redirectTo: '/departments', pathMatch: 'full' }, // default
    // { path: 'departments', component: DeptlistComponent },
    // { path : 'departments/:id', component: DeptDetailComponent},
    // { path: 'employees', component: EmplistComponent },
    // { path: '**', component: PageNotFoundComponent } // wildcard
    { path: '', redirectTo: 'home', pathMatch: 'full' },
    { path: 'home', component: HomeComponent },
    { path: 'admin', component: AdminComponent, canActivate: [activateGuard] }
];
