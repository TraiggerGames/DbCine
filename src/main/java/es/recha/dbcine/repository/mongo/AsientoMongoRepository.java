package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.AsientoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AsientoMongoRepository extends MongoRepository<AsientoMongo, String> {

    // Obtener todos los asientos de una sala específica
    List<AsientoMongo> findBySalaId(String salaId);

    // Buscar todos los asientos activos de una sala (para la venta)
    List<AsientoMongo> findBySalaIdAndActivoTrue(String salaId);

    // Buscar un asiento específico por sus coordenadas (aprovecha el CompoundIndex)
    Optional<AsientoMongo> findBySalaIdAndFilaAndNumero(String salaId, String fila, Integer numero);

    // Listar asientos de una fila concreta en una sala
    List<AsientoMongo> findBySalaIdAndFila(String salaId, String fila);
}