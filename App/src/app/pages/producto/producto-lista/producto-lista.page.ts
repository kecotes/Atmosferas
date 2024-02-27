import { Component, OnInit } from '@angular/core';
import { ProductoListarTodosResponse } from 'src/app/interfaces/responses/producto';
import { ProductoService } from 'src/app/services/producto.service';
import { ViewService } from 'src/app/services/view.service';

@Component({
  selector: 'app-producto-lista',
  templateUrl: './producto-lista.page.html',
  styleUrls: ['./producto-lista.page.scss'],
})
export class ProductoListaPage implements OnInit {

  productos: ProductoListarTodosResponse[];

  constructor(
    private productoService: ProductoService,
    private viewService: ViewService
  ) {
    this.productos = [];
  }

  async ngOnInit() {
    await this.viewService.loadingPresent();
    const resp = await this.productoService.listarTodos();
    if (!resp) {
      await this.viewService.loadingDismiss();
      return;
    }
    this.productos = resp;
    await this.viewService.loadingDismiss();
  }

}
