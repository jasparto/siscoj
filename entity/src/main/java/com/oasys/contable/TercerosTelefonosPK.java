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
public class TercerosTelefonosPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_establecimiento")
    private short codigoEstablecimiento;
    @Basic(optional = false)
    @Column(name = "tipo_identificacion")
    private String tipoIdentificacion;
    @Basic(optional = false)
    @Column(name = "identificacion")
    private String identificacion;
    @Basic(optional = false)
    @Column(name = "cod_descripcion")
    private String codDescripcion;

    public TercerosTelefonosPK() {
    }

    public TercerosTelefonosPK(short codigoEstablecimiento, String tipoIdentificacion, String identificacion, String codDescripcion) {
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.tipoIdentificacion = tipoIdentificacion;
        this.identificacion = identificacion;
        this.codDescripcion = codDescripcion;
    }

    public short getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(short codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCodDescripcion() {
        return codDescripcion;
    }

    public void setCodDescripcion(String codDescripcion) {
        this.codDescripcion = codDescripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEstablecimiento;
        hash += (tipoIdentificacion != null ? tipoIdentificacion.hashCode() : 0);
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        hash += (codDescripcion != null ? codDescripcion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TercerosTelefonosPK)) {
            return false;
        }
        TercerosTelefonosPK other = (TercerosTelefonosPK) object;
        if (this.codigoEstablecimiento != other.codigoEstablecimiento) {
            return false;
        }
        if ((this.tipoIdentificacion == null && other.tipoIdentificacion != null) || (this.tipoIdentificacion != null && !this.tipoIdentificacion.equals(other.tipoIdentificacion))) {
            return false;
        }
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        if ((this.codDescripcion == null && other.codDescripcion != null) || (this.codDescripcion != null && !this.codDescripcion.equals(other.codDescripcion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.TercerosTelefonosPK[ codigoEstablecimiento=" + codigoEstablecimiento + ", tipoIdentificacion=" + tipoIdentificacion + ", identificacion=" + identificacion + ", codDescripcion=" + codDescripcion + " ]";
    }
    
}
