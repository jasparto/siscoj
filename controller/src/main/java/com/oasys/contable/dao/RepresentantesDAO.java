/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.oasys.contable.dao;

import com.oasys.contable.Representantes;
import conexion.Consulta;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author Julian D Osorio G
 */
public class RepresentantesDAO {

    private Connection connection;

    public RepresentantesDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertarRepresentantes(Representantes r) throws SQLException {
        Consulta consulta = null;
        try {
            consulta = new Consulta(this.connection);
            StringBuilder sql = new StringBuilder(
                    " INSERT INTO contable.representantes("
                    + " codigo_establecimiento, identificacion, nombre, cod_regimen, "
                    + " tipo_identificacion, tipo_persona, activo, fecha_registro)"
                    + " VALUES (" + r.getRepresentantesPK().getCodigoEstablecimiento() + ", '" + r.getRepresentantesPK().getIdentificacion() + "', '" + r.getNombre() + "', '" + r.getRepresentantesPK().getCodRegimen() + "',"
                    + " '" + r.getRepresentantesPK().getTipoIdentificacion() + "', '" + r.getRepresentantesPK().getTipoPersona() + "', " + r.getActivo() + ", NOW())"
                    + " ON CONFLICT (codigo_establecimiento, identificacion, cod_regimen, tipo_identificacion, tipo_persona)"
                    + " DO UPDATE SET nombre=EXCLUDED.nombre, cod_regimen=EXCLUDED.cod_regimen, tipo_identificacion=EXCLUDED.tipo_identificacion,"
                    + " tipo_persona=EXCLUDED.tipo_persona, activo=EXCLUDED.activo;"
            );
            consulta.actualizar(sql);
        } finally {
            if (consulta != null) {
                consulta.desconectar();
            }
        }
    }

}
