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
@Table(name = "tipos_identificacion")
@NamedQueries({
    @NamedQuery(name = "TiposIdentificacion.findAll", query = "SELECT t FROM TiposIdentificacion t")})
public class TiposIdentificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "inicial")
    private String inicial;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposIdentificacion")
    private Collection<Representantes> representantesCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposIdentificacion")
    private Collection<Terceros> tercerosCollection;

    public TiposIdentificacion() {
    }

    public TiposIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public TiposIdentificacion(String tipoIdentificacion, String nombre, String inicial) {
        this.tipoIdentificacion = tipoIdentificacion;
        this.nombre = nombre;
        this.inicial = inicial;
    }
    
    

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getInicial() {
        return inicial;
    }

    public void setInicial(String inicial) {
        this.inicial = inicial;
    }

    public Collection<Representantes> getRepresentantesCollection() {
        return representantesCollection;
    }

    public void setRepresentantesCollection(Collection<Representantes> representantesCollection) {
        this.representantesCollection = representantesCollection;
    }

    public Collection<Terceros> getTercerosCollection() {
        return tercerosCollection;
    }

    public void setTercerosCollection(Collection<Terceros> tercerosCollection) {
        this.tercerosCollection = tercerosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoIdentificacion != null ? tipoIdentificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposIdentificacion)) {
            return false;
        }
        TiposIdentificacion other = (TiposIdentificacion) object;
        if ((this.tipoIdentificacion == null && other.tipoIdentificacion != null) || (this.tipoIdentificacion != null && !this.tipoIdentificacion.equals(other.tipoIdentificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.TiposIdentificacion[ tipoIdentificacion=" + tipoIdentificacion + " ]";
    }
    
}
