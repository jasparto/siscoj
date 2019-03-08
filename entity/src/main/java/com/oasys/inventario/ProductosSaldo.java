/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.inventario;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Julian D Osorio G
 */
@Entity
@Table(name = "productos_saldo")
@NamedQueries({
    @NamedQuery(name = "ProductosSaldo.findAll", query = "SELECT p FROM ProductosSaldo p")})
public class ProductosSaldo implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosSaldoPK productosSaldoPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "saldo")
    private Double saldo;
    @JoinColumns({
        @JoinColumn(name = "codigo_establecimiento", referencedColumnName = "codigo_establecimiento", insertable = false, updatable = false),
        @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Productos productos;

    public ProductosSaldo() {
    }

    public ProductosSaldo(ProductosSaldoPK productosSaldoPK) {
        this.productosSaldoPK = productosSaldoPK;
    }

    public ProductosSaldo(short codigoEstablecimiento, int codProducto, String lote) {
        this.productosSaldoPK = new ProductosSaldoPK(codigoEstablecimiento, codProducto, lote);
    }

    public ProductosSaldoPK getProductosSaldoPK() {
        return productosSaldoPK;
    }

    public void setProductosSaldoPK(ProductosSaldoPK productosSaldoPK) {
        this.productosSaldoPK = productosSaldoPK;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosSaldoPK != null ? productosSaldoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosSaldo)) {
            return false;
        }
        ProductosSaldo other = (ProductosSaldo) object;
        if ((this.productosSaldoPK == null && other.productosSaldoPK != null) || (this.productosSaldoPK != null && !this.productosSaldoPK.equals(other.productosSaldoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.ProductosSaldo[ productosSaldoPK=" + productosSaldoPK + " ]";
    }
    
}
