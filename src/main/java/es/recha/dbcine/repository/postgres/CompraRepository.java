package es.recha.dbcine.repository.postgres;

import es.recha.dbcine.model.postgre.Compra;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompraRepository extends JpaRepository<Compra, Integer> {
}
