package py.una.pol.personas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.inject.Inject;

import py.una.pol.personas.model.Movil;
import py.una.pol.personas.model.Ubicacion;
import py.una.pol.personas.model.UbicacionMovil;

public class UbicacionDAO {
    @Inject
    private Logger log;

    public void ubicar(Ubicacion u) throws SQLException {
        String sql = "insert into ubicacion(latitud,longitud,date,movil) Values (?,?,?,?)";
        Connection conn = null;
        try {
            u.setTimestamp(System.currentTimeMillis());
            conn = Bd.connect();
            PreparedStatement p = conn.prepareStatement(sql);
            p.setString(1, u.getLatitud());
            p.setString(2, u.getLongitud());
            p.setObject(3, new Timestamp( System.currentTimeMillis()));
            p.setInt(4, u.getMovil().intValue());
            p.executeUpdate();
            
        }catch (SQLException e) {
            throw e;
        }finally {
            try {
                conn.close();
            } catch (Exception e) {
                log.severe("No se pudo cerrar la conexion a la bd: " + e.getMessage());
            }
        }
    }

	public List<UbicacionMovil> seleccionar(String lat, String lon, String dis) {
        String query = "select * from ubicacion as u left join movil as m on m.identificador = u.movil;";

        List<UbicacionMovil> lista = new ArrayList<>();

        Connection conn = null;
        try {
            conn = Bd.connect();
            ResultSet rs = conn.createStatement().executeQuery(query);

            while (rs.next()) {

                Long lat1 = Long.parseLong(lat);
                Long lon1 = Long.parseLong(lon);
                Long lat2 = Long.parseLong(rs.getString(2));
                Long lon2 = Long.parseLong(rs.getString(3));
                Double r = Math.sqrt(Math.pow((lat1 - lat2), 2) + Math.pow((lon1 - lon2), 2));
                Long d = r.longValue();
                 
                int c = Long.compare(d, Long.parseLong(dis,10));
                if( c < 0 ){
                    Ubicacion u = new Ubicacion();
                    u.setLatitud(rs.getString(2));
                    u.setLongitud(rs.getString(3));
                    u.setTimestamp(rs.getTimestamp(4).getTime());
                    Movil m = new Movil();
                    m.setIdentificador(rs.getLong(6));
                    m.setTipo(rs.getString(7));
                    lista.add(new UbicacionMovil(m,u));
                }

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