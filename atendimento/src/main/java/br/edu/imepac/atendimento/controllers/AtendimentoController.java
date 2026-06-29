package br.edu.imepac.atendimento.controllers;

import br.edu.imepac.atendimento.Atendimento;
import br.edu.imepac.atendimento.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/atendimentos")
public class AtendimentoController {

    @Autowired
    private AtendimentoRepository repository;

    @GetMapping
    public ResponseEntity<List<Atendimento>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Atendimento> create(@RequestBody Atendimento atendimento) {
        return ResponseEntity.ok(repository.save(atendimento));
    }
}