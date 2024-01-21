import { Component, OnInit } from '@angular/core';
import { ScholarService } from '../services/scholar.service';
import { DialogService } from 'primeng/dynamicdialog';
import { CreatePaymentComponent } from '../create-payment/create-payment.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-table-payments',
  templateUrl: './table-payments.component.html',
  styleUrls: ['./table-payments.component.css'],
})
export class TablePaymentsComponent implements OnInit {
  payments: any;

  constructor(
    private scholarService: ScholarService,
    private dialogService: DialogService,
    private route: Router
  ) {}

  ngOnInit() {
    const id = localStorage.getItem('currentPaymentId');
    this.scholarService.getPayments(id).subscribe((data: any) => {
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
}
