/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.inventario;

import com.oasys.general.Item;
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
@Table(name = "productos")
@NamedQueries({
    @NamedQuery(name = "Productos.findAll", query = "SELECT p FROM Productos p")})
public class Productos extends Item implements Serializable  {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductosPK productosPK;
    @Column(name = "cod_impuesto")
    private String codImpuesto;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "referencia")
    private String referencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_costo")
    private Double precioCosto;
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "controla_inventario")
    private Boolean controlaInventario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<ProductosRegistro> productosRegistroCollection;
    @JoinColumns({
        @JoinColumn(name = "codigo_establecimiento", referencedColumnName = "codigo_establecimiento", insertable = false, updatable = false),
        @JoinColumn(name = "cod_categoria", referencedColumnName = "cod_categoria")})
    @ManyToOne(optional = false)
    private Categorias categorias;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productos")
    private Collection<ProductosSaldo> productosSaldoCollection;

    public Productos() {
    }

    public Productos(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    public Productos(short codigoEstablecimiento, int codProducto) {
        this.productosPK = new ProductosPK(codigoEstablecimiento, codProducto);
    }

    public ProductosPK getProductosPK() {
        return productosPK;
    }

    public void setProductosPK(ProductosPK productosPK) {
        this.productosPK = productosPK;
    }

    public String getCodImpuesto() {
        return codImpuesto;
    }

    public void setCodImpuesto(String codImpuesto) {
        this.codImpuesto = codImpuesto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getControlaInventario() {
        return controlaInventario;
    }

    public void setControlaInventario(Boolean controlaInventario) {
        this.controlaInventario = controlaInventario;
    }

    public Collection<ProductosRegistro> getProductosRegistroCollection() {
        return productosRegistroCollection;
    }

    public void setProductosRegistroCollection(Collection<ProductosRegistro> productosRegistroCollection) {
        this.productosRegistroCollection = productosRegistroCollection;
    }

    public Categorias getCategorias() {
        return categorias;
    }

    public void setCategorias(Categorias categorias) {
        this.categorias = categorias;
    }

    public Collection<ProductosSaldo> getProductosSaldoCollection() {
        return productosSaldoCollection;
    }

    public void setProductosSaldoCollection(Collection<ProductosSaldo> productosSaldoCollection) {
        this.productosSaldoCollection = productosSaldoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productosPK != null ? productosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Productos)) {
            return false;
        }
        Productos other = (Productos) object;
        if ((this.productosPK == null && other.productosPK != null) || (this.productosPK != null && !this.productosPK.equals(other.productosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.Productos[ productosPK=" + productosPK + " ]";
    }
    
}
