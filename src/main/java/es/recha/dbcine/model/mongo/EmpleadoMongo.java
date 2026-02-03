package es.recha.dbcine.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "empleados")
public class EmpleadoMongo {

    @Id
    private Integer id; // Mirroring Postgres ID

    private String nombre;

    @Indexed(unique = true) // Ensures no duplicate emails in Mongo
    private String email;

    private String puesto;
    private String tipoJornada;
    private String telefono;

    private java.util.Date fechaContratacion;

    @Field(targetType = org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128)
    private BigDecimal salarioHora;

    private Boolean activo;

    @Field(targetType = org.springframework.data.mongodb.core.mapping.FieldType.DECIMAL128)
    private BigDecimal horasContrato;

    // NoSQL Flexibility
    private List<String> habilidades;
    private String observaciones;

    // The "Catch-all" for dynamic data
    private Map<String, Object> metadata;
}