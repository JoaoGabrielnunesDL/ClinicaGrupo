package br.edu.imepac.agendamento.controllers;

import br.edu.imepac.agendamento.dtos.PacienteRequest;
import br.edu.imepac.agendamento.dtos.PacienteResponse;
import br.edu.imepac.agendamento.services.PacienteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/agendamento/pacientes")
@Tag(name = "Agendamento - Pacientes", description = "Endpoints de Pacientes")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    @Operation(summary = "Cadastrar Paciente")
    public ResponseEntity<PacienteResponse> cadastrar(@Valid @RequestBody PacienteRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pacienteService.cadastrar(request));
    }
}