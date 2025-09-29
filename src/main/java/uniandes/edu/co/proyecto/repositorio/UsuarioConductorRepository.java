package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.UsuarioConductor;

public interface UsuarioConductorRepository extends JpaRepository<UsuarioConductor, Long> {
    
    @Query(value = "SELECT * FROM UsuarioConductor", nativeQuery = true)
    Collection<UsuarioConductor> getUsuarioConductores();

    @Query(value = "SELECT * FROM UsuarioConductor WHERE IDUSUARIOCONDUCTOR = :IDUSUARIOCONDUCTOR", nativeQuery = true)
    UsuarioConductor getUsuarioConductor(@Param("IDUSUARIOCONDUCTOR") Long IDUSUARIOCONDUCTOR);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO UsuarioConductor (IDUSUARIOCONDUCTOR, NOMBRE, CORREO, CEDULA, CELULAR) VALUES (USUARIO_CONDUCTOR_SEQ.nextval, :NOMBRE, :CORREO, :CEDULA, :CELULAR)", nativeQuery = true)
    void insertUsuarioConductor(@Param("NOMBRE") String NOMBRE, @Param("CORREO") String CORREO, @Param("CEDULA") String CEDULA, @Param("CELULAR") String CELULAR);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE UsuarioConductor SET NOMBRE=:NOMBRE, CORREO=:CORREO, CEDULA=:CEDULA, CELULAR=:CELULAR WHERE IDUSUARIOCONDUCTOR=:IDUSUARIOCONDUCTOR", nativeQuery = true)
    void updateUsuarioConductor(@Param("IDUSUARIOCONDUCTOR") Long IDUSUARIOCONDUCTOR, @Param("NOMBRE") String NOMBRE, @Param("CORREO") String CORREO, @Param("CEDULA") String CEDULA, @Param("CELULAR") String CELULAR);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM UsuarioConductor WHERE IDUSUARIOCONDUCTOR = :IDUSUARIOCONDUCTOR", nativeQuery = true)
    void deleteUsuarioConductor(@Param("IDUSUARIOCONDUCTOR") Long IDUSUARIOCONDUCTOR);

}
    