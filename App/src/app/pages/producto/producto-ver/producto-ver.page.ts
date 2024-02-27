import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductoVerResponse } from 'src/app/interfaces/responses/producto';
import { ProductoService } from 'src/app/services/producto.service';
import { ViewService } from 'src/app/services/view.service';

@Component({
  selector: 'app-producto-ver',
  templateUrl: './producto-ver.page.html',
  styleUrls: ['./producto-ver.page.scss'],
})
export class ProductoVerPage implements OnInit {

  id: number;
  producto: ProductoVerResponse | null;

  constructor(
    private activatedRoute: ActivatedRoute,
    private productoService: ProductoService,
    private viewService: ViewService
  ) {
    this.id = 0;
    this.producto = null;
    this.activatedRoute.queryParams.subscribe((params) => {
      this.id = params['id'];
    });
  }

  async ngOnInit() {
    await this.viewService.loadingPresent();
    const resp = await this.productoService.ver(this.id);
    if (!resp) {
      await this.viewService.loadingDismiss();
      return;
    }
    this.producto = resp;
    await this.viewService.loadingDismiss();
  }

}
