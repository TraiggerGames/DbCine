package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.AsignacionEmpleadoProyeccionMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsignacionEmpleadoProyeccionMongoRepository extends MongoRepository<AsignacionEmpleadoProyeccionMongo, String> {

    // Buscar todos los empleados asignados a una proyección concreta
    List<AsignacionEmpleadoProyeccionMongo> findByProyeccionId(String proyeccionId);

    // Buscar todas las asignaciones de un empleado específico
    List<AsignacionEmpleadoProyeccionMongo> findByEmpleadoId(String empleadoId);

    // Buscar por rol en una proyección (ej: ¿Quién limpia en la proyeccion X?)
    List<AsignacionEmpleadoProyeccionMongo> findByProyeccionIdAndRol(String proyeccionId, String rol);
}