package py.una.pol.personas.model;

public class UbicacionMovil {
    private Movil movil;
    private Ubicacion ubicacion;
    
    public UbicacionMovil() {
    }

    public UbicacionMovil(Movil movil, Ubicacion ubicacion) {
        this.movil = movil;
        this.ubicacion = ubicacion;
    }

    public Movil getMovil() {
        return this.movil;
    }

    public void setMovil(Movil movil) {
        this.movil = movil;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    public UbicacionMovil movil(Movil movil) {
        this.movil = movil;
        return this;
    }

    public UbicacionMovil ubicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
        return this;
    }
}