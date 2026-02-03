package es.recha.dbcine.model.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "horarios_semanales_empleados")
public class HorarioSemanalEmpleadoMongo {

    @Id
    private String id;

    @DocumentReference(lazy = true)
    @JsonIgnore // Evita recursividad al serializar al Empleado
    private EmpleadoMongo empleado;

    private int diaSemana;

    private LocalTime horaEntrada;
    private LocalTime horaSalida;
}