import { Component } from '@angular/core';
import { Shampoo } from './interfaces/shampoo';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {
  title = 'front-end';
  currentItem!: Shampoo;

  chosenShampoo(shampoo: Shampoo) {
    this.currentItem = shampoo;
  }
}
