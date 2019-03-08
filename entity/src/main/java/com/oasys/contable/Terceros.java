/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Julian D Osorio G
 */
@Entity
@Table(name = "terceros")
@NamedQueries({
    @NamedQuery(name = "Terceros.findAll", query = "SELECT t FROM Terceros t")})
public class Terceros implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TercerosPK tercerosPK;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dv")
    private String dv;
    @Column(name = "correo")
    private String correo;
    @Column(name = "cliente")
    private Boolean cliente;
    @Column(name = "proveedor")
    private Boolean proveedor;
    @Column(name = "estado_cuenta")
    private Boolean estadoCuenta;
    @Column(name = "observaciones")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terceros")
    private Collection<TecerosPersonas> tecerosPersonasCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "terceros")
    private Collection<TercerosTelefonos> tercerosTelefonosCollection;
    @JoinColumn(name = "cod_regimen", referencedColumnName = "cod_regimen")
    @ManyToOne
    private Regimen codRegimen;
    @JoinColumn(name = "tipo_identificacion", referencedColumnName = "tipo_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TiposIdentificacion tiposIdentificacion;

    public Terceros() {
    }

    public Terceros(TercerosPK tercerosPK) {
        this.tercerosPK = tercerosPK;
    }

    public Terceros(short codigoEstablecimiento, String tipoIdentificacion, String identificacion) {
        this.tercerosPK = new TercerosPK(codigoEstablecimiento, tipoIdentificacion, identificacion);
    }

    public TercerosPK getTercerosPK() {
        return tercerosPK;
    }

    public void setTercerosPK(TercerosPK tercerosPK) {
        this.tercerosPK = tercerosPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getCliente() {
        return cliente;
    }

    public void setCliente(Boolean cliente) {
        this.cliente = cliente;
    }

    public Boolean getProveedor() {
        return proveedor;
    }

    public void setProveedor(Boolean proveedor) {
        this.proveedor = proveedor;
    }

    public Boolean getEstadoCuenta() {
        return estadoCuenta;
    }

    public void setEstadoCuenta(Boolean estadoCuenta) {
        this.estadoCuenta = estadoCuenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Collection<TecerosPersonas> getTecerosPersonasCollection() {
        return tecerosPersonasCollection;
    }

    public void setTecerosPersonasCollection(Collection<TecerosPersonas> tecerosPersonasCollection) {
        this.tecerosPersonasCollection = tecerosPersonasCollection;
    }

    public Collection<TercerosTelefonos> getTercerosTelefonosCollection() {
        return tercerosTelefonosCollection;
    }

    public void setTercerosTelefonosCollection(Collection<TercerosTelefonos> tercerosTelefonosCollection) {
        this.tercerosTelefonosCollection = tercerosTelefonosCollection;
    }

    public Regimen getCodRegimen() {
        return codRegimen;
    }

    public void setCodRegimen(Regimen codRegimen) {
        this.codRegimen = codRegimen;
    }

    public TiposIdentificacion getTiposIdentificacion() {
        return tiposIdentificacion;
    }

    public void setTiposIdentificacion(TiposIdentificacion tiposIdentificacion) {
        this.tiposIdentificacion = tiposIdentificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tercerosPK != null ? tercerosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Terceros)) {
            return false;
        }
        Terceros other = (Terceros) object;
        if ((this.tercerosPK == null && other.tercerosPK != null) || (this.tercerosPK != null && !this.tercerosPK.equals(other.tercerosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.Terceros[ tercerosPK=" + tercerosPK + " ]";
    }
    
}
