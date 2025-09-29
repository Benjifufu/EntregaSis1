package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "relation_11")
public class Relation11 {

    @EmbeddedId
    private Relation11PK pk;

    public Relation11(){
        ;
    }
    public Relation11(RutaServicio rutaServicio, PuntoGeografico puntoGeografico){
        this.pk = new Relation11PK(rutaServicio, puntoGeografico);
    }

    public Relation11PK getPk() {
        return pk;
    }
    public void setPk(Relation11PK pk) {
        this.pk = pk;
    }

}
