package py.una.pol.personas.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.una.pol.personas.dao.MovilDAO;
import py.una.pol.personas.model.Movil;

@Stateless
public class MovilService {

    @Inject Logger log;
    @Inject MovilDAO dao;


    public List<Movil> seleccionar() {
        return dao.seleccionar();
    }
}