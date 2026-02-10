package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.ProyeccionMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProyeccionMongoRepository extends MongoRepository<ProyeccionMongo, String> {

    // Buscar proyecciones por película
    List<ProyeccionMongo> findByPeliculaId(String peliculaId);

    // Buscar proyecciones en una sala específica
    List<ProyeccionMongo> findBySalaId(String salaId);

    // Obtener la cartelera: proyecciones entre dos fechas (ej: hoy)
    List<ProyeccionMongo> findByFechaHoraInicioBetween(LocalDateTime inicio, LocalDateTime fin);

    // Buscar proyecciones que aún tengan asientos disponibles
    List<ProyeccionMongo> findByAsientosDisponiblesGreaterThan(Integer minimo);

    // Consulta personalizada para encontrar solapamientos de horario en una sala
    @Query("{ 'sala.id': ?0, $or: [ " +
            "{ 'fechaHoraInicio': { $lt: ?2 }, 'fechaHoraFin': { $gt: ?1 } }" +
            "] }")
    List<ProyeccionMongo> findOverlappingProyecciones(String salaId, LocalDateTime inicio, LocalDateTime fin);
}