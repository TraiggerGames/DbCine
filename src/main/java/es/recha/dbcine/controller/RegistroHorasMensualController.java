package es.recha.dbcine.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import es.recha.dbcine.model.postgre.RegistroHorasMensual;
import es.recha.dbcine.service.RegistroHorasMensualService;

@RestController
@RequestMapping("/api/registro-horas")
public class RegistroHorasMensualController {

    private final RegistroHorasMensualService service;

    public RegistroHorasMensualController(RegistroHorasMensualService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<RegistroHorasMensual> crear(@RequestBody RegistroHorasMensual obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(obj));
    }

    @GetMapping
    public List<RegistroHorasMensual> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public RegistroHorasMensual obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public RegistroHorasMensual actualizar(@PathVariable Integer id, @RequestBody RegistroHorasMensual obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
