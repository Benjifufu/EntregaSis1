package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.PuntoGeografico;

public interface PuntoGeograficoRepository extends JpaRepository<PuntoGeografico, String> {
    
    @Query(value = "SELECT * FROM PuntoGeografico", nativeQuery = true)
    Collection<PuntoGeografico> getPuntoGeografico();

    @Query(value = "SELECT * FROM PuntoGeografico WHERE DIRECCION = :DIRECCION", nativeQuery = true)
    PuntoGeografico getPuntoGeografico(@Param("DIRECCION") Long DIRECCION);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO PuntoGeografico (COORDENADAX, DIRECCION, COORDENADAY, IDCIUDAD) VALUES (:COORDENADAX, :DIRECCION, :COORDENADAY, :IDCIUDAD)", nativeQuery = true)
    void insertPuntoGeografico(@Param("COORDENADAX") Long COORDENADAX, @Param("DIRECCION") String DIRECCION, @Param("COORDENADAY") Long COORDENADAY, @Param("IDCIUDAD") Long IDCIUDAD);

    @Modifying
    @Transactional
    @Query(value = "UPDATE PuntoGeografico SET :TIPOSERVICIO, :PLACA, :HORAINICIO, :HORAFIN, :DIASEMANA WHERE IDDISPONIBILIDAD=:IDDISPONIBILIDAD", nativeQuery = true)
    void updatePuntoGeografico(@Param("IDDISPONIBILIDAD") Long IDDISPONIBILIDAD, @Param("TIPOSERVICIO") String TIPOSERVICIO, @Param("PLACA") String PLACA, @Param("HORAINICIO") String HORAINICIO, @Param("HORAFIN") String HORAFIN, @Param("DIASEMANA") String DIASEMANA);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM PuntoGeografico WHERE IDDISPONIBILIDAD=:IDDISPONIBILIDAD", nativeQuery = true)
    void deletePuntoGeografico(@Param("IDDISPONIBILIDAD") Long IDDISPONIBILIDAD);
    
}
