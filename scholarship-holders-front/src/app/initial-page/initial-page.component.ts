import { Component, OnInit } from '@angular/core';
import { DialogService } from 'primeng/dynamicdialog';
import { CreateScholarComponent } from '../create-scholar/create-scholar.component';

@Component({
  selector: 'app-initial-page',
  templateUrl: './initial-page.component.html',
  styleUrls: ['./initial-page.component.css'],
})
export class InitialPageComponent implements OnInit {
  constructor(private dialogService: DialogService) {}

  openModalCreateScholar() {
    this.dialogService.open(CreateScholarComponent, {
      data: { row: null },
      showHeader: false,
    });
  }

  ngOnInit(): void {}
}
