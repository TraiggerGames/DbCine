package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.AsignacionEmpleadoProyeccion;
import es.recha.dbcine.repository.postgres.AsignacionEmpleadoProyeccionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignacionEmpleadoProyeccionService {

    private final AsignacionEmpleadoProyeccionRepository repo;

    public AsignacionEmpleadoProyeccionService(AsignacionEmpleadoProyeccionRepository repo) {
        this.repo = repo;
    }

    public AsignacionEmpleadoProyeccion crear(AsignacionEmpleadoProyeccion obj) {
        obj.setIdAsignacion(null); // ID autonumérico
        return repo.save(obj);
    }

    public List<AsignacionEmpleadoProyeccion> listar() {
        return repo.findAll();
    }

    public AsignacionEmpleadoProyeccion obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("AsignacionEmpleadoProyeccion no encontrado con id " + id));
    }

    public AsignacionEmpleadoProyeccion actualizar(Integer id, AsignacionEmpleadoProyeccion obj) {
        obtener(id);
        obj.setIdAsignacion(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("AsignacionEmpleadoProyeccion no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
