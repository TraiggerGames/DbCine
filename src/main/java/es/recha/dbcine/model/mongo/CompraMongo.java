package es.recha.dbcine.model.mongo;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "compras")
public class CompraMongo {

    @Id
    private String id;

    private LocalDateTime fechaCompra;
    private String metodoPago;
    private BigDecimal totalPagado;
    private String estado;
    private String referenciaPago;
    private String emailCliente;

    @Builder.Default
    @JsonIgnore // Evita que al serializar la compra se traigan todos los objetos entrada completos
    @DocumentReference(lazy = true)
    private Set<EntradaMongo> entradas = new HashSet<>();
}