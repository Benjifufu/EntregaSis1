package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Long> {

    @Query(value = "SELECT * FROM CIUDAD", nativeQuery = true)
    Collection<Ciudad> getCiudades();

    @Query(value = "SELECT * FROM Ciudad WHERE IDCIUDAD = :IDCIUDAD", nativeQuery = true)
    Ciudad getCiudad(@Param("IDCIUDAD") Long IDCIUDAD);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Ciudad (IDCIUDAD, departamento, nombre) VALUES (CIUDAD_SEQ.nextval, :departamento, :nombre)", nativeQuery = true)
    void insertCiudad(@Param("departamento") String departamento, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Ciudad SET departamento=:departamento, nombre=:nombre WHERE IDCIUDAD = :IDCIUDAD", nativeQuery = true)
    void updateCiudad(@Param("IDCIUDAD") Long IDCIUDAD, @Param("departamento") String departamento, @Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Ciudad WHERE IDCIUDAD = :IDCIUDAD", nativeQuery = true)
    void deleteCiudad(@Param("IDCIUDAD") Long IDCIUDAD);

}