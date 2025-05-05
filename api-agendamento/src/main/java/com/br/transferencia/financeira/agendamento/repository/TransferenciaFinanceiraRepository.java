package com.br.transferencia.financeira.agendamento.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.transferencia.financeira.agendamento.model.TransferenciaFinanceira;

/**
 * Classe Repository
 *
 * @author Alexandre Sydow
*/

@Repository
public interface TransferenciaFinanceiraRepository extends JpaRepository<TransferenciaFinanceira, Long> {
}
