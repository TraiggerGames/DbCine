package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.Asiento;
import es.recha.dbcine.repository.postgres.AsientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsientoService {

    private final AsientoRepository repo;

    public AsientoService(AsientoRepository repo) {
        this.repo = repo;
    }

    public Asiento crear(Asiento obj) {
        obj.setIdAsiento(null); // ID autonumérico
        return repo.save(obj);
    }

    public List<Asiento> listar() {
        return repo.findAll();
    }

    public Asiento obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Asiento no encontrado con id " + id));
    }

    public Asiento actualizar(Integer id, Asiento obj) {
        obtener(id);
        obj.setIdAsiento(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Asiento no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
