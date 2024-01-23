import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { PaymentDTO } from '../dtos/response/paymentDTO';
import { environment } from 'src/environments/environment';
import { map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class PaymentsService {
  getPayments(id: any) {
    return this.http.get(`${environment.apiUrl}/scholars/${id}/payments`);
  }

  createPayment(payment: PaymentDTO) {
    return this.http
      .post(
        `${environment.apiUrl}/scholars/${payment.scholarId}/payments`,
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
        `${environment.apiUrl}/scholars/${payment.scholarId}/payments/${payment.id}/status`,
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
        `${environment.apiUrl}/scholars/${scholarId}/payments/${paymentId}`
      )
      .subscribe(() => console.log('payment deleted'));
  }

  constructor(private http: HttpClient) {}
}
