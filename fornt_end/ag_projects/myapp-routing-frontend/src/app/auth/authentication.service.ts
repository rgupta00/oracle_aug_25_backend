import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthResponse } from '../model/AuthResponse';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {
  constructor(private httpClient: HttpClient) { }

 	authenticate(username: string, password: string) {
	  const authString = 'Basic ' + btoa(`${username}:${password}`);
	  const headers = new HttpHeaders({ Authorization: authString });

	  return this.httpClient.get<AuthResponse>('http://localhost:8080/validateLogin', { headers }).pipe(
		map(userData => {
		  sessionStorage.setItem('username', username);
		  sessionStorage.setItem('basicauth', authString);
		  return userData;
		})
	  );
	}



  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
