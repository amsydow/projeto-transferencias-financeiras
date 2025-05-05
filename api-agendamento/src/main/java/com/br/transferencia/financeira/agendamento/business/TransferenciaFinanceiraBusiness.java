package com.br.transferencia.financeira.agendamento.business;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

import com.br.transferencia.financeira.agendamento.model.TransferenciaFinanceira;

/*
 *  Classe de Regras de Negócio
 *  
 *  @author Alexandre Sydow
 */

@Component
public class TransferenciaFinanceiraBusiness {

	 public BigDecimal calcularTaxa(TransferenciaFinanceira transferencia) {
	        LocalDate today = LocalDate.now();
	        LocalDate dataTransferencia = transferencia.getDataTransferencia();
	        
	        long diasTransferencia = ChronoUnit.DAYS.between(today, dataTransferencia);
	        
	        if (diasTransferencia < 0) {
	        	throw new IllegalArgumentException("Data de transfencia não pode ser anterior a data de hoje.");
	        }
	        
	        BigDecimal valorTransferencia = transferencia.getValorTransferencia();
	        BigDecimal taxa;
	        
	        // Aplicando regras
	        if (diasTransferencia == 0) {
	        	BigDecimal taxaFixa = new BigDecimal("3.00");
	        	BigDecimal porcentagemTaxa = valorTransferencia.multiply(new BigDecimal("0.025")); //taxa de 2.5% 
	        	taxa = taxaFixa.add(porcentagemTaxa);  //+ 3,00 
	        } else if (diasTransferencia <= 10) {
	        	taxa = new BigDecimal("12.00"); //12,00 taxa fixa
	        } else if (diasTransferencia <= 20) {
	        	taxa = valorTransferencia.multiply(new BigDecimal("0.082")); //taxa de 8.2%
	        } else if (diasTransferencia <= 30) {
	        	taxa = valorTransferencia.multiply(new BigDecimal("0.069")); //taxa de 6.9%
	        } else if (diasTransferencia <= 40) {
	        	taxa = valorTransferencia.multiply(new BigDecimal("0.047")); //taxa de 4.7%
	        } else if (diasTransferencia <= 50) {
	        	taxa = valorTransferencia.multiply(new BigDecimal("0.017")); //taxa de 1.7%
	        } else {
	        	throw new IllegalArgumentException("Não há taxa aplicável para esse período de transferência.");
	        }
	        
	        return taxa.setScale(2, RoundingMode.HALF_UP);
	    }
	
}
