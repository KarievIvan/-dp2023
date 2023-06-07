import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Car } from '../interfaces/car';

@Injectable({
  providedIn: 'root',
})
export class CarService {
  list = new BehaviorSubject<Car[]>([]);
  url: string = 'http://localhost:8080/CarServlet';

  constructor(private http: HttpClient) {}

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(this.url);
  }
  updateCar(car: Car): Observable<Object> {
    return this.http.put(`${this.url}/${car.id}`, car);
  }
  postCar(car: Car): Observable<Object> {
    return this.http.post(this.url, car);
  }
  deleteUser(car: Car): Observable<Car[]> {
    return this.http.delete<Car[]>(this.url + '/' + car.id);
  }
  setList(car: Car[]) {
    this.list.next(car);
  }
}
