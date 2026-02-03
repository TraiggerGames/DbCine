package es.recha.dbcine.model.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "asignaciones_empleados")
public class AsignacionEmpleadoProyeccionMongo {

    @Id
    private String id;

    @DocumentReference(lazy = true)
    @JsonIgnore
    private ProyeccionMongo proyeccion;

    @DocumentReference(lazy = true)
    @JsonIgnore
    private EmpleadoMongo empleado;

    private String rol; // Ej: "Taquilla", "Limpieza", "Proyeccionista"
}