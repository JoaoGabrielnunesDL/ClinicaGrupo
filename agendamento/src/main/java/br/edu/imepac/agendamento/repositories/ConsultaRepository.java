package br.edu.imepac.agendamento.repositories;

import br.edu.imepac.agendamento.models.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ConsultaRepository extends JpaRepository<ConsultaModel, Long> {
    boolean existsByMedicoIdAndDataHoraAndStatus(Long medicoId, LocalDateTime dataHora, String status);
}