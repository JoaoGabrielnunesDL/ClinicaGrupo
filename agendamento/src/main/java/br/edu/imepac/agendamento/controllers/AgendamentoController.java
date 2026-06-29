package br.edu.imepac.agendamento.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/agendamentos")
public class AgendamentoController {

    @GetMapping
    public ResponseEntity<List<String>> findAll() {
        return ResponseEntity.ok(List.of("Agendamento 1", "Agendamento 2"));
    }
}