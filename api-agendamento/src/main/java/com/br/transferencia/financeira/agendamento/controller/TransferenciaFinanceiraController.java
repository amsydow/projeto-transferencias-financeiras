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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;


/*
 *  Classe Controller
 *  
 *  @author Alexandre Sydow
 */

@Tag(name = "Transferencia Financeira", description = "Api referente as transferências financeiras")
@RestController
@RequestMapping("/api/transferenciaFinanceira")
@CrossOrigin(origins = "*")
public class TransferenciaFinanceiraController {

    @Autowired
    private TransferenciaFinanceiraService service;

    @Operation(summary = "Lista todos os agendamentos")
    @GetMapping
    public ResponseEntity<List<TransferenciaFinanceira>> getAll() {
        return ResponseEntity.ok(service.listaAgendamentos());
    }

    @Operation(summary = "Cria novo agendamento")
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
