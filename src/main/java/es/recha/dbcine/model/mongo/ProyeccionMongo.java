package es.recha.dbcine.model.mongo;

import es.recha.dbcine.model.postgre.AsignacionEmpleadoProyeccion;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "proyecciones")
public class ProyeccionMongo {

    @Id
    private String id;

    @DocumentReference(lazy = true)
    private PeliculaMongo pelicula;

    // Asumo que tu modelo de Sala también seguirá la nomenclatura SalaMongo
    @DocumentReference(lazy = true)
    private SalaMongo sala;

    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFin;
    private BigDecimal precioEntrada;
    private Integer asientosDisponibles;

    @Builder.Default
    @JsonIgnore
    @DocumentReference(lazy = true)
    private Set<EntradaMongo> entradas = new HashSet<>();

    @Builder.Default
    @JsonIgnore
    @DocumentReference(lazy = true)
    private Set<AsignacionEmpleadoProyeccionMongo> asignaciones = new HashSet<>();
}