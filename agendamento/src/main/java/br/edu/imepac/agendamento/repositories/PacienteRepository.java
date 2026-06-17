package br.edu.imepac.agendamento.repositories;

import br.edu.imepac.agendamento.models.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository<PacienteModel, Long> {
}