/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable.dao;

import com.oasys.contable.TiposPersona;
import conexion.Consulta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Julian D Osorio G
 */
public class TiposPersonaDAO {

    private Connection connection;

    public TiposPersonaDAO(Connection connection) {
        this.connection = connection;
    }

    public Collection<? extends TiposPersona> cargarTiposPersona() throws SQLException {
        ResultSet rs = null;
        Consulta consulta = null;

        try {
            consulta = new Consulta(this.connection);
            StringBuilder sql = new StringBuilder(
                    "SELECT tipo_persona, nombre"
                    + " FROM contable.tipos_persona"
            );
            Collection<TiposPersona> tiposPersonas = new ArrayList<>();
            rs = consulta.ejecutar(sql);
            while (rs.next()) {
                TiposPersona tp = new TiposPersona(rs.getString("tipo_persona"), rs.getString("nombre"));
                tiposPersonas.add(tp);
            }
            return tiposPersonas;
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

}
