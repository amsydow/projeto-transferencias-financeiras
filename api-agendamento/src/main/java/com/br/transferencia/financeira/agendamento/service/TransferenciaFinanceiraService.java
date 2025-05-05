package com.br.transferencia.financeira.agendamento.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.transferencia.financeira.agendamento.business.TransferenciaFinanceiraBusiness;
import com.br.transferencia.financeira.agendamento.model.TransferenciaFinanceira;
import com.br.transferencia.financeira.agendamento.repository.TransferenciaFinanceiraRepository;

/**
 * Classe Serviçe
 *
 * @author Alexandre Sydow
 */

@Service
public class TransferenciaFinanceiraService {

	@Autowired
	private TransferenciaFinanceiraRepository repository;
	
	@Autowired
	private TransferenciaFinanceiraBusiness business;

	public TransferenciaFinanceiraService(TransferenciaFinanceiraRepository repository,
			TransferenciaFinanceiraBusiness business) {
		this.repository = repository;
		this.business = business;
	}

	public List<TransferenciaFinanceira> listaAgendamentos() {
		return repository.findAll();
	}
	
	public TransferenciaFinanceira agendarTransferencia(TransferenciaFinanceira transferencia) {
		transferencia.setDataAgendamento(LocalDate.now());
		
		BigDecimal taxa = business.calcularTaxa(transferencia);
        transferencia.setTaxa(taxa);
		
        return repository.save(transferencia);
	}
	
}
