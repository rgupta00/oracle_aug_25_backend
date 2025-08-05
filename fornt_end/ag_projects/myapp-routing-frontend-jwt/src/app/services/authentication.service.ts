import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthResponse } from '../model/AuthResponse';
import { catchError, map, throwError } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private httpClient:HttpClient) {  }

	// authenticate(username: string, password: string) {
	//   const authString = 'Basic ' + btoa(`${username}:${password}`);
	//   const headers = new HttpHeaders({ Authorization: authString });

	//   return this.httpClient.get<AuthResponse>('http://localhost:8080/validateLogin', { headers }).pipe(
	// 	map(userData => {
	// 	  sessionStorage.setItem('username', username);
	// 	  sessionStorage.setItem('basicauth', authString);
	// 	  return userData;
	// 	})
	//   );
	// }

	authenticate(username: string, password: string) {
  return this.httpClient.post<any>('http://localhost:8080/authenticate', { username, password }).pipe(
    map(userData => {
    
      sessionStorage.setItem('username', username);
       let tokenStr= 'Bearer '+userData.token;
      sessionStorage.setItem('token', tokenStr);
      return userData;
    }),
    catchError(error => {
      console.error('Authentication failed', error);
      return throwError(() => error);
    })
  );
}


  isUserLoggedIn() {
    let user = sessionStorage.getItem('username')
	console.log(user)
    console.log(!(user === null))
    return !(user === null)
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}
