/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable.dao;

import com.oasys.contable.Moneda;
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
public class MonedaDAO {

    private Connection connection;

    public MonedaDAO(Connection connection) {
        this.connection = connection;
    }

    public Collection<? extends Moneda> cargarMoneda() throws SQLException {
        ResultSet rs = null;
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.connection);
            StringBuilder sql = new StringBuilder(
                    "SELECT cod_moneda, nombre"
                    + " FROM contable.moneda"
            );
            rs = consulta.ejecutar(sql);
            Collection<Moneda> monedas = new ArrayList<>();

            while (rs.next()) {
                Moneda m = new Moneda(rs.getString("cod_moneda"), rs.getString("nombre"));
                monedas.add(m);
            }
            return monedas;
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
