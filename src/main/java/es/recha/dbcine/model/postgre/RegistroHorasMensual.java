package es.recha.dbcine.model.postgre;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;

@Entity
@Table(name = "registro_horas_mensual")
@JsonIgnoreProperties({"empleado"})
public class RegistroHorasMensual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_registro")
    private Integer idRegistro;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    @Column(name = "mes")
    private Integer mes;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "horas_totales", precision = 6, scale = 2)
    private BigDecimal horasTotales;

    @Column(name = "horas_extra", precision = 6, scale = 2)
    private BigDecimal horasExtra;

    public RegistroHorasMensual() {}

    public Integer getIdRegistro() { return idRegistro; }
    public void setIdRegistro(Integer idRegistro) { this.idRegistro = idRegistro; }

    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }

    public Integer getMes() { return mes; }
    public void setMes(Integer mes) { this.mes = mes; }

    public Integer getAnio() { return anio; }
    public void setAnio(Integer anio) { this.anio = anio; }

    public BigDecimal getHorasTotales() { return horasTotales; }
    public void setHorasTotales(BigDecimal horasTotales) { this.horasTotales = horasTotales; }

    public BigDecimal getHorasExtra() { return horasExtra; }
    public void setHorasExtra(BigDecimal horasExtra) { this.horasExtra = horasExtra; }
}
