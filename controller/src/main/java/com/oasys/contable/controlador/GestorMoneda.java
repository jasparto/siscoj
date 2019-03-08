/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable.controlador;

import com.oasys.contable.Moneda;
import com.oasys.contable.dao.MonedaDAO;
import com.oasys.controller.Gestor;
import java.util.Collection;

/**
 *
 * @author Julian D Osorio G
 */
public class GestorMoneda extends Gestor {

    public GestorMoneda() throws Exception {
        super();
    }

    public Collection<? extends Moneda> cargarMoneda() throws Exception {
        try {
            this.abrirConexion();
            return new MonedaDAO(conexion).cargarMoneda();
        } finally {
            this.cerrarConexion();
        }
    }
}

