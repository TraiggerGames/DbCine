
package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.EntradaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EntradaMongoRepository extends MongoRepository<EntradaMongo, String> {

    // Buscar todas las entradas de una compra específica
    List<EntradaMongo> findByCompraId(String compraId);

    // Buscar todas las entradas para una proyección (útil para ver ocupación)
    List<EntradaMongo> findByProyeccionId(String proyeccionId);

    // Verificar si un asiento específico ya está ocupado en una proyección
    Optional<EntradaMongo> findByProyeccionIdAndAsientoId(String proyeccionId, String asientoId);

    // Buscar entradas por fecha para reportes rápidos (usando el campo desnormalizado)
    List<EntradaMongo> findByFechaCompra(java.time.LocalDate fechaCompra);
}