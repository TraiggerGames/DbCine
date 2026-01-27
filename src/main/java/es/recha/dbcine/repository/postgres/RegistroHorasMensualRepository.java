package es.recha.dbcine.repository.postgres;

import es.recha.dbcine.model.postgre.RegistroHorasMensual;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistroHorasMensualRepository extends JpaRepository<RegistroHorasMensual, Integer> {
}
