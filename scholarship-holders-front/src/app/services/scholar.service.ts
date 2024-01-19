import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ScholarDTO } from '../dtos/response/scholarDTO';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ScholarService {
  getScholars() {
    return this.http.get('http://localhost:8080/scholars');
  }

  updateScholar(scholar: ScholarDTO) {
    console.log(scholar);
    return this.http.put('http://localhost:8080/scholars', scholar).pipe(
      map((result) => {
        return result;
      })
    );
  }

  createScholar(scholar: ScholarDTO) {
    console.log(scholar);
    return this.http.post('http://localhost:8080/scholars', scholar).pipe(
      map((result) => {
        return result;
      })
    );
  }

  deleteScholar(scholarId: any) {
    console.log(scholarId);
    this.http
      .delete(`http://localhost:8080/scholars/${scholarId}`)
      .subscribe(() => console.log('user deleted'));
  }

  constructor(private http: HttpClient) {}
}
