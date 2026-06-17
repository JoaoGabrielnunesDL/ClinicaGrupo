package br.edu.imepac.agendamento.repositories;

import br.edu.imepac.agendamento.models.FilaEsperaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilaEsperaRepository extends JpaRepository<FilaEsperaModel, Long> {
}