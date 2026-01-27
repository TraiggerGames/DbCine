package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.Sala;
import es.recha.dbcine.repository.postgres.SalaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repo;

    public SalaService(SalaRepository repo) {
        this.repo = repo;
    }

    public Sala crear(Sala obj) {
        obj.setIdSala(null); // ID autonumérico
        return repo.save(obj);
    }

    public List<Sala> listar() {
        return repo.findAll();
    }

    public Sala obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Sala no encontrado con id " + id));
    }

    public Sala actualizar(Integer id, Sala obj) {
        obtener(id);
        obj.setIdSala(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Sala no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
