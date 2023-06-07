import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Shampoo } from '../interfaces/shampoo';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ShampooService {
  list = new BehaviorSubject<Shampoo[]>([]);
  url = 'http://localhost:8080/ShampooServlet';

  constructor(private http: HttpClient) {}

  getShampoo(): Observable<Shampoo[]> {
    return this.http.get<Shampoo[]>(this.url);
  }

  updateShampoo(shampoo: Shampoo): Observable<Object> {
    return this.http.put(`${this.url}/${shampoo.id}`, shampoo);
  }

  createShampoo(shampoo: Shampoo): Observable<Shampoo[]> {
    return this.http.post<Shampoo[]>(this.url, shampoo);
  }

  deleteShampoo(shampoo: Shampoo): Observable<Shampoo[]> {
    return this.http.delete<Shampoo[]>(this.url + '/' + shampoo.id);
  }

  setList(list: Shampoo[]) {
    this.list.next(list);
  }
}
