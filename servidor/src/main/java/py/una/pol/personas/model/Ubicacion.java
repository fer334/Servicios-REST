package py.una.pol.personas.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ubicacion {
    private String latitud;
    private String longitud;
    private Long timestamp;
    private Long movil;

    public Ubicacion() {
    }

    public Ubicacion(String latitud, String longitud, Long timestamp) {
        this.latitud = latitud;
        this.longitud = longitud;
        this.timestamp = timestamp;

    }
    public Long getMovil() {
        return this.movil;
    }

    public void setMovil(Long movil) {
        this.movil = movil;
    }

    public String getLatitud() {
        return this.latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return this.longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Long getTimestamp() {
        return this.timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

}