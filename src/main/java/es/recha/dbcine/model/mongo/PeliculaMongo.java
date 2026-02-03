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
@Document(collection = "peliculas")
public class PeliculaMongo {

    @Id
    private String id; // Mongo prefiere String para el ObjectId

    private String titulo;

    private Integer duracion;

    private String clasificacionEdad;

    private String genero;

    private String director;

    private String sinopsis;

    @Builder.Default
    @JsonIgnore // Evita ciclos infinitos al serializar a JSON
    @DocumentReference(lazy = true)
    private Set<ProyeccionMongo> proyecciones = new HashSet<>();
}
