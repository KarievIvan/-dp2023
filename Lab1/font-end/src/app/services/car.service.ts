import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Car } from '../interfaces/car';

@Injectable({
  providedIn: 'root',
})
export class CarService {
  url: string = 'http://localhost:8080/CarServlet';

  constructor(private http: HttpClient) {}

  getCars(): Observable<Car[]> {
    return this.http.get<Car[]>(this.url);
  }
}
