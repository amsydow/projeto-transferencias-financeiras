import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { TransferenciaFinanceiraService } from '../../services/transferencia-financeira.service';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-transferencia-form',
  standalone: true,
  imports: [
    CommonModule, ReactiveFormsModule
  ],
  templateUrl: './transferencia-form.component.html',
  styleUrl: './transferencia-form.component.css'
})
export class TransferenciaFormComponent {

  formulario: FormGroup;
  mensagem: string = '';
  enviandoRequisicao: boolean = false;

  constructor(
    private fb: FormBuilder,
    private servico: TransferenciaFinanceiraService,
    private router: Router
  ) {
      this.formulario = this.fb.group({
      contaOrigem: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      contaDestino: ['', [Validators.required, Validators.pattern(/^\d{10}$/)]],
      valorTransferencia: ['', [Validators.required, Validators.min(0.01)]],
      dataTransferencia: ['', Validators.required]
      }); 
   }

  onSubmit(): void {
    if (this.formulario.invalid) {
      this.markFormGroupTouched(this.formulario);
      return;
    }

    this.enviandoRequisicao = true;
    this.mensagem = '';

    this.servico.agendarTransferencia(this.formulario.value)
      .subscribe({
        next: (response) => {
          this.enviandoRequisicao = false;
          alert('Agendamento efetuado com sucesso');
          this.router.navigate(['/consulta']);
        },
        error: (error) => {
          this.enviandoRequisicao = false;
          if (typeof error.error === 'string') {
            this.mensagem = error.error;
          } else {
            this.mensagem = 'Ocorreu erro ao agendar transferencia financeira.';
          }
        }
      });
  }

  markFormGroupTouched(formGroup: FormGroup): void {
    Object.values(formGroup.controls).forEach(control => {
      control.markAsTouched();
      if (control instanceof FormGroup) {
        this.markFormGroupTouched(control);
      }
    });
  }

}
