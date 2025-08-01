import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../auth/authentication.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  username: string = 'raj'
  password: string = ''
  invalidLogin = false

  constructor(private router: Router, private loginservice: AuthenticationService) { }

  ngOnInit() {
  }

  checkLogin(): void {
    this.loginservice.authenticate(this.username, this.password).subscribe({
      next: () => {
        this.router.navigate(['']);
        this.invalidLogin = false;
      },
      error: () => {
        this.invalidLogin = true;
      }
    });
  }
}
