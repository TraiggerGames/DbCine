package es.recha.dbcine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import es.recha.dbcine.model.postgre.Asiento;
import es.recha.dbcine.service.AsientoService;

@RestController
@RequestMapping("/api/asientos")
public class AsientoController {

    private final AsientoService service;

    public AsientoController(AsientoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Asiento> crear(@RequestBody Asiento obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(obj));
    }

    @GetMapping
    public List<Asiento> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Asiento obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Asiento actualizar(@PathVariable Integer id, @RequestBody Asiento obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
