package es.recha.dbcine.repository.postgres;

import es.recha.dbcine.model.postgre.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeliculaRepository extends JpaRepository<Pelicula, Integer> {
}
