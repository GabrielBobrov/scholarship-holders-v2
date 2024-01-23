import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { ScholarDTO } from '../dtos/response/scholarDTO';
import { Observable, map } from 'rxjs';
import { PaymentDTO } from '../dtos/response/paymentDTO';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root',
})
export class ScholarService {
  getBanks() {
    return this.http.get(`${environment.apiUrl}/banks`);
  }

  getScholars() {
    return this.http.get(`${environment.apiUrl}/scholars`);
  }

  updateScholar(scholar: ScholarDTO) {
    return this.http.put(`${environment.apiUrl}/scholars`, scholar).pipe(
      map((result) => {
        return result;
      })
    );
  }

  createScholar(scholar: ScholarDTO): Observable<HttpResponse<any>> {
    return this.http.post<any>(`${environment.apiUrl}/scholars`, scholar).pipe(
      map((result) => {
        return result;
      })
    );
  }

  deleteScholar(scholarId: any) {
    this.http
      .delete(`${environment.apiUrl}/scholars/${scholarId}`)
      .subscribe(() => console.log('user deleted'));
  }

  constructor(private http: HttpClient) {}
}
