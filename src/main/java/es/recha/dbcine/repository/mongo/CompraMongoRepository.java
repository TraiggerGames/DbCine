package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.CompraMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompraMongoRepository extends MongoRepository<CompraMongo, String> {

    // Buscar compras por el email del cliente
    List<CompraMongo> findByEmailCliente(String emailCliente);

    // Buscar por estado (ej: "COMPLETADO", "PENDIENTE")
    List<CompraMongo> findByEstado(String estado);

    // Buscar una compra por su referencia de pago única
    Optional<CompraMongo> findByReferenciaPago(String referenciaPago);
}