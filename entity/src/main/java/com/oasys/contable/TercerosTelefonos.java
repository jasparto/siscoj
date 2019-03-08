/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable;

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
@Table(name = "terceros_telefonos")
@NamedQueries({
    @NamedQuery(name = "TercerosTelefonos.findAll", query = "SELECT t FROM TercerosTelefonos t")})
public class TercerosTelefonos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TercerosTelefonosPK tercerosTelefonosPK;
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "cod_descripcion", referencedColumnName = "cod_descripcion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Descripciones descripciones;
    @JoinColumns({
        @JoinColumn(name = "tipo_identificacion", referencedColumnName = "tipo_identificacion", insertable = false, updatable = false),
        @JoinColumn(name = "identificacion", referencedColumnName = "identificacion", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_establecimiento", referencedColumnName = "codigo_establecimiento", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Terceros terceros;

    public TercerosTelefonos() {
    }

    public TercerosTelefonos(TercerosTelefonosPK tercerosTelefonosPK) {
        this.tercerosTelefonosPK = tercerosTelefonosPK;
    }

    public TercerosTelefonos(short codigoEstablecimiento, String tipoIdentificacion, String identificacion, String codDescripcion) {
        this.tercerosTelefonosPK = new TercerosTelefonosPK(codigoEstablecimiento, tipoIdentificacion, identificacion, codDescripcion);
    }

    public TercerosTelefonosPK getTercerosTelefonosPK() {
        return tercerosTelefonosPK;
    }

    public void setTercerosTelefonosPK(TercerosTelefonosPK tercerosTelefonosPK) {
        this.tercerosTelefonosPK = tercerosTelefonosPK;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Descripciones getDescripciones() {
        return descripciones;
    }

    public void setDescripciones(Descripciones descripciones) {
        this.descripciones = descripciones;
    }

    public Terceros getTerceros() {
        return terceros;
    }

    public void setTerceros(Terceros terceros) {
        this.terceros = terceros;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tercerosTelefonosPK != null ? tercerosTelefonosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TercerosTelefonos)) {
            return false;
        }
        TercerosTelefonos other = (TercerosTelefonos) object;
        if ((this.tercerosTelefonosPK == null && other.tercerosTelefonosPK != null) || (this.tercerosTelefonosPK != null && !this.tercerosTelefonosPK.equals(other.tercerosTelefonosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.TercerosTelefonos[ tercerosTelefonosPK=" + tercerosTelefonosPK + " ]";
    }
    
}
