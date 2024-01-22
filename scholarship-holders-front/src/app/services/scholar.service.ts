import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse } from '@angular/common/http';
import { ScholarDTO } from '../dtos/response/scholarDTO';
import { Observable, map } from 'rxjs';
import { PaymentDTO } from '../dtos/response/paymentDTO';

@Injectable({
  providedIn: 'root',
})
export class ScholarService {
  getBanks() {
    return this.http.get('http://localhost:8080/banks');
  }

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

  createScholar(scholar: ScholarDTO): Observable<HttpResponse<any>> {
    return this.http.post<any>('http://localhost:8080/scholars', scholar).pipe(
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
      .post(
        `http://localhost:8080/scholars/${payment.scholarId}/payments`,
        payment
      )
      .pipe(
        map((result) => {
          return result;
        })
      );
  }

  updatePaymentStatus(payment: PaymentDTO) {
    return this.http
      .patch(
        `http://localhost:8080/scholars/${payment.scholarId}/payments/${payment.id}/status`,
        payment
      )
      .pipe(
        map((result) => {
          return result;
        })
      );
  }

  deletePayment(scholarId: any, paymentId: any) {
    this.http
      .delete(
        `http://localhost:8080/scholars/${scholarId}/payments/${paymentId}`
      )
      .subscribe(() => console.log('payment deleted'));
  }

  constructor(private http: HttpClient) {}
}
