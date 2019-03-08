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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Julian D Osorio G
 */
@Entity
@Table(name = "categorias")
@NamedQueries({
    @NamedQuery(name = "Categorias.findAll", query = "SELECT c FROM Categorias c")})
public class Categorias implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CategoriasPK categoriasPK;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorias")
    private Collection<Servicios> serviciosCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorias")
    private Collection<Productos> productosCollection;

    public Categorias() {
    }

    public Categorias(CategoriasPK categoriasPK) {
        this.categoriasPK = categoriasPK;
    }

    public Categorias(short codigoEstablecimiento, int codCategoria) {
        this.categoriasPK = new CategoriasPK(codigoEstablecimiento, codCategoria);
    }

    public CategoriasPK getCategoriasPK() {
        return categoriasPK;
    }

    public void setCategoriasPK(CategoriasPK categoriasPK) {
        this.categoriasPK = categoriasPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Servicios> getServiciosCollection() {
        return serviciosCollection;
    }

    public void setServiciosCollection(Collection<Servicios> serviciosCollection) {
        this.serviciosCollection = serviciosCollection;
    }

    public Collection<Productos> getProductosCollection() {
        return productosCollection;
    }

    public void setProductosCollection(Collection<Productos> productosCollection) {
        this.productosCollection = productosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriasPK != null ? categoriasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorias)) {
            return false;
        }
        Categorias other = (Categorias) object;
        if ((this.categoriasPK == null && other.categoriasPK != null) || (this.categoriasPK != null && !this.categoriasPK.equals(other.categoriasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.Categorias[ categoriasPK=" + categoriasPK + " ]";
    }
    
}
