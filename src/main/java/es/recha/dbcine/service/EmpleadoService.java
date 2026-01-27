package es.recha.dbcine.service;

import es.recha.dbcine.model.postgre.Empleado;
import es.recha.dbcine.model.mongo.EmpleadoMongo; // Tu nuevo modelo
import es.recha.dbcine.repository.postgres.EmpleadoRepository;
import es.recha.dbcine.repository.mongo.EmpleadoMongoRepository; // Tu nuevo repo
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpleadoService {

    private final EmpleadoRepository repo;
    private final EmpleadoMongoRepository mongoRepo;

    public EmpleadoService(EmpleadoRepository repo, EmpleadoMongoRepository mongoRepo) {
        this.repo = repo;
        this.mongoRepo = mongoRepo;
    }

    // Usamos @Transactional para que si falla Mongo, no se quede a medias en Postgres
    @Transactional
    public Empleado crear(Empleado obj) {
        obj.setIdEmpleado(null);
        Empleado guardado = repo.save(obj);

        // --- COMUNICACIÓN POLÍGLOTA ---
        // Al crear en Postgres, inicializamos su rastro en Mongo
        EmpleadoMongo mongoObj = new EmpleadoMongo();
        mongoObj.setId(guardado.getIdEmpleado()); // Vinculamos IDs
        mongoObj.setNombre(guardado.getNombre());
        mongoObj.setEmail(guardado.getEmail());
        mongoObj.setActivo(guardado.getActivo());
        mongoObj.setPuesto(guardado.getPuesto());
        mongoObj.setTelefono(guardado.getTelefono());
        mongoObj.setFechaContratacion(guardado.getFechaContratacion());
        mongoObj.setSalarioHora(guardado.getSalarioHora());
        mongoObj.setHorasContrato(guardado.getHorasContrato());

        mongoRepo.save(mongoObj);

        return guardado;
    }

    // Nuevo método para pasar datos específicos de una a otra manualmente
    public void sincronizarAMongo(Integer id) {
        Empleado sql = obtener(id);

        EmpleadoMongo mongo = mongoRepo.findById(id)
                .orElse(new EmpleadoMongo());

        mongo.setId(sql.getIdEmpleado());
        mongo.setNombre(sql.getNombre());
        mongo.setEmail(sql.getEmail());
        mongo.setId(sql.getIdEmpleado());
        mongo.setNombre(sql.getNombre());
        mongo.setPuesto(sql.getPuesto());
        mongo.setTipoJornada(sql.getTipoJornada());
        mongo.setEmail(sql.getEmail());
        mongo.setTelefono(sql.getTelefono());
        mongo.setFechaContratacion(sql.getFechaContratacion());
        mongo.setSalarioHora(sql.getSalarioHora());
        mongo.setActivo(sql.getActivo());
        mongo.setHorasContrato(sql.getHorasContrato());
        mongoRepo.save(mongo);
    }

    public int migrarTodosAMongo() {
        // 1. Obtenemos todos los registros de la base de datos relacional
        List<Empleado> empleadosSql = repo.findAll();

        // 2. Los transformamos al formato de documento de MongoDB
        List<EmpleadoMongo> documentosMongo = empleadosSql.stream()
                .map(sql -> {
                    EmpleadoMongo mongo = new EmpleadoMongo();
                    mongo.setId(sql.getIdEmpleado());
                    mongo.setNombre(sql.getNombre());
                    mongo.setEmail(sql.getEmail());
                    // Aquí puedes añadir más campos si los tienes
                    mongo.setId(sql.getIdEmpleado());
                    mongo.setNombre(sql.getNombre());
                    mongo.setPuesto(sql.getPuesto());
                    mongo.setTipoJornada(sql.getTipoJornada());
                    mongo.setEmail(sql.getEmail());
                    mongo.setTelefono(sql.getTelefono());
                    mongo.setFechaContratacion(sql.getFechaContratacion());
                    mongo.setSalarioHora(sql.getSalarioHora());
                    mongo.setActivo(sql.getActivo());
                    mongo.setHorasContrato(sql.getHorasContrato());
                    return mongo;
                }).toList();

        // 3. Guardamos todos de una sola vez (Batch Save)
        if (!documentosMongo.isEmpty()) {
            mongoRepo.saveAll(documentosMongo);
        }

        return documentosMongo.size();
    }


    public List<Empleado> listar() {
        return repo.findAll();
    }

    public Empleado obtener(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new NotFoundException("Empleado no encontrado con id " + id));
    }

    public Empleado actualizar(Integer id, Empleado obj) {
        obtener(id);
        obj.setIdEmpleado(id);
        return repo.save(obj);
    }

    public void borrar(Integer id) {
        if (!repo.existsById(id)) {
            throw new NotFoundException("Empleado no encontrado con id " + id);
        }
        repo.deleteById(id);
    }
}
