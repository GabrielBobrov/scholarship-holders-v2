import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ScholarDTO } from '../dtos/response/scholarDTO';
import { ScholarService } from '../services/scholar.service';

@Component({
  selector: 'app-create-scholar',
  templateUrl: './create-scholar.component.html',
  styleUrls: ['./create-scholar.component.css'],
})
export class CreateScholarComponent implements OnInit {
  row = new ScholarDTO();
  banks: any[] | undefined;
  errorMessage: any;

  constructor(public router: Router, private scholarService: ScholarService) {}

  ngOnInit(): void {
    this.scholarService.getBanks().subscribe((banks: any) => {
      this.banks = banks;
    });
  }

  onSubmit() {
    this.scholarService.createScholar(this.row).subscribe(
      () => {
        this.closeModal();
      },
      (error) => {
        this.errorMessage = error.error.userMessage;
      }
    );
  }

  closeModal() {
    this.router.navigate(['/initial']).then(() => {
      window.location.href = '/initial';
    });
  }
}
