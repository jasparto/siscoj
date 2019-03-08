/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Julian D Osorio G
 */
@Entity
@Table(name = "representantes")
@NamedQueries({
    @NamedQuery(name = "Representantes.findAll", query = "SELECT r FROM Representantes r")})
public class Representantes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RepresentantesPK representantesPK;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "activo")
    private Boolean activo;
    @Column(name = "fecha_registro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaRegistro;
    @JoinColumn(name = "cod_regimen", referencedColumnName = "cod_regimen", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Regimen regimen = new Regimen();
    @JoinColumn(name = "tipo_identificacion", referencedColumnName = "tipo_identificacion", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TiposIdentificacion tiposIdentificacion = new TiposIdentificacion();
    @JoinColumn(name = "tipo_persona", referencedColumnName = "tipo_persona", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private TiposPersona tiposPersona = new TiposPersona();

    public Representantes() {
    }

    public Representantes(RepresentantesPK representantesPK) {
        this.representantesPK = representantesPK;
    }

    public Representantes(int codigoEstablecimiento, String identificacion, String codRegimen, String tipoIdentificacion, String tipoPersona, Boolean activo) {
        this.representantesPK = new RepresentantesPK(codigoEstablecimiento, identificacion, codRegimen, tipoIdentificacion, tipoPersona);
        this.activo = activo;
    }

    public RepresentantesPK getRepresentantesPK() {
        return representantesPK;
    }

    public void setRepresentantesPK(RepresentantesPK representantesPK) {
        this.representantesPK = representantesPK;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public Regimen getRegimen() {
        return regimen;
    }

    public void setRegimen(Regimen regimen) {
        this.regimen = regimen;
    }

    public TiposIdentificacion getTiposIdentificacion() {
        return tiposIdentificacion;
    }

    public void setTiposIdentificacion(TiposIdentificacion tiposIdentificacion) {
        this.tiposIdentificacion = tiposIdentificacion;
    }

    public TiposPersona getTiposPersona() {
        return tiposPersona;
    }

    public void setTiposPersona(TiposPersona tiposPersona) {
        this.tiposPersona = tiposPersona;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (representantesPK != null ? representantesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Representantes)) {
            return false;
        }
        Representantes other = (Representantes) object;
        if ((this.representantesPK == null && other.representantesPK != null) || (this.representantesPK != null && !this.representantesPK.equals(other.representantesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.oasys.contable.Representantes[ representantesPK=" + representantesPK + " ]";
    }

}
