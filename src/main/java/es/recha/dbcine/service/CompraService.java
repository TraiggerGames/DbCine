package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.Compra;
import es.recha.dbcine.repository.postgres.CompraRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {

    private final CompraRepository repo;

    public CompraService(CompraRepository repo) {
        this.repo = repo;
    }

    public Compra crear(Compra obj) {
        obj.setIdCompra(null); // ID autonumérico
        return repo.save(obj);
    }

    public List<Compra> listar() {
        return repo.findAll();
    }

    public Compra obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Compra no encontrado con id " + id));
    }

    public Compra actualizar(Integer id, Compra obj) {
        obtener(id);
        obj.setIdCompra(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Compra no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
