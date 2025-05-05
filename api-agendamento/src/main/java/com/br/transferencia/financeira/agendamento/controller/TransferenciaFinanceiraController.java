package com.br.transferencia.financeira.agendamento.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.transferencia.financeira.agendamento.model.TransferenciaFinanceira;
import com.br.transferencia.financeira.agendamento.service.TransferenciaFinanceiraService;


/*
 *  Classe Controller
 *  
 *  @author Alexandre Sydow
 */

@RestController
@RequestMapping("/api/transferenciaFinanceira")
@CrossOrigin(origins = "*")
public class TransferenciaFinanceiraController {

    @Autowired
    private TransferenciaFinanceiraService service;

    @GetMapping
    public ResponseEntity<List<TransferenciaFinanceira>> getAll() {
        return ResponseEntity.ok(service.listaAgendamentos());
    }

    @PostMapping
    public ResponseEntity<?> agendarTransferencia(@Valid @RequestBody TransferenciaFinanceira transferencia) {
        try {
        	TransferenciaFinanceira transferenciaGravada = service.agendarTransferencia(transferencia);
            return ResponseEntity.status(HttpStatus.CREATED).body(transferenciaGravada);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }	
	
}
