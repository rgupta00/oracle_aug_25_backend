import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

    isAdminRight(): boolean {
    // Logic can be based on login token or user role
    return false; // change to true to allow access
  }
}
