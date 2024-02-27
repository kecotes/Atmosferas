import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ProductoListaPageRoutingModule } from './producto-lista-routing.module';

import { ProductoListaPage } from './producto-lista.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ProductoListaPageRoutingModule
  ],
  declarations: [ProductoListaPage]
})
export class ProductoListaPageModule {}
