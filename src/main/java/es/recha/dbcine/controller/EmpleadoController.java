package es.recha.dbcine.controller;

import es.recha.dbcine.model.mongo.EmpleadoMongo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import es.recha.dbcine.model.postgre.Empleado;
import es.recha.dbcine.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private final EmpleadoService service;

    public EmpleadoController(EmpleadoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Empleado> crear(@RequestBody Empleado obj) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.crear(obj));
    }
    @PostMapping("/migrar")
    public ResponseEntity<Integer> migrar(){
        int cantidad= service.migrarTodosAMongo();
        return ResponseEntity.status(HttpStatus.CREATED).body(cantidad);
    }
    @PostMapping("/migrar/{id}")
    public ResponseEntity<String> migrarPorID(@PathVariable Integer id){
        service.sincronizarAMongo(id);
        return ResponseEntity.ok("Migracion completa");
    }

    @GetMapping
    public List<Empleado> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Empleado obtener(@PathVariable Integer id) {
        return service.obtener(id);
    }

    @PutMapping("/{id}")
    public Empleado actualizar(@PathVariable Integer id, @RequestBody Empleado obj) {
        return service.actualizar(id, obj);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrar(@PathVariable Integer id) {
        service.borrar(id);
        return ResponseEntity.noContent().build();
    }
}
