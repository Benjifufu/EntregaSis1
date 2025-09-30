package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.RutaServicio;

public interface RutaServicioRepository extends JpaRepository<RutaServicio, Long> {
    
    @Query(value = "SELECT * FROM RutaServicio", nativeQuery = true)
    Collection<RutaServicio> getRutasServicios();

    @Query(value = "SELECT * FROM RutaServicio WHERE IDRUTA = :IDRUTA", nativeQuery = true)
    RutaServicio getRutaServicio(@Param("IDRUTA") Long IDRUTA);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO RutaServicio (IDRUTA, IDSERVICIO) VALUES (RUTA_SERVICIO_SEQ.nextval, :idServicio)", nativeQuery = true)
    void insertRutaServicio(@Param("idServicio") Long idServicio);

    @Modifying
    @Transactional
    @Query(value = "UPDATE RutaServicio SET IDSERVICIO=:IDSERVICIO WHERE IDRUTA=:IDRUTA", nativeQuery = true)
    void updateRutaServicio(@Param("IDRUTA") Long IDRUTA, @Param("IDSERVICIO") Long IDSERVICIO);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM RutaServicio WHERE IDRUTA=:IDRUTA", nativeQuery = true)
    void deleteRutaServicio(@Param("IDRUTA") long IDRUTA);

}
