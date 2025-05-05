package com.br.transferencia.financeira.agendamento.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;


/**
 * Classe Model
 *
 * @author Alexandre Sydow
 */

@Entity
@Table(name = "TRANSFERENCIA_FINANCEIRA")
public class TransferenciaFinanceira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull(message = "Conta de origem deve ser informada")
	@Pattern(regexp = "\\d{10}", message = "Conta de origem deve ter 10 digitos")
	private String contaOrigem;
	
	@NotNull(message = "Conta de destino deve ser informada")
	@Pattern(regexp = "\\d{10}", message = "Conta de destino deve ter 10 digitos")
	private String contaDestino;
	
	@NotNull(message = "Valor da transferencia deve ser informado")
	private BigDecimal valorTransferencia;
	
	private BigDecimal taxa;
	
	@NotNull(message = "Data da transferencia deve ser informada")
	private LocalDate dataTransferencia;
	
	private LocalDate dataAgendamento;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContaOrigem() {
		return contaOrigem;
	}
	public void setContaOrigem(String contaOrigem) {
		this.contaOrigem = contaOrigem;
	}
	public String getContaDestino() {
		return contaDestino;
	}
	public void setContaDestino(String contaDestino) {
		this.contaDestino = contaDestino;
	}
	public BigDecimal getValorTransferencia() {
		return valorTransferencia;
	}
	public void setValorTransferencia(BigDecimal valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}
	public BigDecimal getTaxa() {
		return taxa;
	}
	public void setTaxa(BigDecimal taxa) {
		this.taxa = taxa;
	}
	public LocalDate getDataTransferencia() {
		return dataTransferencia;
	}
	public void setDataTransferencia(LocalDate dataTransferencia) {
		this.dataTransferencia = dataTransferencia;
	}
	public LocalDate getDataAgendamento() {
		return dataAgendamento;
	}
	public void setDataAgendamento(LocalDate dataAgendamento) {
		this.dataAgendamento = dataAgendamento;
	}
	
}
