package br.edu.imepac.agendamento.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Table(name = "fila_espera")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FilaEsperaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private PacienteModel paciente;

    @Column(nullable = false)
    private Long medicoId;

    @Column(nullable = false)
    private LocalDateTime dataHoraDesejada;
}