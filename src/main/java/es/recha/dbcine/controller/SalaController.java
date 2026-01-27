package es.recha.dbcine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import es.recha.dbcine.model.postgre.Sala;
import es.recha.dbcine.service.SalaService;

@RestController
@RequestMapping("/api/salas")
public class SalaController {

    private final SalaService service;

    public SalaController(SalaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Sala> crear(@RequestBody Sala obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(obj));
    }

    @GetMapping
    public List<Sala> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Sala obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Sala actualizar(@PathVariable Integer id, @RequestBody Sala obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
