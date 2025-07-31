import { CurrencyPipe, DatePipe, DecimalPipe, JsonPipe } from '@angular/common';
import { Component, NgModule } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';

@Component({
  selector: 'app-test',
  standalone: true,
  imports: [FormsModule, JsonPipe, CurrencyPipe, DatePipe, DecimalPipe],
  template: `
    <p> json objet: {{dataOb |json}} </p>
     <p>Currency: {{ 123456 | currency: 'EUR' }}</p>
   <p> simple date is :{{mydate | date}} </p> <br/>
    <p> medium date is :{{mydate | date: 'medium'}} </p> <br/>
    <p> short date is :{{mydate | date: 'short'}} </p> <br/>
    <p> full date is :{{mydate | date: 'fullDate'}} </p> <br/>
    <p> custom date is :{{mydate | date: 'yyyy-mm-dd HH:mm a z ':' +0900}} </p> <br/>
   <p> currrency : {{123456 | currency: 'EUR' }}</p>
	<p>currency : {{ 123456 | currency: 'EUR':'symbol' }}</p>
	<p>currency : {{ 123456 | currency: 'USD':'symbol' }}</p>
  <p> no : {{11.24959265 | number: '3.1-2'}} </p>
  <p> no : {{3.15159265 | number: '1.4-4'}}</p>
  `,
  styleUrl: './test.component.css'
})
export class TestComponent {
  dataOb: Object = {
    'name': 'raj',
    'address': 'delhi'
  }

  mydate = new Date();

}
