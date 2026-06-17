package br.edu.imepac.agendamento.dtos;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class PacienteRequest {
    @NotBlank(message = "O nome é obrigatório")
    private String nome;
    @NotBlank(message = "O CPF é obrigatório")
    private String cpf;
    private String telefone;
}