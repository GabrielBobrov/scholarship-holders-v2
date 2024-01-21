import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { ScholarDTO } from '../dtos/response/scholarDTO';
import { map } from 'rxjs';
import { PaymentDTO } from '../dtos/response/paymentDTO';

@Injectable({
  providedIn: 'root',
})
export class ScholarService {
  getScholars() {
    return this.http.get('http://localhost:8080/scholars');
  }

  updateScholar(scholar: ScholarDTO) {
    return this.http.put('http://localhost:8080/scholars', scholar).pipe(
      map((result) => {
        return result;
      })
    );
  }

  createScholar(scholar: ScholarDTO) {
    return this.http.post('http://localhost:8080/scholars', scholar).pipe(
      map((result) => {
        return result;
      })
    );
  }

  deleteScholar(scholarId: any) {
    this.http
      .delete(`http://localhost:8080/scholars/${scholarId}`)
      .subscribe(() => console.log('user deleted'));
  }

  getPayments(id: any) {
    return this.http.get(`http://localhost:8080/scholars/${id}/payments`);
  }

  createPayment(payment: PaymentDTO) {
    return this.http
      .post(`http://localhost:8080/scholars/${payment.id}/payments`, payment)
      .pipe(
        map((result) => {
          return result;
        })
      );
  }

  constructor(private http: HttpClient) {}
}
