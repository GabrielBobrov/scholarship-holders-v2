import { Component, OnInit, Input } from '@angular/core';
import { ScholarService } from '../services/scholar.service';

@Component({
  selector: 'app-table',
  templateUrl: './table.component.html',
  styleUrls: ['./table.component.css'],
})
export class TableComponent implements OnInit {
  @Input() data: any;

  constructor(private scholarService: ScholarService) {}

  ngOnInit(): void {
    this.scholarService.getScholars().subscribe((data: any) => {
      this.data = data;
    });
  }
}
