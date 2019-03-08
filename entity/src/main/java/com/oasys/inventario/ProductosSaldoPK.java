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
public class ProductosSaldoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_establecimiento")
    private short codigoEstablecimiento;
    @Basic(optional = false)
    @Column(name = "cod_producto")
    private int codProducto;
    @Basic(optional = false)
    @Column(name = "lote")
    private String lote;

    public ProductosSaldoPK() {
    }

    public ProductosSaldoPK(short codigoEstablecimiento, int codProducto, String lote) {
        this.codigoEstablecimiento = codigoEstablecimiento;
        this.codProducto = codProducto;
        this.lote = lote;
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

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoEstablecimiento;
        hash += (int) codProducto;
        hash += (lote != null ? lote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductosSaldoPK)) {
            return false;
        }
        ProductosSaldoPK other = (ProductosSaldoPK) object;
        if (this.codigoEstablecimiento != other.codigoEstablecimiento) {
            return false;
        }
        if (this.codProducto != other.codProducto) {
            return false;
        }
        if ((this.lote == null && other.lote != null) || (this.lote != null && !this.lote.equals(other.lote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.ProductosSaldoPK[ codigoEstablecimiento=" + codigoEstablecimiento + ", codProducto=" + codProducto + ", lote=" + lote + " ]";
    }
    
}
