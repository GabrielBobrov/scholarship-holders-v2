import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { InitialPageComponent } from './initial-page/initial-page.component';
import { TableComponent } from './table/table.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateScholarComponent } from './update-scholar/update-scholar.component';
import { BrowserModule } from '@angular/platform-browser';
import { AngularPrimeNgModule } from './modules/angular-primeng.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { DynamicDialogConfig, DynamicDialogRef } from 'primeng/dynamicdialog';

@NgModule({
  declarations: [
    AppComponent,
    InitialPageComponent,
    TableComponent,
    UpdateScholarComponent,
  ],
  imports: [
    BrowserModule,
    AngularPrimeNgModule,
    AppRoutingModule,
    HttpClientModule,
    BrowserAnimationsModule,
    FormsModule,
  ],
  providers: [DynamicDialogConfig, DynamicDialogRef],
  bootstrap: [AppComponent],
})
export class AppModule {}
