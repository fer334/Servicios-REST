package py.una.pol.personas.rest;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import py.una.pol.personas.model.Movil;
import py.una.pol.personas.model.Ubicacion;
import py.una.pol.personas.model.UbicacionMovil;
import py.una.pol.personas.service.MovilService;

@Path("/")
@RequestScoped
public class MovilRESTService {
    @Inject
    Logger log;
    @Inject
    MovilService service;

    @GET
    @Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
    public List<Movil> listar() {
        log.info("Mostrando la lista de todos los moviles");
        return service.seleccionar();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response registrar(Movil m) {
        log.info("registrar");

        Response.ResponseBuilder builder = null;

        try {
            service.registrar(m);
            builder = Response.status(201).entity("Movil registrado exitosamente");

        } catch (SQLException e) {
            // Handle the unique constrain violation
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("bd-error", e.getLocalizedMessage());
            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }

        return builder.build();
    }

    @POST
    @Path("/ubicacion")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ubicar(Ubicacion u) {
        Response.ResponseBuilder builder = null;
        try {
            service.ubicar(u);
            builder = Response.status(201).entity("Ubicacion registrada correctamente");
        } catch (SQLException e) {
            // Handle the unique constrain violation
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("bd-error", e.getLocalizedMessage());
            builder = Response.status(Response.Status.CONFLICT).entity(responseObj);
        } catch (Exception e) {
            // Handle generic exceptions
            Map<String, String> responseObj = new HashMap<>();
            responseObj.put("error", e.getMessage());
            builder = Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
        }
        return builder.build();

    }

    @GET
    @Path("/mov-cercano/{lat}/{lon}/{dis}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<UbicacionMovil> listarCercanos(@PathParam("lat") String lat, @PathParam("lon") String lon,
            @PathParam("dis") String dis) {

        List<UbicacionMovil> lObject = service.seleccionar(lat, lon, dis);
        return lObject;
    }

}