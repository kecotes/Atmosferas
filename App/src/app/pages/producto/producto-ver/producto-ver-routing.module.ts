import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductoVerPage } from './producto-ver.page';

const routes: Routes = [
  {
    path: '',
    component: ProductoVerPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProductoVerPageRoutingModule {}
