package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.*;
import oracle.net.aso.l;

@Entity
@Table(name = "relation_11")
public class Relation11 {

    @EmbeddedId
    private Relation11PK pk;

    @ManyToOne
    @JoinColumn(name = "idRuta", insertable = false, updatable = false)
    private RutaServicio rutaServicio;

    @ManyToOne
    @JoinColumn(name = "direccion", insertable = false, updatable = false)
    private PuntoGeografico puntoGeografico;

    public Relation11(){
        ;
    }

    public Relation11(Long idRuta, String direccion){
        this.pk = new Relation11PK(idRuta, direccion);
    }

    public Relation11PK getPk() {
        return pk;
    }

    public void setPk(Relation11PK pk) {
        this.pk = pk;
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