/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.rrhh.bonarea.demo.dao;

import java.sql.SQLException;
import javax.ejb.ApplicationException;

/**
 *
 * @author xavier.verges
 */
@ApplicationException(rollback = true)
public class DaoException extends Exception {

    public DaoException() {
    }

    public DaoException(String string) {
        super(string);
    }

    public DaoException(String string, SQLException sqle) {
        super(string, sqle);
    }
}
