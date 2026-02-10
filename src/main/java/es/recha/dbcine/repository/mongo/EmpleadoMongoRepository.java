package es.recha.dbcine.repository.mongo;

import es.recha.dbcine.model.mongo.EmpleadoMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoMongoRepository extends MongoRepository<EmpleadoMongo, Integer> {

}