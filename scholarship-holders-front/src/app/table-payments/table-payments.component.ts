import { Component, OnInit } from '@angular/core';
import { ScholarService } from '../services/scholar.service';
import { DialogService } from 'primeng/dynamicdialog';
import { CreatePaymentComponent } from '../create-payment/create-payment.component';
import { Router } from '@angular/router';
import { UpdateScholarComponent } from '../update-scholar/update-scholar.component';
import { UpdatePaymentComponent } from '../update-payment/update-payment.component';
import { PaymentsService } from '../services/payments.service';

@Component({
  selector: 'app-table-payments',
  templateUrl: './table-payments.component.html',
  styleUrls: ['./table-payments.component.css'],
})
export class TablePaymentsComponent implements OnInit {
  payments: any;
  scholarId: any;

  constructor(
    private paymentService: PaymentsService,
    private dialogService: DialogService,
    private route: Router
  ) {}

  ngOnInit() {
    this.scholarId = localStorage.getItem('currentPaymentId');
    this.paymentService.getPayments(this.scholarId).subscribe((data: any) => {
      this.payments = data;
    });
  }

  openModalCreatePayment() {
    this.dialogService.open(CreatePaymentComponent, {
      data: { row: null },
      showHeader: false,
    });
  }

  goBack() {
    this.route.navigate(['/initial']);
  }

  openModalUpdatePayment(row: any) {
    this.dialogService.open(UpdatePaymentComponent, {
      data: { row: row },
      showHeader: false,
    });
  }

  deletePayment(row: any) {
    console.log(row);
    this.paymentService.deletePayment(this.scholarId, row.id);
    window.location.reload();
  }
}
