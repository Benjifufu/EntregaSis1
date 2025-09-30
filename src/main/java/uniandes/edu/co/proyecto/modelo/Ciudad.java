package uniandes.edu.co.proyecto.modelo;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CIUDAD")
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCiudad;

    @Column(nullable = false)
    private String departamento;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "ciudad")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "ciudad")
    private List<PuntoGeografico> puntosGeograficos;

    public Ciudad(){;}

    public Ciudad(String departamento, String nombre) {
        this.departamento = departamento;
        this.nombre = nombre;
    }

    public Long getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public List<PuntoGeografico> getPuntosGeograficos() {
        return puntosGeograficos;
    }

    public void setPuntosGeograficos(List<PuntoGeografico> puntosGeograficos) {
        this.puntosGeograficos = puntosGeograficos;
    }

}
