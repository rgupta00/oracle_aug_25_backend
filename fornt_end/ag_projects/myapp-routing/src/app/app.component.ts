import { Component } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { TemplateComponent } from './component/template/template.component';
import { ReactiveComponent } from './component/reactive/reactive.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'myapp-routing';
}
