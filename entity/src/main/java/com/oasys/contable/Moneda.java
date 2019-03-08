/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Julian D Osorio G
 */
@Entity
@Table(name = "moneda")
@NamedQueries({
    @NamedQuery(name = "Moneda.findAll", query = "SELECT m FROM Moneda m")})
public class Moneda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_moneda")
    private String codMoneda;
    @Column(name = "nombre")
    private String nombre;

    public Moneda() {
    }

    public Moneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public Moneda(String codMoneda, String nombre) {
        this.codMoneda = codMoneda;
        this.nombre = nombre;
    }
    
    

    public String getCodMoneda() {
        return codMoneda;
    }

    public void setCodMoneda(String codMoneda) {
        this.codMoneda = codMoneda;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMoneda != null ? codMoneda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Moneda)) {
            return false;
        }
        Moneda other = (Moneda) object;
        if ((this.codMoneda == null && other.codMoneda != null) || (this.codMoneda != null && !this.codMoneda.equals(other.codMoneda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.Moneda[ codMoneda=" + codMoneda + " ]";
    }
    
}
