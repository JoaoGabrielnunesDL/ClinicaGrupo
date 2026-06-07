package br.edu.imepac.administrativo.repositories;

import br.edu.imepac.administrativo.models.ConvenioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConvenioRepository extends JpaRepository<ConvenioModel, Long> {
    // As chaves se fecham aqui embaixo e a herança está correta!
}
