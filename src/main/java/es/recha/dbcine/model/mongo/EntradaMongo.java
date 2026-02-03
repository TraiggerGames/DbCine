package es.recha.dbcine.model.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "entradas")
// Mantenemos la restricción: no puede haber dos entradas para la misma proyección y asiento
@CompoundIndex(name = "proyeccion_asiento_idx", def = "{'proyeccion': 1, 'asiento': 1}", unique = true)
public class EntradaMongo {

    @Id
    private String id;

    @DocumentReference(lazy = true)
    private ProyeccionMongo proyeccion;

    @DocumentReference(lazy = true)
    private AsientoMongo asiento;

    @DocumentReference(lazy = true)
    private CompraMongo compra; // Asumiendo que crearás CompraMongo

    private BigDecimal precioPagado;

    // Campos desnormalizados para acceso rápido
    private String fila;
    private Integer butaca;

    private LocalDate fechaCompra;
    private String metodoPago;
}