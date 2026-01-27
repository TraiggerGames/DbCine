package es.recha.dbcine.model.postgre;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "entradas",
       uniqueConstraints = @UniqueConstraint(columnNames = {"id_proyeccion", "id_asiento"}))
@JsonIgnoreProperties({"proyeccion","asiento","compra"})
public class Entrada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrada")
    private Integer idEntrada;

    @ManyToOne
    @JoinColumn(name = "id_proyeccion")
    private Proyeccion proyeccion;

    @ManyToOne
    @JoinColumn(name = "id_asiento")
    private Asiento asiento;

    @ManyToOne
    @JoinColumn(name = "id_compra")
    private Compra compra;

    @Column(name = "precio_pagado", precision = 8, scale = 2)
    private BigDecimal precioPagado;

    // Legacy opcional
    @Column(name = "fila",  columnDefinition ="bpchar(1)" )
    private String fila;

    @Column(name = "butaca")
    private Integer butaca;

    @Column(name = "fecha_compra")
    private LocalDate fechaCompra;

    @Column(name = "metodo_pago", length = 20)
    private String metodoPago;

    public Entrada() {}

    public Integer getIdEntrada() { return idEntrada; }
    public void setIdEntrada(Integer idEntrada) { this.idEntrada = idEntrada; }

    public Proyeccion getProyeccion() { return proyeccion; }
    public void setProyeccion(Proyeccion proyeccion) { this.proyeccion = proyeccion; }

    public Asiento getAsiento() { return asiento; }
    public void setAsiento(Asiento asiento) { this.asiento = asiento; }

    public Compra getCompra() { return compra; }
    public void setCompra(Compra compra) { this.compra = compra; }

    public BigDecimal getPrecioPagado() { return precioPagado; }
    public void setPrecioPagado(BigDecimal precioPagado) { this.precioPagado = precioPagado; }

    public String getFila() { return fila; }
    public void setFila(String fila) { this.fila = fila; }

    public Integer getButaca() { return butaca; }
    public void setButaca(Integer butaca) { this.butaca = butaca; }

    public LocalDate getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDate fechaCompra) { this.fechaCompra = fechaCompra; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }
}
