/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.rrhh.bonarea.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.sql.DataSource;

/**
 *
 * @author xavier.verges
 */
@Dependent
public class AutorDao {

    DataSource dataSource;

    @Inject
    public AutorDao(@DefaultDataSource DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int addAutor(String nombre) throws DaoException {
        Connection conn = null;
        PreparedStatement pst = null;
        int clave;

        try {
            String insert = "insert into autor_xverges(nombre) values (?)";
            conn = dataSource.getConnection();
            pst = conn.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, nombre);
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                clave = rs.getInt(1);
            } else {
                clave = -1;
            }
            pst.close();

        } catch (SQLException sqle) {
            throw new DaoException("Error insertando autor", sqle);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                    pst = null;
                }
                if (conn != null) {
                    conn.close();
                    conn = null;
                }
            } catch (SQLException sqlError) {
                throw new DaoException("Error cerrando las connexiones", sqlError);
            }
        }
        return clave;
    }

}
