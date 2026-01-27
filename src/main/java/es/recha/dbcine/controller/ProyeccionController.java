package es.recha.dbcine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import es.recha.dbcine.model.postgre.Proyeccion;
import es.recha.dbcine.service.ProyeccionService;

@RestController
@RequestMapping("/api/proyecciones")
public class ProyeccionController {

    private final ProyeccionService service;

    public ProyeccionController(ProyeccionService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Proyeccion> crear(@RequestBody Proyeccion obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(obj));
    }

    @GetMapping
    public List<Proyeccion> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Proyeccion obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Proyeccion actualizar(@PathVariable Integer id, @RequestBody Proyeccion obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
