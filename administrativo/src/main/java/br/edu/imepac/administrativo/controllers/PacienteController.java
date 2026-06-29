package br.edu.imepac.administrativo.controllers;

import br.edu.imepac.commons.entities.Paciente;
import br.edu.imepac.commons.repositories.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping
    public ResponseEntity<Paciente> create(@RequestBody Paciente paciente) {
        return ResponseEntity.ok(repository.save(paciente));
    }
}