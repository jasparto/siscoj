/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.publico.controlador;

import com.oasys.controller.Gestor;
import com.oasys.publico.Lista;
import com.oasys.publico.dao.ListaDAO;



/**
 *
 * @author juliano
 */
public class GestorLista extends Gestor {

    public GestorLista() throws Exception {
        super();
    }

    public Lista cargarLista(String nombre) throws Exception {
        try {
            this.abrirConexion();
            ListaDAO listaDAO = new ListaDAO(conexion);
            Lista l = listaDAO.cargarLista(nombre);
            if (l != null && l.getCodLista() != null) {
                l.setListaDetalleList(listaDAO.cargarListaDetalle(l.getCodLista()));
            }
            return l;
        } finally {
            this.cerrarConexion();
        }
    }

}
