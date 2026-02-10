package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.RegistroHorasMensualMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RegistroHorasMensualMongoRepository extends MongoRepository<RegistroHorasMensualMongo, String> {

    // Buscar todos los registros de un empleado (historial completo)
    List<RegistroHorasMensualMongo> findByEmpleadoId(String empleadoId);

    // Buscar todos los registros de un mes y año concretos (para reportes mensuales)
    List<RegistroHorasMensualMongo> findByMesAndAnio(Integer mes, Integer anio);

    // Buscar el registro específico de un empleado para un mes determinado
    // Aprovecha el CompoundIndex definido en el modelo
    Optional<RegistroHorasMensualMongo> findByEmpleadoIdAndMesAndAnio(String empleadoId, Integer mes, Integer anio);

    // Buscar empleados que superaron un umbral de horas extra
    List<RegistroHorasMensualMongo> findByHorasExtraGreaterThan(java.math.BigDecimal umbral);
}