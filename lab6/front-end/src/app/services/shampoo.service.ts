import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Shampoo } from '../interfaces/shampoo';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ShampooService {
  list = new BehaviorSubject<Shampoo[]>([]);
  url = 'http://localhost:3232/api/shampoo';

  constructor(private http: HttpClient) {}

  getShampoo(): Observable<Shampoo[]> {
    return this.http.get<Shampoo[]>(this.url + '/retrieve');
  }

  createShampoo(shampoo: Shampoo): Observable<any> {
    return this.http.post(this.url + '/create', shampoo);
  }

  updateShampoo(shampoo: Shampoo): Observable<Object> {
    return this.http.put(`${this.url + '/update'}/${shampoo.id}`, shampoo);
  }

  deleteShampoo(shampoo: Shampoo): Observable<Shampoo[]> {
    return this.http.delete<Shampoo[]>(this.url + '/delete/' + shampoo.id);
  }

  setList(shampoo: Shampoo[]) {
    this.list.next(shampoo);
  }
}
