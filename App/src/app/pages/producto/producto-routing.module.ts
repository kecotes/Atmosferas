import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    loadChildren: () => import('./producto-lista/producto-lista.module').then(m => m.ProductoListaPageModule)
  },
  {
    path: 'ver',
    loadChildren: () => import('./producto-ver/producto-ver.module').then(m => m.ProductoVerPageModule)
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductoRoutingModule { }
