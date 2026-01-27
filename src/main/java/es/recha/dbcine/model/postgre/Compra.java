package es.recha.dbcine.model.postgre;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "compras")
@JsonIgnoreProperties({"entradas"})
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "fecha_compra")
    private LocalDateTime fechaCompra;

    @Column(name = "metodo_pago", length = 20, nullable = false)
    private String metodoPago;

    @Column(name = "total_pagado", precision = 8, scale = 2, nullable = false)
    private BigDecimal totalPagado;

    @Column(name = "estado", length = 20)
    private String estado;

    @Column(name = "referencia_pago", length = 80)
    private String referenciaPago;

    @Column(name = "email_cliente", length = 100)
    private String emailCliente;

    @OneToMany(mappedBy = "compra")
    private Set<Entrada> entradas = new HashSet<>();

    public Compra() {}

    public Integer getIdCompra() { return idCompra; }
    public void setIdCompra(Integer idCompra) { this.idCompra = idCompra; }

    public LocalDateTime getFechaCompra() { return fechaCompra; }
    public void setFechaCompra(LocalDateTime fechaCompra) { this.fechaCompra = fechaCompra; }

    public String getMetodoPago() { return metodoPago; }
    public void setMetodoPago(String metodoPago) { this.metodoPago = metodoPago; }

    public BigDecimal getTotalPagado() { return totalPagado; }
    public void setTotalPagado(BigDecimal totalPagado) { this.totalPagado = totalPagado; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getReferenciaPago() { return referenciaPago; }
    public void setReferenciaPago(String referenciaPago) { this.referenciaPago = referenciaPago; }

    public String getEmailCliente() { return emailCliente; }
    public void setEmailCliente(String emailCliente) { this.emailCliente = emailCliente; }

    public Set<Entrada> getEntradas() { return entradas; }
    public void setEntradas(Set<Entrada> entradas) { this.entradas = entradas; }
}
