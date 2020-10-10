package py.una.pol.personas.model;

import javax.xml.bind.annotation.XmlRootElement;

// @SuppressWarnings("serial")
@XmlRootElement
public class Movil {

    private Long identificador;
    private String tipo;


    public Movil() {
    }

    public Movil(Long identificador, String tipo) {
        this.identificador = identificador;
        this.tipo = tipo;
    }

    public Long getIdentificador() {
        return this.identificador;
    }

    public void setIdentificador(Long identificador) {
        this.identificador = identificador;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Movil identificador(Long identificador) {
        this.identificador = identificador;
        return this;
    }

    public Movil tipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

}