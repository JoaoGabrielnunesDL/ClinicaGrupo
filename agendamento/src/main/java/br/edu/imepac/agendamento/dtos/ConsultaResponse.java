package br.edu.imepac.agendamento.dtos;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsultaResponse {
    private Long id;
    private Long pacienteId;
    private Long medicoId;
    private LocalDateTime dataHora;
    private String status;
}