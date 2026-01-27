package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.Pelicula;
import es.recha.dbcine.repository.postgres.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeliculaService {

    private final PeliculaRepository repo;

    public PeliculaService(PeliculaRepository repo) {
        this.repo = repo;
    }

    public Pelicula crear(Pelicula obj) {
        obj.setIdPelicula(null); // ID autonumérico
        return repo.save(obj);
    }

    public List<Pelicula> listar() {
        return repo.findAll();
    }

    public Pelicula obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Pelicula no encontrado con id " + id));
    }

    public Pelicula actualizar(Integer id, Pelicula obj) {
        obtener(id);
        obj.setIdPelicula(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Pelicula no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
