package py.una.pol.personas.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import py.una.pol.personas.model.Movil;
import py.una.pol.personas.service.MovilService;

@Path("/movil")
@RequestScoped
public class MovilRESTService {
    @Inject Logger log;
    @Inject MovilService service;


    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<Movil> listar() {
        return service.seleccionar();
    }
}