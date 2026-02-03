package es.recha.dbcine.model.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "salas")
public class SalaMongo {

    @Id
    private String id;

    private String nombreSala;
    private Integer capacidad;
    private String tipoSala;
    private String calidadSonido;
    private Boolean activa;

    @Builder.Default
    @JsonIgnore
    @DocumentReference(lazy = true)
    private Set<ProyeccionMongo> proyecciones = new HashSet<>();

    /**
     * En Mongo, embeber los asientos es mucho más eficiente que
     * tener una colección separada con miles de documentos pequeños.
     */
    @Builder.Default
    private Set<AsientoMongo> asientos = new HashSet<>();
}