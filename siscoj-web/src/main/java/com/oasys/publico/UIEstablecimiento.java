/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.publico;

import com.oasys.contable.Moneda;
import com.oasys.contable.Regimen;
import com.oasys.contable.RepresentantesPK;
import com.oasys.contable.TiposIdentificacion;
import com.oasys.contable.TiposPersona;
import com.oasys.contable.controlador.GestorMoneda;
import com.oasys.contable.controlador.GestorRegimen;
import com.oasys.contable.controlador.GestorTiposIdentificacion;
import com.oasys.contable.controlador.GestorTiposPersona;
import com.oasys.controller.GestorGeneral;
import com.oasys.entity.UtilJSF;
import com.oasys.entity.UtilLog;
import com.oasys.entity.UtilMSG;
import com.oasys.publico.controlador.GestorEstablecimiento;
import com.oasys.publico.controlador.GestorMunicipios;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.FileUploadEvent;
import sun.misc.BASE64Encoder;

/**
 *
 * @author juliano
 */
@ManagedBean(name = "uiEstablecimiento")
@SessionScoped

public class UIEstablecimiento implements Serializable {

    private GestorEstablecimiento gestorEstablecimiento;
    private GestorGeneral gestorGeneral;
    private GestorMunicipios gestorMunicipios;

    private Establecimiento establecimiento = new Establecimiento();

    private List<Establecimiento> establecimientoList = new ArrayList<>();

    private List<Municipios> municipiosList = new ArrayList<>();
    private List<TiposIdentificacion> tiposIdentificacionList = new ArrayList<>();
    private List<TiposPersona> tiposPersonaList = new ArrayList<>();
    private List<Regimen> regimenList = new ArrayList<>();
    private List<Moneda> monedaList = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.cargarEstablecimientosInstitucion();
        this.cargarMunicipios();
        this.cargarTiposIdentificacion();
        this.cargarTiposPersona();
        this.cargarRegimen();
        this.cargarMoneda();
    }

    public void subirItemEstablecimiento() {
        establecimiento = (Establecimiento) UtilJSF.getBean("varEstablecimiento");
        establecimientoList.remove(establecimiento);
    }

    public void cargarLogo(FileUploadEvent event) throws IOException {
        try {
//            System.out.println("cargando imagen " + event.getFile().getFileName());
            String base64 = new BASE64Encoder().encode(event.getFile().getContents());
            establecimiento.setLogo(base64);
        } catch (Exception ex) {
            UtilLog.generarLog(this.getClass(), ex);
        }
    }

    public void guardarEstablecimiento() {
        try {
            Establecimiento e = this.getEstablecimiento();
            GestorEstablecimiento gestorEstablecimiento = new GestorEstablecimiento();
            GestorGeneral gestorGeneral = new GestorGeneral();

            gestorEstablecimiento.validarEstablecimiento(e);
            if (e.getCodigoEstablecimiento() == null || e.getCodigoEstablecimiento() == 0) {
                e.setCodigoEstablecimiento(gestorGeneral.siguienteCodigoEntidad("codigo_establecimiento", "establecimiento"));
            }
            e.getRepresentantes().setRepresentantesPK(new RepresentantesPK(e.getCodigoEstablecimiento(), e.getNit(),
                    e.getRepresentantes().getRegimen().getCodRegimen(), e.getRepresentantes().getTiposIdentificacion().getTipoIdentificacion(),
                    e.getRepresentantes().getTiposPersona().getTipoPersona())
            );
            
            gestorEstablecimiento.almacenarEstablecimiento(e);

            UtilMSG.addSuccessMsg("Empresa almacenada correctamente.");
            UtilJSF.setBean("establecimiento", new Establecimiento(), UtilJSF.SESSION_SCOPE);
            this.limpiar();

        } catch (Exception e) {
            if (UtilLog.causaControlada(e)) {
                UtilMSG.addWarningMsg(e.getMessage());
            } else {
                UtilMSG.addSupportMsg();
                UtilLog.generarLog(this.getClass(), e);
            }
        }

    }

    public void limpiar() {
        this.cargarEstablecimientosInstitucion();
        this.cargarMunicipios();
        this.establecimiento = new Establecimiento();
    }

    private void cargarEstablecimientosInstitucion() {
        try {
            this.establecimientoList = new ArrayList<>();
            gestorEstablecimiento = new GestorEstablecimiento();
            this.establecimientoList.addAll((Collection<? extends Establecimiento>) gestorEstablecimiento.cargarListaEstablecimientos());
        } catch (Exception ex) {
            UtilLog.generarLog(this.getClass(), ex);
        }
    }

    private void cargarMunicipios() {
        try {
            gestorMunicipios = new GestorMunicipios();
            this.getMunicipiosList().addAll(gestorMunicipios.cargarMunicipios());
        } catch (Exception ex) {
            UtilLog.generarLog(this.getClass(), ex);
        }
    }

    private void cargarTiposIdentificacion() {
        try {
            GestorTiposIdentificacion gestorTiposIdentificacion = new GestorTiposIdentificacion();
            tiposIdentificacionList = (List<TiposIdentificacion>) gestorTiposIdentificacion.cargarTiposIdentificacion();
        } catch (Exception ex) {
            UtilLog.generarLog(this.getClass(), ex);
        }
    }

    private void cargarMoneda() {
        try {
            GestorMoneda gestorMoneda = new GestorMoneda();
            monedaList.addAll(gestorMoneda.cargarMoneda());
        } catch (Exception ex) {
            UtilLog.generarLog(this.getClass(), ex);
        }
    }

    private void cargarRegimen() {
        try {
            GestorRegimen gestorRegimen = new GestorRegimen();
            getRegimenList().addAll(gestorRegimen.cargarRegimen());
        } catch (Exception ex) {
            UtilLog.generarLog(this.getClass(), ex);
        }
    }

    private void cargarTiposPersona() {
        try {
            GestorTiposPersona gestorTiposPersona = new GestorTiposPersona();
            tiposPersonaList.addAll(gestorTiposPersona.cargarTiposPersona());
        } catch (Exception ex) {
            UtilLog.generarLog(this.getClass(), ex);
        }
    }

    /**
     * @return the establecimiento
     */
    public Establecimiento getEstablecimiento() {
        return establecimiento;
    }

    /**
     * @param establecimiento the establecimiento to set
     */
    public void setEstablecimiento(Establecimiento establecimiento) {
        this.establecimiento = establecimiento;
    }

    /**
     * @return the establecimientoList
     */
    public List<Establecimiento> getEstablecimientoList() {
        return establecimientoList;
    }

    /**
     * @param establecimientoList the establecimientoList to set
     */
    public void setEstablecimientoList(List<Establecimiento> establecimientoList) {
        this.establecimientoList = establecimientoList;
    }

    /**
     * @return the gestorEstablecimiento
     */
    public GestorEstablecimiento getGestorEstablecimiento() {
        return gestorEstablecimiento;
    }

    /**
     * @param gestorEstablecimiento the gestorEstablecimiento to set
     */
    public void setGestorEstablecimiento(GestorEstablecimiento gestorEstablecimiento) {
        this.gestorEstablecimiento = gestorEstablecimiento;
    }

    /**
     * @return the gestorGeneral
     */
    public GestorGeneral getGestorGeneral() {
        return gestorGeneral;
    }

    /**
     * @param gestorGeneral the gestorGeneral to set
     */
    public void setGestorGeneral(GestorGeneral gestorGeneral) {
        this.gestorGeneral = gestorGeneral;
    }

    /**
     * @return the gestorMunicipios
     */
    public GestorMunicipios getGestorMunicipios() {
        return gestorMunicipios;
    }

    /**
     * @param gestorMunicipios the gestorMunicipios to set
     */
    public void setGestorMunicipios(GestorMunicipios gestorMunicipios) {
        this.gestorMunicipios = gestorMunicipios;
    }

    /**
     * @return the municipiosList
     */
    public List<Municipios> getMunicipiosList() {
        return municipiosList;
    }

    /**
     * @param municipiosList the municipiosList to set
     */
    public void setMunicipiosList(List<Municipios> municipiosList) {
        this.municipiosList = municipiosList;
    }

    /**
     * @return the tiposIdentificacionList
     */
    public List<TiposIdentificacion> getTiposIdentificacionList() {
        return tiposIdentificacionList;
    }

    /**
     * @param tiposIdentificacionList the tiposIdentificacionList to set
     */
    public void setTiposIdentificacionList(List<TiposIdentificacion> tiposIdentificacionList) {
        this.tiposIdentificacionList = tiposIdentificacionList;
    }

    /**
     * @return the tiposPersonaList
     */
    public List<TiposPersona> getTiposPersonaList() {
        return tiposPersonaList;
    }

    /**
     * @param tiposPersonaList the tiposPersonaList to set
     */
    public void setTiposPersonaList(List<TiposPersona> tiposPersonaList) {
        this.tiposPersonaList = tiposPersonaList;
    }

    /**
     * @return the regimenList
     */
    public List<Regimen> getRegimenList() {
        return regimenList;
    }

    /**
     * @param regimenList the regimenList to set
     */
    public void setRegimenList(List<Regimen> regimenList) {
        this.regimenList = regimenList;
    }

    /**
     * @return the monedaList
     */
    public List<Moneda> getMonedaList() {
        return monedaList;
    }

    /**
     * @param monedaList the monedaList to set
     */
    public void setMonedaList(List<Moneda> monedaList) {
        this.monedaList = monedaList;
    }

}
