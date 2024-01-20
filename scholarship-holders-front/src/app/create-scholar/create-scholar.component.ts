import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ScholarDTO } from '../dtos/response/scholarDTO';
import { ScholarService } from '../services/scholar.service';

@Component({
  selector: 'app-create-scholar',
  templateUrl: './create-scholar.component.html',
  styleUrls: ['./create-scholar.component.css'],
})
export class CreateScholarComponent {
  row = new ScholarDTO();

  constructor(public router: Router, private scholarService: ScholarService) {}

  onSubmit() {
    this.scholarService.createScholar(this.row).subscribe(
      (response) => {
        console.log(response);
      },
      (error) => {
        console.error(error);
      }
    );
    this.closeModal();
  }

  closeModal() {
    this.router.navigate(['/initial']).then(() => {
      window.location.href = '/initial';
    });
  }
}
