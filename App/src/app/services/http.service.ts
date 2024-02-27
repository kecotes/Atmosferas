import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Platform } from '@ionic/angular';
import { firstValueFrom } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  private headers = new HttpHeaders().set('Content-Type', 'application/json');

  constructor(
    private http: HttpClient,
    private platform: Platform
  ) { }

  private readonly TIMEOUT_DURATION = 60000;


  private arrayToParams(array: any[]) {
    let params: HttpParams = new HttpParams();
    for (let item of array) {
      for (const key of Object.keys(item)) {
        if (item[key]) {
          if (item[key] instanceof Array) {
            item[key].forEach((item2: any) => {
              params = params.append(`${key.toString()}[]`, item2);
            });
          } else {
            params = params.append(key.toString(), item[key]);
          }
        }
      }
    }
    return params;
  }

  public async blob<T>(url: string, params: any[] = []) {
    try {
      let httpParams: HttpParams = this.arrayToParams(params);
      const response = await firstValueFrom(
        this.http.get(`${environment.apiEndpoint}${url}`, {
          params: httpParams,
          responseType: 'blob',
        })
      );
      return response;
    } catch (error) {
      console.error(
        'Error al realizar la petición GET:',
        error,
        JSON.stringify(error)
      );
      return null;
    }
  }

  public async postFile<T>(
    url: string,
    formdata: FormData,
    params: any[] = []
  ) {
    try {
      const httpParams = this.arrayToParams(params);
      const response = await firstValueFrom(
        this.http.post<T>(`${environment.apiEndpoint}${url}`, formdata, {
          params: httpParams,
        })
      );
      return response;
    } catch (error) {
      console.error(
        'Error al realizar la petición POST:',
        error,
        JSON.stringify(error)
      );
      return null;
    }
  }

  public async get<T>(url: string, params: any[] = []) {
    try {
      const httpParams = this.arrayToParams(params);
      const response = await firstValueFrom(
        this.http.get<T>(`${environment.apiEndpoint}${url}`, {
          params: httpParams,
        })
      );
      return response;
    } catch (error) {
      console.log(
        '🚀 ~ file: http.service.ts:42 ~ HttpService ~ error:',
        error,
        JSON.stringify(error)
      );
      return null;
    }
  }

  public async post<T>(url: string, body: any, params: any[] = []) {
    try {
      const httpParams = this.arrayToParams(params);
      const response = await firstValueFrom(
        this.http
          .post<T>(`${environment.apiEndpoint}${url}`, body, {
            headers: this.headers,
            params: httpParams,
          })
      );
      return response;
    } catch (error) {
      console.error(
        'Error al realizar la petición POST:',
        error,
        JSON.stringify(error)
      );
      return null;
    }
  }

  public async put<T>(url: string, body: any, params: any[] = []) {
    try {
      const httpParams = this.arrayToParams(params);
      const response = await firstValueFrom(
        this.http.put<T>(`${environment.apiEndpoint}${url}`, body, {
          headers: this.headers,
          params: httpParams,
        })
      );
      return response;
    } catch (error) {
      console.error('Error al realizar la petición PUT:', error);
      return null;
    }
  }

  public async delete<T>(url: string, params: any[] = []) {
    try {
      const httpParams = this.arrayToParams(params);
      const response = await firstValueFrom(
        this.http.delete<T>(`${environment.apiEndpoint}${url}`, {
          params: httpParams,
        })
      );
      return response;
    } catch (error) {
      console.error('Error al realizar la petición DELETE:', error);
      return null;
    }
  }
}
