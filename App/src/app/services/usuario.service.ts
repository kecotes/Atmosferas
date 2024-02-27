import { Injectable } from '@angular/core';
import { HttpService } from './http.service';
import { VerUsuarioResponse } from '../interfaces/responses/usuario';
import { Usuario } from '../interfaces/usuario';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(
    private httpService: HttpService
  ) { }

  ver() {
    return this.httpService.get<VerUsuarioResponse>(
      `user/find/3`
    );
  }

  guardar(usuario: Usuario) {
    const payload = { usuario };
    return this.httpService.put('user/update/3', payload);
  }

}
