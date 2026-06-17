package br.edu.imepac.agendamento.dtos;
import lombok.Data;

@Data
public class PacienteResponse {
    private Long id;
    private String nome;
    private String cpf;
    private String telefone;
}