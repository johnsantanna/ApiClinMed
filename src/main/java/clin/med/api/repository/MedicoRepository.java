package clin.med.api.repository;

import clin.med.api.model.Medico;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Optional<Medico> findMedicoById(Long id);
    Page<Medico> findAllByActiveIs(Pageable paginacao, int active);
}