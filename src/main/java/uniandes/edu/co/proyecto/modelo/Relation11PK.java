package uniandes.edu.co.proyecto.modelo;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Relation11PK implements Serializable {

    private Integer idRuta;  // Tipo básico, no relación
    private String direccion; // Tipo básico, no relación

    public Relation11PK() {
        super();
    }

    public Relation11PK(Integer idRuta, String direccion) {
        super();
        this.idRuta = idRuta;
        this.direccion = direccion;
    }
    
    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Relation11PK)) return false;
        Relation11PK that = (Relation11PK) o;
        return Objects.equals(idRuta, that.idRuta) && 
               Objects.equals(direccion, that.direccion);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idRuta, direccion);
    }
}