import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ScholarService {
  getScholars() {
    return this.http.get('http://localhost:8080/scholars');
  }

  constructor(private http: HttpClient) {}
}
