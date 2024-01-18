import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ScholarDTO } from '../dtos/response/scholarDTO';

@Injectable({
  providedIn: 'root',
})
export class ScholarService {
  getScholars() {
    return this.http.get('http://localhost:8080/scholars');
  }

  updateScholar(scholar: ScholarDTO) {
    console.log(scholar);
    return this.http.put('http://localhost:8080/scholars', scholar);
  }

  createScholar(scholar: ScholarDTO) {
    console.log(scholar);
    return this.http.post('http://localhost:8080/scholars', scholar);
  }

  constructor(private http: HttpClient) {}
}
