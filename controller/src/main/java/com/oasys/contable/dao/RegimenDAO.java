/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable.dao;

import com.oasys.contable.Regimen;
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
public class RegimenDAO {

    private Connection connection;

    public RegimenDAO(Connection connection) {
        this.connection = connection;
    }

    public Collection<? extends Regimen> cargarRegimen() throws SQLException {
        ResultSet rs = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.connection);
            StringBuilder sql = new StringBuilder(
                    "SELECT cod_regimen, nombre"
                    + " FROM contable.regimen;"
            );
            rs = consulta.ejecutar(sql);
            Collection<Regimen> regimens = new ArrayList<>();

            while (rs.next()) {
                Regimen r = new Regimen(rs.getString("cod_regimen"), rs.getString("nombre"));
                regimens.add(r);
            }
            return regimens;

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
