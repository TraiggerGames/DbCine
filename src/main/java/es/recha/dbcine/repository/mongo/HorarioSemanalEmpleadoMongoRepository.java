package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.HorarioSemanalEmpleadoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioSemanalEmpleadoMongoRepository extends MongoRepository<HorarioSemanalEmpleadoMongo, String> {

    // Obtener todo el horario semanal de un empleado específico
    List<HorarioSemanalEmpleadoMongo> findByEmpleadoId(String empleadoId);

    // Obtener todos los empleados que trabajan un día concreto (1=Lunes, 7=Domingo)
    List<HorarioSemanalEmpleadoMongo> findByDiaSemana(int diaSemana);

    // Buscar el horario de un empleado para un día específico
    List<HorarioSemanalEmpleadoMongo> findByEmpleadoIdAndDiaSemana(String empleadoId, int diaSemana);

    // Eliminar todos los horarios de un empleado (útil para reasignaciones completas)
    void deleteByEmpleadoId(String empleadoId);
}