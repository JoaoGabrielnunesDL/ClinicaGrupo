package br.edu.imepac.agendamento.dtos;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsultaRequest {
    @NotNull(message = "O ID do paciente é obrigatório")
    private Long pacienteId;
    @NotNull(message = "O ID do médico é obrigatório")
    private Long medicoId;
    @NotNull(message = "A data e hora são obrigatórias")
    private LocalDateTime dataHora;
}