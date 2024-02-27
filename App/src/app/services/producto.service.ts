import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { ProductoListarTodosResponse, ProductoVerResponse } from '../interfaces/responses/producto';

@Injectable({
  providedIn: 'root'
})
export class ProductoService {

  constructor(
    private httpService: HttpService
  ) { }

  listarTodos() {
    return this.httpService.get<ProductoListarTodosResponse[]>(
      'product/findAll'
    );
  }

  ver(id: number) {
    return this.httpService.get<ProductoVerResponse>(
      `product/find/${id}`
    );
  }

}
