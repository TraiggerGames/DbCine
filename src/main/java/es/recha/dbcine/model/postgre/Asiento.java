package es.recha.dbcine.model.postgre;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "asientos",
       uniqueConstraints = @UniqueConstraint(columnNames = {"id_sala", "fila", "numero"}))
@JsonIgnoreProperties({"sala"})
public class Asiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_asiento")
    private Integer idAsiento;

    @ManyToOne
    @JoinColumn(name = "id_sala", nullable = false)
    private Sala sala;

    @Column(name = "fila", length = 5, nullable = false)
    private String fila;

    @Column(name = "numero", nullable = false)
    private Integer numero;

    @Column(name = "tipo", length = 20)
    private String tipo;

    @Column(name = "activo")
    private Boolean activo;

    public Asiento() {}

    public Integer getIdAsiento() { return idAsiento; }
    public void setIdAsiento(Integer idAsiento) { this.idAsiento = idAsiento; }

    public Sala getSala() { return sala; }
    public void setSala(Sala sala) { this.sala = sala; }

    public String getFila() { return fila; }
    public void setFila(String fila) { this.fila = fila; }

    public Integer getNumero() { return numero; }
    public void setNumero(Integer numero) { this.numero = numero; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public Boolean getActivo() { return activo; }
    public void setActivo(Boolean activo) { this.activo = activo; }
}
