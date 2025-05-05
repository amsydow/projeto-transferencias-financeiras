import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { TransferenciaFinanceira, TransferenciaFinanceiraService } from '../../services/transferencia-financeira.service';

@Component({
  selector: 'app-transferencia-listar',
  standalone: true,
  imports: [
    CommonModule, RouterModule
  ],
  templateUrl: './transferencia-listar.component.html',
  styleUrl: './transferencia-listar.component.css'
})
export class TransferenciaListarComponent implements OnInit {
  listaTransferencias: TransferenciaFinanceira[] = [];
  carregando = true;

  constructor(private servico: TransferenciaFinanceiraService) {}

  ngOnInit() {
    this.servico.getTransferencias().subscribe({
      next: data => { this.listaTransferencias = data; this.carregando = false; },
      error: () => { this.carregando = false; }
    });    
  }

}
