package es.recha.dbcine.repository.postgres;

import es.recha.dbcine.model.postgre.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Integer> {
}
