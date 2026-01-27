package es.recha.dbcine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import es.recha.dbcine.model.postgre.Entrada;
import es.recha.dbcine.service.EntradaService;

@RestController
@RequestMapping("/api/entradas")
public class EntradaController {

    private final EntradaService service;

    public EntradaController(EntradaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Entrada> crear(@RequestBody Entrada obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(obj));
    }

    @GetMapping
    public List<Entrada> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Entrada obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Entrada actualizar(@PathVariable Integer id, @RequestBody Entrada obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
