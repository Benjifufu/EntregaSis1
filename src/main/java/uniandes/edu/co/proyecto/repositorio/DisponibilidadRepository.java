package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Disponibilidad;

public interface DisponibilidadRepository extends JpaRepository<Disponibilidad, Long> {
    
    @Query(value = "SELECT * FROM Disponibilidad", nativeQuery = true)
    Collection<Disponibilidad> getDisponibilidad();

    @Query(value = "SELECT * FROM Disponibilidad WHERE IDDISPONIBILIDAD = :IDDISPONIBILIDAD", nativeQuery = true)
    Disponibilidad getDisponibilidad(@Param("IDDISPONIBILIDAD") Long IDDISPONIBILIDAD);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Disponibilidad (IDDISPONIBILIDAD, TIPOSERVICIO, PLACA, HORAINICIO, HORAFIN, DIASEMANA) VALUES (DISPONIBILIDAD_SEQ.nextval, :TIPOSERVICIO, :PLACA, :HORAINICIO, :HORAFIN, :DIASEMANA)", nativeQuery = true)
    void insertDisponibilidad(@Param("TIPOSERVICIO") String TIPOSERVICIO, @Param("PLACA") String PLACA, @Param("HORAINICIO") String HORAINICIO, @Param("HORAFIN") String HORAFIN, @Param("DIASEMANA") String DIASEMANA);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Disponibilidad SET TIPOSERVICIO=:TIPOSERVICIO, PLACA=:PLACA, HORAINICIO=:HORAINICIO, HORAFIN=:HORAFIN, DIASEMANA=:DIASEMANA WHERE IDDISPONIBILIDAD=:IDDISPONIBILIDAD", nativeQuery = true)
    void updateDisponibilidad(@Param("IDDISPONIBILIDAD") Long IDDISPONIBILIDAD, @Param("TIPOSERVICIO") String TIPOSERVICIO, @Param("PLACA") String PLACA, @Param("HORAINICIO") String HORAINICIO, @Param("HORAFIN") String HORAFIN, @Param("DIASEMANA") String DIASEMANA);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Disponibilidad WHERE IDDISPONIBILIDAD=:IDDISPONIBILIDAD", nativeQuery = true)
    void deleteDisponibilidad(@Param("IDDISPONIBILIDAD") Long IDDISPONIBILIDAD);

}