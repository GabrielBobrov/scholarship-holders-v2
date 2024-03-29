import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ScholarService } from '../../services/scholar.service';
import { ScholarDTO } from '../../dtos/response/scholarDTO';
import { PaymentDTO } from '../../dtos/response/paymentDTO';
import { PaymentsService } from '../../services/payments.service';

@Component({
  selector: 'app-create-payment',
  templateUrl: './create-payment.component.html',
  styleUrls: ['./create-payment.component.css'],
})
export class CreatePaymentComponent {
  row = new PaymentDTO();
  errorMessage: any;

  constructor(public router: Router, private paymentService: PaymentsService) {}

  onSubmit() {
    console.log(this.row);
    this.row.scholarId = localStorage.getItem('currentPaymentId');
    this.paymentService.createPayment(this.row).subscribe(
      () => {
        this.closeModal();
      },
      (error) => {
        console.log(error);
        console.log(error.error);
        this.errorMessage = error.error.detail;
      }
    );
  }

  closeModal() {
    this.router.navigate(['/payments']).then(() => {
      window.location.href = '/payments';
    });
  }
}
