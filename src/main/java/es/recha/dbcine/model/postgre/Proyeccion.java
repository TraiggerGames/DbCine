package es.recha.dbcine.model.postgre;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "proyecciones")
@JsonIgnoreProperties({"entradas","asignaciones"})
public class Proyeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proyeccion")
    private Integer idProyeccion;

    @ManyToOne
    @JoinColumn(name = "id_pelicula")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "id_sala")
    private Sala sala;

    @Column(name = "fecha_hora_inicio")
    private LocalDateTime fechaHoraInicio;

    @Column(name = "fecha_hora_fin")
    private LocalDateTime fechaHoraFin;

    @Column(name = "precio_entrada", precision = 8, scale = 2)
    private BigDecimal precioEntrada;

    @Column(name = "asientos_disponibles")
    private Integer asientosDisponibles;

    @OneToMany(mappedBy = "proyeccion")
    private Set<Entrada> entradas = new HashSet<>();

    @OneToMany(mappedBy = "proyeccion")
    private Set<AsignacionEmpleadoProyeccion> asignaciones = new HashSet<>();

    public Proyeccion() {}

    public Integer getIdProyeccion() { return idProyeccion; }
    public void setIdProyeccion(Integer idProyeccion) { this.idProyeccion = idProyeccion; }

    public Pelicula getPelicula() { return pelicula; }
    public void setPelicula(Pelicula pelicula) { this.pelicula = pelicula; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }

    public LocalDateTime getFechaHoraInicio() { return fechaHoraInicio; }
    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) { this.fechaHoraInicio = fechaHoraInicio; }

    public LocalDateTime getFechaHoraFin() { return fechaHoraFin; }
    public void setFechaHoraFin(LocalDateTime fechaHoraFin) { this.fechaHoraFin = fechaHoraFin; }

    public BigDecimal getPrecioEntrada() { return precioEntrada; }
    public void setPrecioEntrada(BigDecimal precioEntrada) { this.precioEntrada = precioEntrada; }

    public Integer getAsientosDisponibles() { return asientosDisponibles; }
    public void setAsientosDisponibles(Integer asientosDisponibles) { this.asientosDisponibles = asientosDisponibles; }

    public Set<Entrada> getEntradas() { return entradas; }
    public void setEntradas(Set<Entrada> entradas) { this.entradas = entradas; }

    public Set<AsignacionEmpleadoProyeccion> getAsignaciones() { return asignaciones; }
    public void setAsignaciones(Set<AsignacionEmpleadoProyeccion> asignaciones) { this.asignaciones = asignaciones; }
}
