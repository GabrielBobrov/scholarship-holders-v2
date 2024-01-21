import { AppComponent } from './app.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InitialPageComponent } from './initial-page/initial-page.component';
import { TablePaymentsComponent } from './table-payments/table-payments.component';

const routes: Routes = [
  { path: '', redirectTo: '/initial', pathMatch: 'full' },
  { path: 'initial', component: InitialPageComponent },
  { path: 'payments', component: TablePaymentsComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { onSameUrlNavigation: 'reload' })],
  exports: [RouterModule],
})
export class AppRoutingModule {}
