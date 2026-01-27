package es.recha.dbcine.repository.postgres;

import es.recha.dbcine.model.postgre.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntradaRepository extends JpaRepository<Entrada, Integer> {
}
