/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.inventario;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Julian D Osorio G
 */
@Entity
@Table(name = "productos_registro")
@NamedQueries({
    @NamedQuery(name = "ProductosRegistro.findAll", query = "SELECT p FROM ProductosRegistro p")})
public class ProductosRegistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosRegistroPK productosRegistroPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_costo")
    private Double precioCosto;
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "precio_bruto")
    private Double precioBruto;
    @Column(name = "precio_total")
    private Double precioTotal;
    @Column(name = "cod_impuesto")
    private String codImpuesto;
    @JoinColumns({
        @JoinColumn(name = "codigo_establecimiento", referencedColumnName = "codigo_establecimiento", insertable = false, updatable = false),
        @JoinColumn(name = "cod_producto", referencedColumnName = "cod_producto", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Productos productos;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productosRegistro")
    private Collection<ProductosKardex> productosKardexCollection;

    public ProductosRegistro() {
    }

    public ProductosRegistro(ProductosRegistroPK productosRegistroPK) {
        this.productosRegistroPK = productosRegistroPK;
    }

    public ProductosRegistro(short codigoEstablecimiento, int codProducto, int codRegistro) {
        this.productosRegistroPK = new ProductosRegistroPK(codigoEstablecimiento, codProducto, codRegistro);
    }

    public ProductosRegistroPK getProductosRegistroPK() {
        return productosRegistroPK;
    }

    public void setProductosRegistroPK(ProductosRegistroPK productosRegistroPK) {
        this.productosRegistroPK = productosRegistroPK;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioBruto() {
        return precioBruto;
    }

    public void setPrecioBruto(Double precioBruto) {
        this.precioBruto = precioBruto;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getCodImpuesto() {
        return codImpuesto;
    }

    public void setCodImpuesto(String codImpuesto) {
        this.codImpuesto = codImpuesto;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    public Collection<ProductosKardex> getProductosKardexCollection() {
        return productosKardexCollection;
    }

    public void setProductosKardexCollection(Collection<ProductosKardex> productosKardexCollection) {
        this.productosKardexCollection = productosKardexCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosRegistroPK != null ? productosRegistroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosRegistro)) {
            return false;
        }
        ProductosRegistro other = (ProductosRegistro) object;
        if ((this.productosRegistroPK == null && other.productosRegistroPK != null) || (this.productosRegistroPK != null && !this.productosRegistroPK.equals(other.productosRegistroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.ProductosRegistro[ productosRegistroPK=" + productosRegistroPK + " ]";
    }
    
}
