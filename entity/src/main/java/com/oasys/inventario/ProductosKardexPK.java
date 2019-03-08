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
public class ProductosKardexPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_establecimiento")
    private short codigoEstablecimiento;
    @Basic(optional = false)
    @Column(name = "cod_kardex")
    private int codKardex;

    public ProductosKardexPK() {
    }

    public ProductosKardexPK(short codigoEstablecimiento, int codKardex) {
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.codKardex = codKardex;
    }

    public short getCodigoEstablecimiento() {
        return codigoEstablecimiento;
    }

    public void setCodigoEstablecimiento(short codigoEstablecimiento) {
        this.codigoEstablecimiento = codigoEstablecimiento;
    }

    public int getCodKardex() {
        return codKardex;
    }

    public void setCodKardex(int codKardex) {
        this.codKardex = codKardex;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEstablecimiento;
        hash += (int) codKardex;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosKardexPK)) {
            return false;
        }
        ProductosKardexPK other = (ProductosKardexPK) object;
        if (this.codigoEstablecimiento != other.codigoEstablecimiento) {
            return false;
        }
        if (this.codKardex != other.codKardex) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.ProductosKardexPK[ codigoEstablecimiento=" + codigoEstablecimiento + ", codKardex=" + codKardex + " ]";
    }
    
}
