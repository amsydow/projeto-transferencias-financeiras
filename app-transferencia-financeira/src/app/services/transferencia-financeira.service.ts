import { HttpClient } from '@angular/common/http';
import { Inject, Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { APP_CONFIG, AppConfig } from '../app.config';

export interface TransferenciaFinanceira {
  id?: number;
  contaOrigem: string;
  contaDestino: string;
  valorTransferencia: number;
  taxa?: number;
  dataTransferencia: string;
  dataAgendamento?: string;
}

@Injectable({
  providedIn: 'root'
})
export class TransferenciaFinanceiraService {
  private api: string;

  constructor(
    private httpClient: HttpClient,
    @Inject(APP_CONFIG) private config: AppConfig
  ) {
    this.api = `${this.config.apiBaseUrl}/transferenciaFinanceira`;
  }

  getTransferencias(): Observable<TransferenciaFinanceira[]> {
    return this.httpClient.get<TransferenciaFinanceira[]>(this.api);
  }

  agendarTransferencia(transferencia: TransferenciaFinanceira): Observable<TransferenciaFinanceira> {
    return this.httpClient.post<TransferenciaFinanceira>(this.api, transferencia);
  }

}
