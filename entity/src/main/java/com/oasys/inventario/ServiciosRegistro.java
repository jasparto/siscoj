/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.inventario;

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
@Table(name = "servicios_registro")
@NamedQueries({
    @NamedQuery(name = "ServiciosRegistro.findAll", query = "SELECT s FROM ServiciosRegistro s")})
public class ServiciosRegistro implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ServiciosRegistroPK serviciosRegistroPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_costo")
    private Double precioCosto;
    @Column(name = "precio_venta")
    private Double precioVenta;
    @Column(name = "cantidad")
    private Double cantidad;
    @Column(name = "precio_bruto")
    private Double precioBruto;
    @Column(name = "precio_total")
    private Double precioTotal;
    @Column(name = "cod_impuesto")
    private String codImpuesto;
    @JoinColumns({
        @JoinColumn(name = "codigo_establecimiento", referencedColumnName = "codigo_establecimiento", insertable = false, updatable = false),
        @JoinColumn(name = "cod_servicio", referencedColumnName = "cod_servicio", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Servicios servicios;

    public ServiciosRegistro() {
    }

    public ServiciosRegistro(ServiciosRegistroPK serviciosRegistroPK) {
        this.serviciosRegistroPK = serviciosRegistroPK;
    }

    public ServiciosRegistro(short codigoEstablecimiento, int codServicio, int codRegistro) {
        this.serviciosRegistroPK = new ServiciosRegistroPK(codigoEstablecimiento, codServicio, codRegistro);
    }

    public ServiciosRegistroPK getServiciosRegistroPK() {
        return serviciosRegistroPK;
    }

    public void setServiciosRegistroPK(ServiciosRegistroPK serviciosRegistroPK) {
        this.serviciosRegistroPK = serviciosRegistroPK;
    }

    public Double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(Double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getCantidad() {
        return cantidad;
    }

    public void setCantidad(Double cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioBruto() {
        return precioBruto;
    }

    public void setPrecioBruto(Double precioBruto) {
        this.precioBruto = precioBruto;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getCodImpuesto() {
        return codImpuesto;
    }

    public void setCodImpuesto(String codImpuesto) {
        this.codImpuesto = codImpuesto;
    }

    public Servicios getServicios() {
        return servicios;
    }

    public void setServicios(Servicios servicios) {
        this.servicios = servicios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (serviciosRegistroPK != null ? serviciosRegistroPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServiciosRegistro)) {
            return false;
        }
        ServiciosRegistro other = (ServiciosRegistro) object;
        if ((this.serviciosRegistroPK == null && other.serviciosRegistroPK != null) || (this.serviciosRegistroPK != null && !this.serviciosRegistroPK.equals(other.serviciosRegistroPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.inventario.ServiciosRegistro[ serviciosRegistroPK=" + serviciosRegistroPK + " ]";
    }
    
}
