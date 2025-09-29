package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "rutaservicio")
public class RutaServicio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRuta;

    @ManyToOne
    @JoinColumn(name = "idServicio", nullable = false)
    private Servicio servicio;

    @OneToMany(mappedBy = "rutaServicio")
    private List<Relation11PK> puntos;

    public RutaServicio(){;}

    public RutaServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public Long getIdRuta() {
        return idRuta;
    }
    public void setIdRuta(Long idRuta) {
        this.idRuta = idRuta;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public List<Relation11PK> getPuntos() {
        return puntos;
    }
    public void setPuntos(List<Relation11PK> puntos) {
        this.puntos = puntos;
    }
  
    
}
