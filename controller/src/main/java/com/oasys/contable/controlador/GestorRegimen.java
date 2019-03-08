/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable.controlador;

import com.oasys.contable.Regimen;
import com.oasys.contable.TiposPersona;
import com.oasys.contable.dao.RegimenDAO;
import com.oasys.controller.Gestor;
import java.util.Collection;

/**
 *
 * @author Julian D Osorio G
 */
public class GestorRegimen extends Gestor {

    public GestorRegimen() throws Exception {
        super();
    }

    public Collection<? extends Regimen> cargarRegimen() throws Exception {
        try {
            this.abrirConexion();

            RegimenDAO regimenDAO = new RegimenDAO(conexion);
            return regimenDAO.cargarRegimen();
        } finally {
            this.cerrarConexion();
        }
    }

}
