/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable.controlador;

import com.oasys.contable.TiposIdentificacion;
import com.oasys.contable.dao.TiposIdentificacionDAO;
import com.oasys.controller.Gestor;
import java.util.Collection;

/**
 *
 * @author Julian D Osorio G
 */
public class GestorTiposIdentificacion extends Gestor {

    public GestorTiposIdentificacion() throws Exception {
        super();
    }

    public Collection<? extends TiposIdentificacion> cargarTiposIdentificacion() throws Exception {
        try {
            this.abrirConexion();
            return new TiposIdentificacionDAO(conexion).cargarTiposIdentificacion();
        } finally {
            this.cerrarConexion();
        }
    }

}
