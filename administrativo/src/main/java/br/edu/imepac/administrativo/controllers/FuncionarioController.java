package br.edu.imepac.administrativo.controllers;

import br.edu.imepac.commons.entities.Funcionario;
import br.edu.imepac.commons.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository repository;

    @GetMapping
    public ResponseEntity<List<Funcionario>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Funcionario> create(@RequestBody Funcionario funcionario) {
        return ResponseEntity.ok(repository.save(funcionario));
    }
}