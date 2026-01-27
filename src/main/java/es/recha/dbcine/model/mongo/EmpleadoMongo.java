package es.recha.dbcine.model.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Document(collection = "empleados")
public class EmpleadoMongo {

    @Id
    private Integer id; // Mismo ID que en Postgres

    private String nombre;
    private String email;

    private String puesto;
    private String tipoJornada;
    private String telefono;
    private java.util.Date fechaContratacion;    private BigDecimal salarioHora;
    private Boolean activo;
    private BigDecimal horasContrato;
    // Aquí añadimos la flexibilidad de NoSQL:
    private List<String> habilidades;
    private String observaciones;
    private Map<String, Object> metadata; // Para cualquier dato extra dinámico

    // Constructores, Getters y Setters
    public EmpleadoMongo() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public List<String> getHabilidades() { return habilidades; }
    public void setHabilidades(List<String> habilidades) { this.habilidades = habilidades; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getTipoJornada() {
        return tipoJornada;
    }

    public void setTipoJornada(String tipoJornada) {
        this.tipoJornada = tipoJornada;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public BigDecimal getSalarioHora() {
        return salarioHora;
    }

    public void setSalarioHora(BigDecimal salarioHora) {
        this.salarioHora = salarioHora;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public BigDecimal getHorasContrato() {
        return horasContrato;
    }

    public void setHorasContrato(BigDecimal horasContrato) {
        this.horasContrato = horasContrato;
    }
}