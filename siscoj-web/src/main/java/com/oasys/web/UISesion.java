/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.web;

import com.oasys.entity.Dialogo;
import com.oasys.entity.UtilJSF;
import com.oasys.entity.UtilLog;
import com.oasys.publico.Establecimiento;
import com.oasys.siscoj.web.Sesion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author juliano
 */
@ManagedBean(name = "uiSesion")
@SessionScoped

public class UISesion {

    public String cerrarSesion() {
        ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
        ((HttpSession) externalContext.getSession(true)).invalidate();
        externalContext.invalidateSession();
        return ("/ingreso.xhtml?faces-redirect=true");
    }

    public void limpiarDialogo() {
        UtilJSF.setBean("dialogo", new Dialogo(), UtilJSF.SESSION_SCOPE);
    }

    public void cambiarEstablecimiento() {
        try {
            Sesion s = (Sesion) UtilJSF.getBean("sesion");
            Establecimiento e = (Establecimiento) UtilJSF.getBean("varEstablecimiento");
            s.setEstablecimiento(e);
            UtilJSF.setBean("sesion", s, UtilJSF.SESSION_SCOPE);
        } catch (Exception e) {
            UtilLog.generarLog(this.getClass(), e);
        }
    }

    /**
     * @return the guardarActivo
     */
    public boolean isGuardarActivo() {
//        HashMap<Integer, Boolean> s = ((Sesion) UtilJSF.getBean("sesion")).getPermisos();
//        return (s.get(UtilBinario.PERMISO_CREAR) || s.get(UtilBinario.PERMISO_MODIFICAR));
        return true;
    }

    /**
     * @return the nuevoActivo
     */
    public boolean isNuevoActivo() {
        return true;
//        return ((Sesion) UtilJSF.getBean("sesion")).getPermisos().get(UtilBinario.PERMISO_CREAR);
    }

    public boolean isCancelarActivo() {
        return true;
    }

    /**
     * @return the eliminarActivo
     */
    public boolean isEliminarActivo() {
        return true;
//        return ((Sesion) UtilJSF.getBean("sesion")).getPermisos().get(UtilBinario.PERMISO_ELIMINAR);
    }

    /**
     * @return the consultarActivo
     */
    public boolean isConsultarActivo() {
        return true;
//        HashMap<Integer, Boolean> s = ((Sesion) UtilJSF.getBean("sesion")).getPermisos();
//        return (s.get(UtilBinario.PERMISO_CREAR) || s.get(UtilBinario.PERMISO_MODIFICAR) || s.get(UtilBinario.PERMISO_ELIMINAR));
    }
}
