import { Component, OnInit } from '@angular/core';
import { CarService } from '../services/car.service';
import { Car } from '../interfaces/car';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.scss'],
})
export class FormComponent implements OnInit {
  page: number = 1;
  show: boolean = false;
  cars: Car[] = [];
  currentCar!: Car;
  newCar: Car = new Car();

  constructor(private service: CarService) {}

  ngOnInit(): void {
    this.service.getCars().subscribe((data) => {
      this.cars = data;
      this.currentCar = data[0];
      for (let i = 0; i < this.cars.length; i++) {
        console.log(this.cars[i].name);
      }
    });
  }

  clickOnCar(car: Car) {
    this.currentCar = car;
    console.log(this.currentCar.name);
  }

  onUpdate() {
    this.service.updateCar(this.currentCar).subscribe((car) => {
      this.updateCars();
      window.location.reload();
    });
  }

  updateCars() {
    this.service.getCars().subscribe((car) => {
      this.service.setList(car);
      this.cars = car;
    });
  }

  onAdd() {
    this.newCar.id = -1;
    console.log(this.newCar);
    this.service.postCar(this.newCar).subscribe((data) => {
      this.updateCars();
      window.location.reload();
    });
  }

  deleteCar(car: Car) {
    this.service.deleteUser(car).subscribe(() => {
      this.updateCars();
      window.location.reload();
    });
  }
}
