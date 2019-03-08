/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.inventario;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Julian D Osorio G
 */
@Embeddable
public class ServiciosRegistroPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_establecimiento")
    private short codigoEstablecimiento;
    @Basic(optional = false)
    @Column(name = "cod_servicio")
    private int codServicio;
    @Basic(optional = false)
    @Column(name = "cod_registro")
    private int codRegistro;

    public ServiciosRegistroPK() {
    }

    public ServiciosRegistroPK(short codigoEstablecimiento, int codServicio, int codRegistro) {
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.codServicio = codServicio;
        this.codRegistro = codRegistro;
    }

    public short getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(short codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public int getCodServicio() {
        return codServicio;
    }

    public void setCodServicio(int codServicio) {
        this.codServicio = codServicio;
    }

    public int getCodRegistro() {
        return codRegistro;
    }

    public void setCodRegistro(int codRegistro) {
        this.codRegistro = codRegistro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEstablecimiento;
        hash += (int) codServicio;
        hash += (int) codRegistro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiciosRegistroPK)) {
            return false;
        }
        ServiciosRegistroPK other = (ServiciosRegistroPK) object;
        if (this.codigoEstablecimiento != other.codigoEstablecimiento) {
            return false;
        }
        if (this.codServicio != other.codServicio) {
            return false;
        }
        if (this.codRegistro != other.codRegistro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.ServiciosRegistroPK[ codigoEstablecimiento=" + codigoEstablecimiento + ", codServicio=" + codServicio + ", codRegistro=" + codRegistro + " ]";
    }
    
}
