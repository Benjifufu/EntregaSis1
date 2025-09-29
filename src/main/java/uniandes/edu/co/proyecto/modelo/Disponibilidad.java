package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "disponibilidad")
public class Disponibilidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisponibilidad;

    @Column(nullable = false)
    private String diaSemana;

    @Column(nullable = false)
    private String horaInicio;

    @Column(nullable = false)
    private String horaFin;

    @Column(nullable = false)
    private String tipoServicio;

    @ManyToOne
    @JoinColumn(name = "placa", nullable = false)
    private Vehiculo vehiculo;

    public Disponibilidad() {;}

    public Disponibilidad(String diaSemana, String horaInicio, String horaFin, String tipoServicio, Vehiculo vehiculo) {
        this.diaSemana = diaSemana;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tipoServicio = tipoServicio;
        this.vehiculo = vehiculo;
    }

    public Long getIdDisponibilidad() {
        return idDisponibilidad;
    }

    public void setIdDisponibilidad(Long idDisponibilidad) {
        this.idDisponibilidad = idDisponibilidad;
    }

    public String getDiaSemana() {
        return diaSemana;
    }   

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }   

    public String getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin;
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        this.tipoServicio = tipoServicio;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

   
}
