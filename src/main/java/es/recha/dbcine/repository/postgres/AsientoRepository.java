package es.recha.dbcine.repository.postgres;

import es.recha.dbcine.model.postgre.Asiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsientoRepository extends JpaRepository<Asiento, Integer> {
}
