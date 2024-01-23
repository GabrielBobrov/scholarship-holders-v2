import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { ScholarService } from '../services/scholar.service';
import { ScholarDTO } from '../dtos/response/scholarDTO';
import { PaymentDTO } from '../dtos/response/paymentDTO';
import { PaymentsService } from '../services/payments.service';

@Component({
  selector: 'app-update-payment',
  templateUrl: './update-payment.component.html',
  styleUrls: ['./update-payment.component.css'],
})
export class UpdatePaymentComponent {
  constructor(
    public router: Router,
    public config: DynamicDialogConfig,
    private ref: DynamicDialogRef,
    private paymentService: PaymentsService
  ) {}
  row = new PaymentDTO();
  editedRow = JSON.parse(JSON.stringify(this.row));

  ngOnInit(): void {
    this.row = this.config.data.row;
    this.row.scholarId = localStorage.getItem('currentPaymentId');
    console.log(this.row);

    this.editedRow = JSON.parse(JSON.stringify(this.row));
    console.log(this.editedRow);
  }

  onSubmit() {
    console.log('edited row ', this.editedRow);

    this.paymentService
      .updatePaymentStatus(this.editedRow)
      .subscribe((response) => {
        console.log(response);
      });
    this.closeModal();
  }

  closeModal() {
    this.router.navigate(['/payments']).then(() => {
      window.location.href = '/payments';
    });
  }

  setStatus(status: string) {
    this.editedRow.paymentStatus = status;
  }
}
