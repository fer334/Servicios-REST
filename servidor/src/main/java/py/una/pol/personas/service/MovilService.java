package py.una.pol.personas.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;

import py.una.pol.personas.dao.MovilDAO;
import py.una.pol.personas.dao.UbicacionDAO;
import py.una.pol.personas.model.Movil;
import py.una.pol.personas.model.Ubicacion;
import py.una.pol.personas.model.UbicacionMovil;

@Stateless
public class MovilService {

    @Inject
    Logger log;
    @Inject
    MovilDAO daoMovil;
    @Inject
    UbicacionDAO daoUbi;

    public List<Movil> seleccionar() {
        return daoMovil.seleccionar();
    }

    public void registrar(Movil m) throws Exception {
        daoMovil.registrar(m);
    }

    public void ubicar(Ubicacion u) throws Exception {
        daoUbi.ubicar(u);
    }

    public List<UbicacionMovil> seleccionar(String lat, String lon, String dis) {
        return daoUbi.seleccionar(lat, lon, dis);
    }

}