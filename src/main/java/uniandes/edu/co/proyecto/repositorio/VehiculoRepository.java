package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, String> {
    
    @Query(value = "SELECT * FROM Vehiculo", nativeQuery = true)
    Collection<Vehiculo> getVehiculos();

    @Query(value = "SELECT * FROM Vehiculo WHERE PLACA = :PLACA", nativeQuery = true)
    Vehiculo getVehiculo(@Param("PLACA") Long PLACA);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Vehiculo (PLACA, TIPO, MARCA, MODELO, COLOR, CAPACIDAD, IDCIUDAD, IDUSUARIOCONDUCTOR) VALUES (:PLACA, :TIPO, :MARCA, :MODELO, :COLOR, :CAPACIDAD, :IDCIUDAD, :IDUSUARIOCONDUCTOR)", nativeQuery = true)
    void insertVehiculo(@Param("PLACA") String PLACA, @Param("TIPO") String TIPO, @Param("MARCA") String MARCA, @Param("MODELO") String MODELO, @Param("COLOR") String COLOR, @Param("CAPACIDAD") int CAPACIDAD, @Param("IDCIUDAD") Long IDCIUDAD, @Param("IDUSUARIOCONDUCTOR") Long IDUSUARIOCONDUCTOR);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE Vehiculo SET TIPO=:TIPO, MARCA=:MARCA, MODELO=:MODELO, COLOR=:COLOR, CAPACIDAD=:CAPACIDAD, IDCIUDAD=:IDCIUDAD, IDUSUARIOCONDUCTOR=:IDUSUARIOCONDUCTOR WHERE PLACA=:PLACA", nativeQuery = true)
    void updateVehiculo(@Param("PLACA") Long PLACA, @Param("NOMBRE") String NOMBRE, @Param("CORREO") String CORREO, @Param("CEDULA") String CEDULA, @Param("CELULAR") String CELULAR);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Vehiculo WHERE PLACA = :PLACA", nativeQuery = true)
    void deleteVehiculo(@Param("PLACA") Long PLACA);

}
