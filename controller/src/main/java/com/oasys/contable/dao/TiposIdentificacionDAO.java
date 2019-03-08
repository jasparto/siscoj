/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable.dao;

import com.oasys.contable.TiposIdentificacion;
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
public class TiposIdentificacionDAO {

    private Connection connection;

    public TiposIdentificacionDAO(Connection connection) {
        this.connection = connection;
    }

    public Collection<? extends TiposIdentificacion> cargarTiposIdentificacion() throws SQLException {
        ResultSet rs = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.connection);
            StringBuilder sql = new StringBuilder(
                    "SELECT tipo_identificacion, nombre, inicial"
                    + " FROM contable.tipos_identificacion;"
            );
            rs = consulta.ejecutar(sql);
            Collection<TiposIdentificacion> tiposIdentificacionList = new ArrayList<>();
            while (rs.next()) {
                TiposIdentificacion ti = new TiposIdentificacion(rs.getString("tipo_identificacion"), rs.getString("nombre"), rs.getString("inicial"));
                tiposIdentificacionList.add(ti);
            }
            rs = consulta.ejecutar(sql);
            return tiposIdentificacionList;
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
