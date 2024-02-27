import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UsuarioService } from 'src/app/services/usuario.service';
import { ViewService } from 'src/app/services/view.service';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.page.html',
  styleUrls: ['./perfil.page.scss'],
})
export class PerfilPage implements OnInit {

  formPerfil: FormGroup;

  constructor(
    private formBuilder: FormBuilder,
    private viewService: ViewService,
    private usuarioService: UsuarioService
  ) {
    this.formPerfil = this.formBuilder.group({
      nombre: ['', Validators.required],
      apellido: ['', Validators.required],
      email: ['', Validators.required],
      tipoDocumento: ['', Validators.required],
      documento: ['', Validators.required],
      pais: ['', Validators.required],
      departamento: ['', Validators.required],
      ciudad: ['', Validators.required],
      direccion: ['', Validators.required]
    })
  }

  async ngOnInit() {
    await this.viewService.loadingPresent();
    const resp = await this.usuarioService.ver();
    if (!resp) {
      await this.viewService.loadingDismiss();
      return;
    }
    this.formPerfil.get('nombre')?.setValue(resp.name);
    this.formPerfil.get('apellido')?.setValue(resp.lastname);
    this.formPerfil.get('email')?.setValue(resp.email);
    this.formPerfil.get('tipoDocumento')?.setValue(resp.type_document);
    this.formPerfil.get('documento')?.setValue(resp.document);
    this.formPerfil.get('pais')?.setValue(resp.pais);
    this.formPerfil.get('departamento')?.setValue(resp.department);
    this.formPerfil.get('ciudad')?.setValue(resp.city);
    this.formPerfil.get('direccion')?.setValue(resp.address);
    await this.viewService.loadingDismiss();
  }

  async guardar() {
    await this.viewService.loadingPresent();
    const resp = await this.usuarioService.guardar(this.formPerfil.getRawValue());
    if (!resp) {
      await this.viewService.loadingDismiss();
      return;
    }
    await this.viewService.loadingDismiss();
  }

}
