package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.Proyeccion;
import es.recha.dbcine.repository.postgres.ProyeccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProyeccionService {

    private final ProyeccionRepository repo;

    public ProyeccionService(ProyeccionRepository repo) {
        this.repo = repo;
    }

    public Proyeccion crear(Proyeccion obj) {
        obj.setIdProyeccion(null); // ID autonumérico
        return repo.save(obj);
    }

    public List<Proyeccion> listar() {
        return repo.findAll();
    }

    public Proyeccion obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Proyeccion no encontrado con id " + id));
    }

    public Proyeccion actualizar(Integer id, Proyeccion obj) {
        obtener(id);
        obj.setIdProyeccion(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Proyeccion no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
