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
@Table(name = "tipos_persona")
@NamedQueries({
    @NamedQuery(name = "TiposPersona.findAll", query = "SELECT t FROM TiposPersona t")})
public class TiposPersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "tipo_persona")
    private String tipoPersona;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tiposPersona")
    private Collection<Representantes> representantesCollection;

    public TiposPersona() {
    }

    public TiposPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public TiposPersona(String tipoPersona, String nombre) {
        this.tipoPersona = tipoPersona;
        this.nombre = nombre;
    }
    
    

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Representantes> getRepresentantesCollection() {
        return representantesCollection;
    }

    public void setRepresentantesCollection(Collection<Representantes> representantesCollection) {
        this.representantesCollection = representantesCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tipoPersona != null ? tipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TiposPersona)) {
            return false;
        }
        TiposPersona other = (TiposPersona) object;
        if ((this.tipoPersona == null && other.tipoPersona != null) || (this.tipoPersona != null && !this.tipoPersona.equals(other.tipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.TiposPersona[ tipoPersona=" + tipoPersona + " ]";
    }
    
}
