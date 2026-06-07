package br.edu.imepac.administrativo.controllers;

import br.edu.imepac.administrativo.dtos.ConvenioRequest;
import br.edu.imepac.administrativo.dtos.ConvenioResponse;
import br.edu.imepac.administrativo.services.ConvenioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/convenios")
@Tag(name = "Administrativo - Convênios", description = "Endpoints para o gerenciamento de convênios")
public class ConvenioController {

    @Autowired
    private ConvenioService convenioService;

    @PostMapping
    @Operation(summary = "Cadastrar um novo convênio")
    public ResponseEntity<ConvenioResponse> cadastrar(@Valid @RequestBody ConvenioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(convenioService.cadastrar(request));
    }

    @GetMapping
    @Operation(summary = "Listar todos os convênios")
    public ResponseEntity<List<ConvenioResponse>> listarTodos() {
        return ResponseEntity.ok(convenioService.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar um convênio pelo ID")
    public ResponseEntity<ConvenioResponse> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(convenioService.buscarPorId(id));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Alterar dados de um convênio")
    public ResponseEntity<ConvenioResponse> alterar(@PathVariable Long id, @Valid @RequestBody ConvenioRequest request) {
        return ResponseEntity.ok(convenioService.alterar(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Excluir um convênio do sistema")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        convenioService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}