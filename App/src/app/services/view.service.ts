import { Injectable } from '@angular/core';
import { LoadingController, ToastController } from '@ionic/angular';

@Injectable({
  providedIn: 'root'
})
export class ViewService {

  constructor(
    private loadingController: LoadingController,
    private toastController: ToastController
  ) {}

  async loadingPresent() {
    const loadingActual = await this.loadingController.getTop();
    if (loadingActual) {
      await this.loadingController.dismiss();
    }
    const loader = await this.loadingController.create({
      message: 'Por favor espere...',
      animated: true,
      duration: 180000,
    });
    return await loader.present();
  }

  async loadingDismiss() {
    setTimeout(async () => {
      const loadingActual = await this.loadingController.getTop();
      if (!loadingActual) {
        return null;
      }
      return await this.loadingController.dismiss();
    }, 800);
    return;
  }

  async toastPresent(
    message: string,
    position?: 'top' | 'bottom' | 'middle' | undefined
  ) {
    const toast = await this.toastController.create({
      duration: 4000,
      message,
      position,
    });
    return await toast.present();
  }
}
