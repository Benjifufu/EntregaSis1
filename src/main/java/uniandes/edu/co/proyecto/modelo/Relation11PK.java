package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class Relation11PK implements Serializable {

    @ManyToOne
    @JoinColumn(name = "idRuta", insertable = false, updatable = false)
    private RutaServicio rutaServicio;

    @ManyToOne
    @JoinColumn(name = "direccion", insertable = false, updatable = false)
    private PuntoGeografico puntoGeografico;

    public Relation11PK() {
        super();
    }

    public Relation11PK(RutaServicio rutaServicio, PuntoGeografico puntoGeografico) {
        super();
        this.rutaServicio = rutaServicio;
        this.puntoGeografico = puntoGeografico;
    }
    
    public RutaServicio getRutaServicio() {
        return rutaServicio;
    }

    public void setRutaServicio(RutaServicio rutaServicio) {
        this.rutaServicio = rutaServicio;
    }
    
    public PuntoGeografico getPuntoGeografico() {
        return puntoGeografico;
    }

    public void setPuntoGeografico(PuntoGeografico puntoGeografico) {
        this.puntoGeografico = puntoGeografico;
    }

    
}
