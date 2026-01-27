package es.recha.dbcine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import es.recha.dbcine.model.postgre.HorarioSemanalEmpleado;
import es.recha.dbcine.service.HorarioSemanalEmpleadoService;

@RestController
@RequestMapping("/api/horarios-semanales")
public class HorarioSemanalEmpleadoController {

    private final HorarioSemanalEmpleadoService service;

    public HorarioSemanalEmpleadoController(HorarioSemanalEmpleadoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<HorarioSemanalEmpleado> crear(@RequestBody HorarioSemanalEmpleado obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(obj));
    }

    @GetMapping
    public List<HorarioSemanalEmpleado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public HorarioSemanalEmpleado obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public HorarioSemanalEmpleado actualizar(@PathVariable Integer id, @RequestBody HorarioSemanalEmpleado obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
