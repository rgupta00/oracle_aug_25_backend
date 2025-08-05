import { Component } from '@angular/core';
import { AuthenticationService } from '../../services/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-logout',
  standalone: true,
  imports: [],
  templateUrl: './logout.component.html',
  styleUrl: './logout.component.css'
})
export class LogoutComponent {
constructor( private authentocationService: AuthenticationService,private router: Router) {}

  ngOnInit() {
    this.authentocationService.logOut();
    this.router.navigate(['login']);
  }
}
