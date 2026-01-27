package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.RegistroHorasMensual;
import es.recha.dbcine.repository.postgres.RegistroHorasMensualRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistroHorasMensualService {

    private final RegistroHorasMensualRepository repo;

    public RegistroHorasMensualService(RegistroHorasMensualRepository repo) {
        this.repo = repo;
    }

    public RegistroHorasMensual crear(RegistroHorasMensual obj) {
        obj.setIdRegistro(null); // ID autonumérico
        return repo.save(obj);
    }

    public List<RegistroHorasMensual> listar() {
        return repo.findAll();
    }

    public RegistroHorasMensual obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("RegistroHorasMensual no encontrado con id " + id));
    }

    public RegistroHorasMensual actualizar(Integer id, RegistroHorasMensual obj) {
        obtener(id);
        obj.setIdRegistro(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("RegistroHorasMensual no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
