package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.Entrada;
import es.recha.dbcine.repository.postgres.EntradaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaService {

    private final EntradaRepository repo;

    public EntradaService(EntradaRepository repo) {
        this.repo = repo;
    }

    public Entrada crear(Entrada obj) {
        obj.setIdEntrada(null); // ID autonumérico
        return repo.save(obj);
    }

    public List<Entrada> listar() {
        return repo.findAll();
    }

    public Entrada obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Entrada no encontrado con id " + id));
    }

    public Entrada actualizar(Integer id, Entrada obj) {
        obtener(id);
        obj.setIdEntrada(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Entrada no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
