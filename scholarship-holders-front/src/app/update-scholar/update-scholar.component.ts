import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';
import { ScholarDTO } from '../dtos/response/scholarDTO';
import { ScholarService } from '../services/scholar.service';

@Component({
  selector: 'app-update-scholar',
  templateUrl: './update-scholar.component.html',
  styleUrls: ['./update-scholar.component.css'],
})
export class UpdateScholarComponent {
  constructor(
    public router: Router,
    public config: DynamicDialogConfig,
    private ref: DynamicDialogRef,
    private scholarService: ScholarService
  ) {}
  row = new ScholarDTO();
  originalData: any;

  ngOnInit(): void {
    this.row = this.config.data.row;
    this.originalData = this.row;
  }

  onSubmit() {
    this.scholarService.updateScholar(this.row).subscribe();
    this.closeModal();
  }

  closeModal() {
    window.location.reload();
  }
}
