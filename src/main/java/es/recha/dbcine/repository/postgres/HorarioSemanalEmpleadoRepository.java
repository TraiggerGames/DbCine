package es.recha.dbcine.repository.postgres;

import es.recha.dbcine.model.postgre.HorarioSemanalEmpleado;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HorarioSemanalEmpleadoRepository extends JpaRepository<HorarioSemanalEmpleado, Integer> {
}
