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
@Table(name = "usuarioconductor")
public class UsuarioConductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuarioConductor;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String cedula;

    @Column(nullable = false)
    private String celular;

    @Column(nullable = false)
    private String correo;

    @OneToMany(mappedBy = "usuarioConductor")
    private List<Revision> revisiones;

    @OneToMany(mappedBy = "usuarioConductor")
    private List<Vehiculo> vehiculos;

    @OneToMany(mappedBy = "usuarioConductor")
    private List<Servicio> servicios;

    public UsuarioConductor(){;}

    public UsuarioConductor(String nombre, String cedula, String celular, String correo) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.celular = celular;
        this.correo = correo;
    }

    public Long getIdUsuarioConductor() {
        return idUsuarioConductor;
    }

    public void setIdUsuarioConductor(Long idUsuarioConductor) {
        this.idUsuarioConductor = idUsuarioConductor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Revision> getRevisiones() {
        return revisiones;
    }
    public void setRevisiones(List<Revision> revisiones) {
        this.revisiones = revisiones;
    }
    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }
    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public List<Servicio> getServicios() {
        return servicios;
    }
    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    
}
