package py.una.pol.personas.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

	public void registrar(Movil m) throws SQLException {
        String sql = "insert into movil(identificador, tipo)"+"values(?,?)";

        Connection conn = null;
        try {
            log.info("hola");

            conn = Bd.connect();
            PreparedStatement p = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            p.setLong(1, m.getIdentificador());
            p.setString(2, m.getTipo());
            p.executeUpdate();

            // int affectedRows = p.executeUpdate();
            // if(affectedRows > 0 ){
            //     try(ResultSet rs = p.getGeneratedKeys()){;}
            //     catch(SQLException e){throw e;}
            // }
        } catch (SQLException e) {
            throw e;
        }finally{
            try{conn.close();}
            catch(Exception e){
                log.severe("No se pudo cerrar la conexion a la bd: " + e.getMessage());
            }
        }
	}
}