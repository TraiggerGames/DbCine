package es.recha.dbcine.model.postgre;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "empleados")
@JsonIgnoreProperties({"asignaciones","horariosSemanales","registrosHorasMensuales"})
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_empleado")
    private Integer idEmpleado;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "puesto", length = 50)
    private String puesto;

    @Column(name = "tipo_jornada", length = 15)
    private String tipoJornada;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "telefono", length = 15)
    private String telefono;

    @Column(name = "fecha_contratacion")
    private Date fechaContratacion;

    @Column(name = "salario_hora", precision = 8, scale = 2)
    private BigDecimal salarioHora;

    @Column(name = "activo")
    private Boolean activo;

    @Column(name = "horas_contrato", precision = 4, scale = 2)
    private BigDecimal horasContrato;

    @OneToMany(mappedBy = "empleado")
    private Set<AsignacionEmpleadoProyeccion> asignaciones = new HashSet<>();

    @OneToMany(mappedBy = "empleado")
    private Set<HorarioSemanalEmpleado> horariosSemanales = new HashSet<>();

    @OneToMany(mappedBy = "empleado")
    private Set<RegistroHorasMensual> registrosHorasMensuales = new HashSet<>();

    public Empleado() {}

    public Integer getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public String getTipoJornada() { return tipoJornada; }
    public void setTipoJornada(String tipoJornada) { this.tipoJornada = tipoJornada; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public Date getFechaContratacion() { return fechaContratacion; }
    public void setFechaContratacion(Date fechaContratacion) { this.fechaContratacion = fechaContratacion; }

    public BigDecimal getSalarioHora() { return salarioHora; }
    public void setSalarioHora(BigDecimal salarioHora) { this.salarioHora = salarioHora; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }

    public BigDecimal getHorasContrato() { return horasContrato; }
    public void setHorasContrato(BigDecimal horasContrato) { this.horasContrato = horasContrato; }

    public Set<AsignacionEmpleadoProyeccion> getAsignaciones() { return asignaciones; }
    public void setAsignaciones(Set<AsignacionEmpleadoProyeccion> asignaciones) { this.asignaciones = asignaciones; }

    public Set<HorarioSemanalEmpleado> getHorariosSemanales() { return horariosSemanales; }
    public void setHorariosSemanales(Set<HorarioSemanalEmpleado> horariosSemanales) { this.horariosSemanales = horariosSemanales; }

    public Set<RegistroHorasMensual> getRegistrosHorasMensuales() { return registrosHorasMensuales; }
    public void setRegistrosHorasMensuales(Set<RegistroHorasMensual> registrosHorasMensuales) { this.registrosHorasMensuales = registrosHorasMensuales; }
}
