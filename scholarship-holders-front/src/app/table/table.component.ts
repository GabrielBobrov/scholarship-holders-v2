import { Component, OnInit, Input } from '@angular/core';
import { ScholarService } from '../services/scholar.service';
import { DialogService } from 'primeng/dynamicdialog';
import { UpdateScholarComponent } from '../update-scholar/update-scholar.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit {
  data: any;
  dataService: any;
  originalDocuments: any;

  constructor(
    private scholarService: ScholarService,
    private dialogService: DialogService,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.scholarService.getScholars().subscribe((data: any) => {
      this.data = data;
    });
  }

  openModalUpdateScholar(row: any) {
    this.dialogService.open(UpdateScholarComponent, {
      data: { row: row },
      showHeader: false,
    });
  }

  deleteScholar(row: any) {
    console.log(row);
    this.scholarService.deleteScholar(row.id);
    window.location.reload();
  }

  hideDocument(row: any) {
    row.hideDocument = !row.hideDocument;
  }

  storeIdAndRedirect(id: string): void {
    localStorage.setItem('currentPaymentId', id);
    this.route.navigate(['/payments']);
  }
}
