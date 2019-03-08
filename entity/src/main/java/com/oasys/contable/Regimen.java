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
@Table(name = "regimen")
@NamedQueries({
    @NamedQuery(name = "Regimen.findAll", query = "SELECT r FROM Regimen r")})
public class Regimen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_regimen")
    private String codRegimen;
    @Column(name = "nombre")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "regimen")
    private Collection<Representantes> representantesCollection;
    @OneToMany(mappedBy = "codRegimen")
    private Collection<Terceros> tercerosCollection;

    public Regimen() {
    }

    public Regimen(String codRegimen) {
        this.codRegimen = codRegimen;
    }

    public Regimen(String codRegimen, String nombre) {
        this.codRegimen = codRegimen;
        this.nombre = nombre;
    }
    
    

    public String getCodRegimen() {
        return codRegimen;
    }

    public void setCodRegimen(String codRegimen) {
        this.codRegimen = codRegimen;
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

    public Collection<Terceros> getTercerosCollection() {
        return tercerosCollection;
    }

    public void setTercerosCollection(Collection<Terceros> tercerosCollection) {
        this.tercerosCollection = tercerosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codRegimen != null ? codRegimen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Regimen)) {
            return false;
        }
        Regimen other = (Regimen) object;
        if ((this.codRegimen == null && other.codRegimen != null) || (this.codRegimen != null && !this.codRegimen.equals(other.codRegimen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.Regimen[ codRegimen=" + codRegimen + " ]";
    }
    
}
