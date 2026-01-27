package es.recha.dbcine.repository.postgres;

import es.recha.dbcine.model.postgre.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
}
