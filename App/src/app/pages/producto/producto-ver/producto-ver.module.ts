import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

import { IonicModule } from '@ionic/angular';

import { ProductoVerPageRoutingModule } from './producto-ver-routing.module';

import { ProductoVerPage } from './producto-ver.page';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule,
    ProductoVerPageRoutingModule
  ],
  declarations: [ProductoVerPage]
})
export class ProductoVerPageModule {}
