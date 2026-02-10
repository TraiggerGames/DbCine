package es.recha.dbcine.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "es.recha.dbcine.repository.mongo")
public class MongoConfig {

    @Value("${spring.data.mongodb.uri}")
    private String mongoUri;

    @Value("${spring.data.mongodb.database}")
    private String databaseName;

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(mongoUri);
    }

    @Bean
    public MongoDatabaseFactory mongoDbFactory() {
        return new SimpleMongoClientDatabaseFactory(mongoClient(), databaseName);
    }

    /**
     * IMPORTANTE:
     * - NO devuelvas lista vacía.
     * - Deja que Spring registre sus converters por defecto (incluyendo Java Time).
     * Si necesitas converters custom, añádelos aquí, pero sin vaciar los default.
     */
    @Bean
    public MongoCustomConversions mongoCustomConversions() {
        return MongoCustomConversions.create(config -> {
            // aquí puedes añadir converters custom con config.registerConverter(...)
            // pero NO es necesario para LocalDateTime en condiciones normales
        });
    }

    @Primary
    @Bean
    public MongoTemplate mongoTemplate(
            MongoDatabaseFactory factory,
            MongoMappingContext mappingContext,
            MongoCustomConversions conversions
    ) {
        MappingMongoConverter converter = new MappingMongoConverter(factory, mappingContext);
        converter.setCustomConversions(conversions);
        converter.setTypeMapper(new DefaultMongoTypeMapper(null)); // quita _class si quieres
        converter.afterPropertiesSet();
        return new MongoTemplate(factory, converter);
    }
}