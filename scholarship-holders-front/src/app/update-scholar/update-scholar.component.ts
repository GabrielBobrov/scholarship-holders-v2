import { Component, Input } from '@angular/core';
import { ScholarDTO } from '../dtos/response/scholarDto';
import { Router } from '@angular/router';
import { DynamicDialogConfig } from 'primeng/dynamicdialog';

@Component({
  selector: 'app-update-scholar',
  templateUrl: './update-scholar.component.html',
  styleUrls: ['./update-scholar.component.css'],
})
export class UpdateScholarComponent {
  constructor(public router: Router, public config: DynamicDialogConfig) {}
  row = new ScholarDTO();

  ngOnInit(): void {
    this.row = this.config.data.row;
  }

  onSubmit() {
    // Aqui você pode adicionar o código para salvar as alterações no registro.
    console.log(this.row);
  }
}
