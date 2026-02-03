package es.recha.dbcine.model.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "registros_horas_mensuales")
// Aseguramos que solo exista un registro por empleado/mes/año
@CompoundIndex(name = "empleado_mes_anio_idx", def = "{'empleado': 1, 'mes': 1, 'anio': 1}", unique = true)
public class RegistroHorasMensualMongo {

    @Id
    private String id;

    @DocumentReference(lazy = true)
    @JsonIgnore
    private EmpleadoMongo empleado;

    private Integer mes;
    private Integer anio;

    private BigDecimal horasTotales;
    private BigDecimal horasExtra;
}