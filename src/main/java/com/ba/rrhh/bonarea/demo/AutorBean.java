/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ba.rrhh.bonarea.demo;

import com.ba.rrhh.bonarea.demo.dao.AutorDao;
import com.ba.rrhh.bonarea.demo.dao.DaoException;
import com.ba.rrhh.bonarea.demo.dao.MensajeDao;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author xavier.verges
 */
@Stateless
public class AutorBean {

    @Inject
    private AutorDao autorDao;

    @Inject
    private MensajeDao mensajeDao;

    public int addAutor(String nombre, String mensaje) throws DaoException {
        int idautor = this.autorDao.addAutor(nombre);
        this.mensajeDao.addMensaje(idautor, "abc123");
        return idautor;
    }

    public int addAutorCorrect(String nombre, String mensaje) throws DaoException {
        int idautor = this.autorDao.addAutor(nombre);
        this.mensajeDao.addMensaje(idautor, mensaje);
        return idautor;
    }
}
