package uniandes.edu.co.proyecto.repositorio;

import java.util.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.TarjetaCredito;

public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Integer> {

    @Query(value = "SELECT * FROM TarjetaCredito", nativeQuery = true)
    Collection<TarjetaCredito> getTarjetasCredito();

    @Query(value = "SELECT * FROM TarjetaCredito WHERE NUMERO = :NUMERO", nativeQuery = true)
    TarjetaCredito getTarjetaCredito(@Param("NUMERO") int NUMERO);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO TarjetaCredito (NUMERO, NOMBRETARJETA, FECHAVENCIMIENTO, CODIGOSEGURIDAD, IDUSUARIOCLIENTE) VALUES (:NUMERO, :NOMBRETARJETA, :FECHAVENCIMIENTO, :CODIGOSEGURIDAD, :IDUSUARIOCLIENTE)", nativeQuery = true)
    void insertTarjetaCredito(@Param("NUMERO") int NUMERO, @Param("NOMBRETARJETA") String NOMBRETARJETA, @Param("FECHAVENCIMIENTO") Date FECHAVENCIMIENTO, @Param("CODIGOSEGURIDAD") int CODIGOSEGURIDAD, @Param("IDUSUARIOCLIENTE") Long IDUSUARIOCLIENTE);

    @Modifying
    @Transactional
    @Query(value = "UPDATE TarjetaCredito SET NOMBRETARJETA=:NOMBRETARJETA, FECHAVENCIMIENTO=:FECHAVENCIMIENTO, CODIGOSEGURIDAD=:CODIGOSEGURIDAD, IDUSUARIOCLIENTE=:IDUSUARIOCLIENTE WHERE NUMERO=:NUMERO", nativeQuery = true)
    void updateTarjetaCredito(@Param("NUMERO") int NUMERO, @Param("NOMBRETARJETA") String NOMBRETARJETA, @Param("FECHAVENCIMIENTO") Date FECHAVENCIMIENTO, @Param("CODIGOSEGURIDAD") int CODIGOSEGURIDAD, @Param("IDUSUARIOCLIENTE") Long IDUSUARIOCLIENTE);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM TarjetaCredito WHERE NUMERO = :NUMERO", nativeQuery = true)
    void deleteTarjetaCredito(@Param("NUMERO") Long NUMERO);

}
