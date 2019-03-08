/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Julian D Osorio G
 */
@Entity
@Table(name = "descripciones")
@NamedQueries({
    @NamedQuery(name = "Descripciones.findAll", query = "SELECT d FROM Descripciones d")})
public class Descripciones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_descripcion")
    private String codDescripcion;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descripciones")
    private Collection<TercerosTelefonos> tercerosTelefonosCollection;

    public Descripciones() {
    }

    public Descripciones(String codDescripcion) {
        this.codDescripcion = codDescripcion;
    }

    public String getCodDescripcion() {
        return codDescripcion;
    }

    public void setCodDescripcion(String codDescripcion) {
        this.codDescripcion = codDescripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<TercerosTelefonos> getTercerosTelefonosCollection() {
        return tercerosTelefonosCollection;
    }

    public void setTercerosTelefonosCollection(Collection<TercerosTelefonos> tercerosTelefonosCollection) {
        this.tercerosTelefonosCollection = tercerosTelefonosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codDescripcion != null ? codDescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descripciones)) {
            return false;
        }
        Descripciones other = (Descripciones) object;
        if ((this.codDescripcion == null && other.codDescripcion != null) || (this.codDescripcion != null && !this.codDescripcion.equals(other.codDescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.Descripciones[ codDescripcion=" + codDescripcion + " ]";
    }
    
}
