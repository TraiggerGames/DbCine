package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.HorarioSemanalEmpleado;
import es.recha.dbcine.repository.postgres.HorarioSemanalEmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HorarioSemanalEmpleadoService {

    private final HorarioSemanalEmpleadoRepository repo;

    public HorarioSemanalEmpleadoService(HorarioSemanalEmpleadoRepository repo) {
        this.repo = repo;
    }

    public HorarioSemanalEmpleado crear(HorarioSemanalEmpleado obj) {
        obj.setIdHorarioSemanal(null); // ID autonumérico
        return repo.save(obj);
    }

    public List<HorarioSemanalEmpleado> listar() {
        return repo.findAll();
    }

    public HorarioSemanalEmpleado obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("HorarioSemanalEmpleado no encontrado con id " + id));
    }

    public HorarioSemanalEmpleado actualizar(Integer id, HorarioSemanalEmpleado obj) {
        obtener(id);
        obj.setIdHorarioSemanal(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("HorarioSemanalEmpleado no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
