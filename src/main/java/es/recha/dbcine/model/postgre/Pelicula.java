package es.recha.dbcine.model.postgre;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "peliculas")
@JsonIgnoreProperties({"proyecciones"})
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pelicula")
    private Integer idPelicula;

    @Column(name = "titulo", length = 200)
    private String titulo;

    @Column(name = "duracion_minutos")
    private Integer duracion;

    @Column(name = "clasificacion", length = 10)
    private String clasificacionEdad;

    @Column(name = "genero", length = 50)
    private String genero;

    @Column(name = "director", length = 100)
    private String director;


    @Column(name = "sinopsis", length = 100)
    private String sinopsis;

    @OneToMany(mappedBy = "pelicula")
    private Set<Proyeccion> proyecciones = new HashSet<>();

    public Pelicula() {}

    public Integer getIdPelicula() { return idPelicula; }
    public void setIdPelicula(Integer idPelicula) { this.idPelicula = idPelicula; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public Integer getDuracion() { return duracion; }
    public void setDuracion(Integer duracion) { this.duracion = duracion; }

    public String getClasificacionEdad() { return clasificacionEdad; }
    public void setClasificacionEdad(String clasificacionEdad) { this.clasificacionEdad = clasificacionEdad; }

    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }


    public String getSinopsis() { return sinopsis; }
    public void setSinopsis(String subtitulosDisponibles) { this.sinopsis = subtitulosDisponibles; }

    public Set<Proyeccion> getProyecciones() { return proyecciones; }
    public void setProyecciones(Set<Proyeccion> proyecciones) { this.proyecciones = proyecciones; }
}
