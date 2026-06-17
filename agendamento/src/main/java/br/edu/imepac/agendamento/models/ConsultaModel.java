package br.edu.imepac.agendamento.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "consultas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteModel paciente;

    @Column(nullable = false)
    private Long medicoId; 

    @Column(nullable = false)
    private LocalDateTime dataHora;

    @Column(nullable = false, length = 20)
    private String status; // AGENDADA, CANCELADA, REALIZADA
}