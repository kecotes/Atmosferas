import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { ProductoListaPage } from './producto-lista.page';

const routes: Routes = [
  {
    path: '',
    component: ProductoListaPage
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class ProductoListaPageRoutingModule {}
