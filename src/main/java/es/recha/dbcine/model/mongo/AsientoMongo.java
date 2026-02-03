package es.recha.dbcine.model.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "asientos")
// Replicamos el UniqueConstraint de SQL con un índice compuesto en Mongo
@CompoundIndex(name = "sala_fila_numero_idx", def = "{'sala': 1, 'fila': 1, 'numero': 1}", unique = true)
public class AsientoMongo {

    @Id
    private String id;

    @DocumentReference(lazy = true)
    private SalaMongo sala;

    private String fila;
    private Integer numero;
    private String tipo;
    private Boolean activo;
}