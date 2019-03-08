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
public class ProductosRegistroPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_establecimiento")
    private short codigoEstablecimiento;
    @Basic(optional = false)
    @Column(name = "cod_producto")
    private int codProducto;
    @Basic(optional = false)
    @Column(name = "cod_registro")
    private int codRegistro;

    public ProductosRegistroPK() {
    }

    public ProductosRegistroPK(short codigoEstablecimiento, int codProducto, int codRegistro) {
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.codProducto = codProducto;
        this.codRegistro = codRegistro;
    }

    public short getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(short codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
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
        hash += (int) codProducto;
        hash += (int) codRegistro;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosRegistroPK)) {
            return false;
        }
        ProductosRegistroPK other = (ProductosRegistroPK) object;
        if (this.codigoEstablecimiento != other.codigoEstablecimiento) {
            return false;
        }
        if (this.codProducto != other.codProducto) {
            return false;
        }
        if (this.codRegistro != other.codRegistro) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.ProductosRegistroPK[ codigoEstablecimiento=" + codigoEstablecimiento + ", codProducto=" + codProducto + ", codRegistro=" + codRegistro + " ]";
    }
    
}
