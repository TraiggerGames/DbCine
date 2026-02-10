package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.PeliculaMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaMongoRepository extends MongoRepository<PeliculaMongo, String> {

    // Buscar películas por título (contiene, ignorando mayúsculas/minúsculas)
    List<PeliculaMongo> findByTituloContainingIgnoreCase(String titulo);

    // Filtrar por género (ej: "Terror", "Comedia")
    List<PeliculaMongo> findByGeneroIgnoreCase(String genero);

    // Filtrar películas por clasificación de edad
    List<PeliculaMongo> findByClasificacionEdad(String clasificacionEdad);

    // Buscar películas con una duración menor o igual a X minutos
    List<PeliculaMongo> findByDuracionLessThanEqual(Integer duracionMax);

    // Buscar por director
    List<PeliculaMongo> findByDirectorContainingIgnoreCase(String director);
}