package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.SalaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalaMongoRepository extends MongoRepository<SalaMongo, String> {

    // Buscar salas por nombre (ej: "Sala 1", "IMAX")
    Optional<SalaMongo> findByNombreSalaIgnoreCase(String nombreSala);

    // Listar solo las salas que están operativas
    List<SalaMongo> findByActivaTrue();

    // Filtrar por tipo de sala (3D, Premium, etc.)
    List<SalaMongo> findByTipoSala(String tipoSala);

    // Buscar salas con capacidad suficiente para un evento
    List<SalaMongo> findByCapacidadGreaterThanEqual(Integer capacidadMinima);

    // Consulta para obtener solo los asientos de una sala específica
    // sin traer toda la información de proyecciones (Optimización de red)
    @Query(value = "{ 'id': ?0 }", fields = "{ 'asientos': 1, '_id': 0 }")
    Optional<SalaMongo> findAsientosBySalaId(String salaId);
}