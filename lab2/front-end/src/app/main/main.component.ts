import { Component, OnInit } from '@angular/core';
import { CarService } from '../services/car.service';
import { Car } from '../interfaces/car';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
})
export class MainComponent implements OnInit {
  page: number = 1;
  show: boolean = true;
  cars: Car[] = [];

  constructor(private service: CarService) {}

  ngOnInit(): void {
    this.service.getCars().subscribe((data) => {
      this.cars = data;
      console.log(data);
    });
  }
}
