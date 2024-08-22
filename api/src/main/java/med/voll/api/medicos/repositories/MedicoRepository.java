package med.voll.api.medicos.models;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<MedicoModel, Long> {
    Page<MedicoModel> findAllByAtivoTrue(Pageable pageable);
}
