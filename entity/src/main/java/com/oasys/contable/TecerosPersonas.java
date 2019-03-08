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
@Table(name = "teceros_personas")
@NamedQueries({
    @NamedQuery(name = "TecerosPersonas.findAll", query = "SELECT t FROM TecerosPersonas t")})
public class TecerosPersonas implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TecerosPersonasPK tecerosPersonasPK;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "celular")
    private String celular;
    @JoinColumns({
        @JoinColumn(name = "tipo_identificacion", referencedColumnName = "tipo_identificacion", insertable = false, updatable = false),
        @JoinColumn(name = "identificacion", referencedColumnName = "identificacion", insertable = false, updatable = false),
        @JoinColumn(name = "codigo_establecimiento", referencedColumnName = "codigo_establecimiento", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Terceros terceros;

    public TecerosPersonas() {
    }

    public TecerosPersonas(TecerosPersonasPK tecerosPersonasPK) {
        this.tecerosPersonasPK = tecerosPersonasPK;
    }

    public TecerosPersonas(short codigoEstablecimiento, String tipoIdentificacion, String identificacion, int codPersona) {
        this.tecerosPersonasPK = new TecerosPersonasPK(codigoEstablecimiento, tipoIdentificacion, identificacion, codPersona);
    }

    public TecerosPersonasPK getTecerosPersonasPK() {
        return tecerosPersonasPK;
    }

    public void setTecerosPersonasPK(TecerosPersonasPK tecerosPersonasPK) {
        this.tecerosPersonasPK = tecerosPersonasPK;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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
        hash += (tecerosPersonasPK != null ? tecerosPersonasPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TecerosPersonas)) {
            return false;
        }
        TecerosPersonas other = (TecerosPersonas) object;
        if ((this.tecerosPersonasPK == null && other.tecerosPersonasPK != null) || (this.tecerosPersonasPK != null && !this.tecerosPersonasPK.equals(other.tecerosPersonasPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.TecerosPersonas[ tecerosPersonasPK=" + tecerosPersonasPK + " ]";
    }
    
}
