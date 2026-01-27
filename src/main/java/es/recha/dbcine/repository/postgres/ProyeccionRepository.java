package es.recha.dbcine.repository.postgres;

import es.recha.dbcine.model.postgre.Proyeccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyeccionRepository extends JpaRepository<Proyeccion, Integer> {
}
