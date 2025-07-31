import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'empTitle',
  standalone: true
})
export class EmpTitlePipe implements PipeTransform {
  // employee.name | empTitle:employee.gender 
  transform(value: string, gender: string): string {
    if (gender.toLowerCase() === 'male') {
      return 'Mr. ' + value;
    } else {
      return 'Miss. ' + value;
    }
  }

}
