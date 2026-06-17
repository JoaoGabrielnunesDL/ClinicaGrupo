package br.edu.imepac.agendamento.controllers;

import br.edu.imepac.agendamento.dtos.ConsultaRequest;
import br.edu.imepac.agendamento.dtos.ConsultaResponse;
import br.edu.imepac.agendamento.services.ConsultaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/consultas")
@Tag(name = "Agendamento - Consultas", description = "Endpoints de Consultas")
public class ConsultaController {

    @Autowired
    private ConsultaService consultaService;

    @GetMapping("/disponibilidade")
    @Operation(summary = "Verificar Disponibilidade de Horário")
    public ResponseEntity<Boolean> verificarDisponibilidade(
            @RequestParam Long medicoId, 
            @RequestParam LocalDateTime dataHora) {
        return ResponseEntity.ok(consultaService.isHorarioDisponivel(medicoId, dataHora));
    }

    @PostMapping
    @Operation(summary = "Agendar Consulta")
    public ResponseEntity<?> agendar(@Valid @RequestBody ConsultaRequest request) {
        try {
            ConsultaResponse response = consultaService.agendarConsulta(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(response);
        } catch (RuntimeException ex) {
         
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @PutMapping("/{id}/cancelar")
    @Operation(summary = "Cancelar Consulta")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        consultaService.cancelarConsulta(id);
        return ResponseEntity.noContent().build();
    }
}