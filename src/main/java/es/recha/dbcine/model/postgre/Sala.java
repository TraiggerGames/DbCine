package es.recha.dbcine.model.postgre;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "salas")
@JsonIgnoreProperties({"proyecciones","asientos"})
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sala")
    private Integer idSala;

    @Column(name = "nombre_sala", length = 50)
    private String nombreSala;

    @Column(name = "capacidad")
    private Integer capacidad;

    @Column(name = "tipo_sala", length = 20)
    private String tipoSala;

    @Column(name = "calidad_sonido", length = 20)
    private String calidadSonido;

    @Column(name = "activa")
    private Boolean activa;

    @OneToMany(mappedBy = "sala")
    private Set<Proyeccion> proyecciones = new HashSet<>();

    @OneToMany(mappedBy = "sala")
    private Set<Asiento> asientos = new HashSet<>();

    public Sala() {}

    public Integer getIdSala() { return idSala; }
    public void setIdSala(Integer idSala) { this.idSala = idSala; }

    public String getNombreSala() { return nombreSala; }
    public void setNombreSala(String nombreSala) { this.nombreSala = nombreSala; }

    public Integer getCapacidad() { return capacidad; }
    public void setCapacidad(Integer capacidad) { this.capacidad = capacidad; }

    public String getTipoSala() { return tipoSala; }
    public void setTipoSala(String tipoSala) { this.tipoSala = tipoSala; }

    public String getCalidadSonido() { return calidadSonido; }
    public void setCalidadSonido(String calidadSonido) { this.calidadSonido = calidadSonido; }

    public Boolean getActiva() { return activa; }
    public void setActiva(Boolean activa) { this.activa = activa; }

    public Set<Proyeccion> getProyecciones() { return proyecciones; }
    public void setProyecciones(Set<Proyeccion> proyecciones) { this.proyecciones = proyecciones; }

    public Set<Asiento> getAsientos() { return asientos; }
    public void setAsientos(Set<Asiento> asientos) { this.asientos = asientos; }
}
