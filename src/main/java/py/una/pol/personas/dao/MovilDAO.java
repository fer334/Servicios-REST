package py.una.pol.personas.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.inject.Inject;

import py.una.pol.personas.model.Movil;

public class MovilDAO {
    @Inject
    private Logger log;

    public List<Movil> seleccionar(){
        String query = "SELECT identificador, tipo FROM movil ORDER BY identificador";
        List<Movil> lista = new ArrayList<>();
        Connection conn = null;

        try {

        	conn = Bd.connect();
            ResultSet rs = conn.createStatement().executeQuery(query);

            while (rs.next()) {
                Movil m = new Movil();
                m.setIdentificador(rs.getLong(1));
                m.setTipo(rs.getString(2));

                lista.add(m);
            }
            
        } catch (SQLException ex) {
            log.severe("Error en la seleccion: " + ex.getMessage());
        } finally {
            try {
                conn.close();
            } catch (Exception ef) {
                log.severe("No se pudo cerrar la conexion a BD: " + ef.getMessage());
            }
        }
        return lista;

    }
}