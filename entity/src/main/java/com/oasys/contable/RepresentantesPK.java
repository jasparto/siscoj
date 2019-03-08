/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Julian D Osorio G
 */
@Embeddable
public class RepresentantesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_establecimiento")
    private int codigoEstablecimiento;
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @Column(name = "cod_regimen")
    private String codRegimen;
    @Basic(optional = false)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @Column(name = "tipo_persona")
    private String tipoPersona;

    public RepresentantesPK() {
    }

    public RepresentantesPK(int codigoEstablecimiento, String identificacion, String codRegimen, String tipoIdentificacion, String tipoPersona) {
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.identificacion = identificacion;
        this.codRegimen = codRegimen;
        this.tipoIdentificacion = tipoIdentificacion;
        this.tipoPersona = tipoPersona;
    }

    public int getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(int codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCodRegimen() {
        return codRegimen;
    }

    public void setCodRegimen(String codRegimen) {
        this.codRegimen = codRegimen;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEstablecimiento;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        hash += (codRegimen != null ? codRegimen.hashCode() : 0);
        hash += (tipoIdentificacion != null ? tipoIdentificacion.hashCode() : 0);
        hash += (tipoPersona != null ? tipoPersona.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RepresentantesPK)) {
            return false;
        }
        RepresentantesPK other = (RepresentantesPK) object;
        if (this.codigoEstablecimiento != other.codigoEstablecimiento) {
            return false;
        }
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        if ((this.codRegimen == null && other.codRegimen != null) || (this.codRegimen != null && !this.codRegimen.equals(other.codRegimen))) {
            return false;
        }
        if ((this.tipoIdentificacion == null && other.tipoIdentificacion != null) || (this.tipoIdentificacion != null && !this.tipoIdentificacion.equals(other.tipoIdentificacion))) {
            return false;
        }
        if ((this.tipoPersona == null && other.tipoPersona != null) || (this.tipoPersona != null && !this.tipoPersona.equals(other.tipoPersona))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.RepresentantesPK[ codigoEstablecimiento=" + codigoEstablecimiento + ", identificacion=" + identificacion + ", codRegimen=" + codRegimen + ", tipoIdentificacion=" + tipoIdentificacion + ", tipoPersona=" + tipoPersona + " ]";
    }
    
}
