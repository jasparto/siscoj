/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.inventario;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Julian D Osorio G
 */
@Entity
@Table(name = "productos_kardex")
@NamedQueries({
    @NamedQuery(name = "ProductosKardex.findAll", query = "SELECT p FROM ProductosKardex p")})
public class ProductosKardex implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosKardexPK productosKardexPK;
    @Column(name = "tipo_movimiento")
    private String tipoMovimiento;
    @Column(name = "lote")
    private String lote;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo_inicial")
    private Double saldoInicial;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "saldo_final")
    private Double saldoFinal;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "usuario")
    private String usuario;
    @JoinColumns({
        @JoinColumn(name = "codigo_establecimiento", referencedColumnName = "codigo_establecimiento", insertable = false, updatable = false),
        @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto"),
        @JoinColumn(name = "cod_registro", referencedColumnName = "cod_registro")})
    @ManyToOne(optional = false)
    private ProductosRegistro productosRegistro;

    public ProductosKardex() {
    }

    public ProductosKardex(ProductosKardexPK productosKardexPK) {
        this.productosKardexPK = productosKardexPK;
    }

    public ProductosKardex(short codigoEstablecimiento, int codKardex) {
        this.productosKardexPK = new ProductosKardexPK(codigoEstablecimiento, codKardex);
    }

    public ProductosKardexPK getProductosKardexPK() {
        return productosKardexPK;
    }

    public void setProductosKardexPK(ProductosKardexPK productosKardexPK) {
        this.productosKardexPK = productosKardexPK;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public Double getSaldoInicial() {
        return saldoInicial;
    }

    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getSaldoFinal() {
        return saldoFinal;
    }

    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public ProductosRegistro getProductosRegistro() {
        return productosRegistro;
    }

    public void setProductosRegistro(ProductosRegistro productosRegistro) {
        this.productosRegistro = productosRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosKardexPK != null ? productosKardexPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosKardex)) {
            return false;
        }
        ProductosKardex other = (ProductosKardex) object;
        if ((this.productosKardexPK == null && other.productosKardexPK != null) || (this.productosKardexPK != null && !this.productosKardexPK.equals(other.productosKardexPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.ProductosKardex[ productosKardexPK=" + productosKardexPK + " ]";
    }
    
}
