package es.recha.dbcine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import es.recha.dbcine.model.postgre.AsignacionEmpleadoProyeccion;
import es.recha.dbcine.service.AsignacionEmpleadoProyeccionService;

@RestController
@RequestMapping("/api/asignaciones")
public class AsignacionEmpleadoProyeccionController {

    private final AsignacionEmpleadoProyeccionService service;

    public AsignacionEmpleadoProyeccionController(AsignacionEmpleadoProyeccionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<AsignacionEmpleadoProyeccion> crear(@RequestBody AsignacionEmpleadoProyeccion obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(obj));
    }

    @GetMapping
    public List<AsignacionEmpleadoProyeccion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public AsignacionEmpleadoProyeccion obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public AsignacionEmpleadoProyeccion actualizar(@PathVariable Integer id, @RequestBody AsignacionEmpleadoProyeccion obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
