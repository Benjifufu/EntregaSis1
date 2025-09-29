package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.UsuarioCliente;

public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Long> {
    
    @Query(value = "SELECT * FROM UsuarioCliente", nativeQuery = true)
    Collection<UsuarioCliente> getUsuarioClientees();

    @Query(value = "SELECT * FROM UsuarioCliente WHERE IDUSUARIOCLIENTE = :IDUSUARIOCLIENTE", nativeQuery = true)
    UsuarioCliente getUsuarioCliente(@Param("IDUSUARIOCLIENTE") Long IDUSUARIOCLIENTE);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO UsuarioCliente (IDUSUARIOCLIENTE, NOMBRE, CORREO, CEDULA, CELULAR) VALUES (USUARIO_CLIENTE_SEQ.nextval, :NOMBRE, :CORREO, :CEDULA, :CELULAR)", nativeQuery = true)
    void insertUsuarioCliente(@Param("NOMBRE") String NOMBRE, @Param("CORREO") String CORREO, @Param("CEDULA") String CEDULA, @Param("CELULAR") String CELULAR);
    
    @Modifying
    @Transactional
    @Query(value = "UPDATE UsuarioCliente SET NOMBRE=:NOMBRE, CORREO=:CORREO, CEDULA=:CEDULA, CELULAR=:CELULAR WHERE IDUSUARIOCLIENTE=:IDUSUARIOCLIENTE", nativeQuery = true)
    void updateUsuarioCliente(@Param("IDUSUARIOCLIENTE") Long IDUSUARIOCLIENTE, @Param("NOMBRE") String NOMBRE, @Param("CORREO") String CORREO, @Param("CEDULA") String CEDULA, @Param("CELULAR") String CELULAR);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM UsuarioCliente WHERE IDUSUARIOCLIENTE = :IDUSUARIOCLIENTE", nativeQuery = true)
    void deleteUsuarioCliente(@Param("IDUSUARIOCLIENTE") Long IDUSUARIOCLIENTE);

}
