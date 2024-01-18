import { Component, OnInit, Input } from '@angular/core';
import { ScholarService } from '../services/scholar.service';
import { DialogService } from 'primeng/dynamicdialog';
import { UpdateScholarComponent } from '../update-scholar/update-scholar.component';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit {
  data: any;

  constructor(
    private scholarService: ScholarService,
    private dialogService: DialogService
  ) {}

  ngOnInit(): void {
    this.scholarService.getScholars().subscribe((data: any) => {
      this.data = data;
    });
  }

  openModalUpdateScholar(row: any) {
    console.log(row);
    this.dialogService.open(UpdateScholarComponent, {
      data: { row: row },
      showHeader: false,
    });
  }
}
