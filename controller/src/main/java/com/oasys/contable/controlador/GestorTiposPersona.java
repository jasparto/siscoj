/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable.controlador;

import com.oasys.contable.TiposPersona;
import com.oasys.contable.dao.TiposPersonaDAO;
import com.oasys.controller.Gestor;
import java.util.Collection;

/**
 *
 * @author Julian D Osorio G
 */
public class GestorTiposPersona extends Gestor {

    public GestorTiposPersona() throws Exception {
        super();
    }

    public Collection<? extends TiposPersona> cargarTiposPersona() throws Exception {
        try {
            this.abrirConexion();
            return new TiposPersonaDAO(conexion).cargarTiposPersona();
        } finally {
            this.cerrarConexion();
        }
    }

}
