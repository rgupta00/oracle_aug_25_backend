import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class EmpService {

  constructor() { }

   getEmployees() {
    return [
      {"id": 1, "name": "Rajev", "salary": 40},
      {"id": 2, "name": "Ekta", "salary": 38},
      {"id": 3, "name": "Keshav", "salary": 26},
      {"id": 4, "name": "Gunika", "salary": 28},
      {"id": 5, "name": "Vikas", "salary": 25}   
    ];
  }
}
