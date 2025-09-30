package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Servicio;

public interface ServicioRepository extends JpaRepository<Servicio, Long> {
        
    @Query(value = "SELECT * FROM Servicio", nativeQuery = true)
    Collection<Servicio> getServicios();

    @Query(value = "SELECT * FROM Servicio WHERE IDSERVICIO = :IDSERVICIO", nativeQuery = true)
    Servicio getServicio(@Param("IDSERVICIO") Long IDSERVICIO);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Servicio (IDSERVICIO, TIPO, NIVEL, DISTANCIA, COSTOTOTAL, DURACION, NIVELTRANSPORTE, ORDENDOMICILIO, IDUSUARIOCLIENTE, IDUSUARIOCONDUCTOR, PLACA, FECHAINICIO, FECHAFINAL) VALUES (SERVICIO_SEQ.nextval, :TIPO, :NIVEL, :DISTANCIA, :COSTOTOTAL, :DURACION, :NIVELTRANSPORTE, :ORDENDOMICILIO, :IDUSUARIOCLIENTE, :IDUSUARIOCONDUCTOR, :PLACA, TO_TIMESTAMP(:FECHAINICIO, 'DD-MM-YYYY HH:MI:SS AM'), TO_TIMESTAMP(:FECHAFINAL, 'DD-MM-YYYY HH:MI:SS AM'))", nativeQuery = true)
    void insertServicio(
        @Param("TIPO") String TIPO, 
        @Param("NIVEL") String NIVEL, 
        @Param("DISTANCIA") double DISTANCIA, 
        @Param("COSTOTOTAL") double COSTOTOTAL, 
        @Param("DURACION") String DURACION, 
        @Param("NIVELTRANSPORTE") String NIVELTRANSPORTE, 
        @Param("ORDENDOMICILIO") String ORDENDOMICILIO, 
        @Param("IDUSUARIOCLIENTE") Long IDUSUARIOCLIENTE, 
        @Param("IDUSUARIOCONDUCTOR") Long IDUSUARIOCONDUCTOR, 
        @Param("PLACA") String PLACA, 
        @Param("FECHAINICIO") Date FECHAINICIO,
        @Param("FECHAFINAL") Date FECHAFINAL
    );

    @Modifying
    @Transactional
    @Query(value = "UPDATE Servicio SET TIPO=:TIPO, NIVEL=:NIVEL, DISTANCIA=:DISTANCIA, COSTOTOTAL=:COSTOTOTAL, DURACION=:DURACION, NIVELTRANSPORTE=:NIVELTRANSPORTE, ORDENDOMICILIO=:ORDENDOMICILIO, IDUSUARIOCLIENTE=:IDUSUARIOCLIENTE, IDUSUARIOCONDUCTOR=:IDUSUARIOCONDUCTOR, PLACA=:PLACA, FECHAINICIO=:FECHAINICIO, FECHAFINAL=:FECHAFINAL WHERE IDSERVICIO=:IDSERVICIO", nativeQuery = true)
    void updateServicio(
        @Param("TIPO") String TIPO, 
        @Param("NIVEL") String NIVEL, 
        @Param("DISTANCIA") double DISTANCIA, 
        @Param("COSTOTOTAL") double COSTOTOTAL, 
        @Param("DURACION") String DURACION, 
        @Param("NIVELTRANSPORTE") String NIVELTRANSPORTE, 
        @Param("ORDENDOMICILIO") String ORDENDOMICILIO, 
        @Param("IDUSUARIOCLIENTE") Long IDUSUARIOCLIENTE, 
        @Param("IDUSUARIOCONDUCTOR") Long IDUSUARIOCONDUCTOR, 
        @Param("PLACA") String PLACA, 
        @Param("FECHAINICIO") Date FECHAINICIO,
        @Param("FECHAFINAL") Date FECHAFINAL
        );

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Servicio WHERE IDSERVICIO=:IDSERVICIO", nativeQuery = true)
    void deleteServicio(@Param("IDSERVICIO") long IDSERVICIO);

    @Query(value= "SELECT s.IDSERVICIO, s.TIPO, s.NIVEL, s.DISTANCIA, s.COSTOTOTAL as COSTO_TOTAL, s.HORAINICIO as HORA_INICIO, s.HORAFINAL as HORA_FINAL, s.DURACION, s.NIVELTRANSPORTE as NIVEL_TRANSPORTE, s.ORDENDOMICILIO, s.IDUSUARIOCONDUCTOR\r\n" + //
            "FROM SERVICIO s\r\n" + //
            "WHERE s.IDUSUARIOCLIENTE = :id", nativeQuery = true)
    Collection<Servicio> getServiciosByCliente(@Param("id") Long id);

    @Query(value = "SELECT s.TIPO AS TIPO_SERVICIO, s.NIVEL AS NIVEL_SERVICIO, COUNT(*) AS TOTAL_SERVICIOS,\r\n" + //
            "ROUND(COUNT(*) * 100.0 / SUM(COUNT(*)) OVER(), 2) AS PORCENTAJE_TOTAL,\r\n" + //
            "SUM(s.COSTOTOTAL) AS INGRESOS_TOTALES, c.NOMBRE AS CIUDAD\r\n" + //
            "FROM SERVICIO s\r\n" + //
            "INNER JOIN VEHICULO v ON s.PLACA = v.PLACA\r\n" + //
            "INNER JOIN CIUDAD c ON v.IDCIUDAD = c.IDCIUDAD\r\n" + //
            "WHERE c.NOMBRE = 'Bogotá'\r\n" + //
            "AND s.FECHAINICIO BETWEEN CAST(:fechaInicio AS TIMESTAMP) AND CAST(:fechaFin AS TIMESTAMP)\r\n" + //
            "GROUP BY s.TIPO, s.NIVEL, c.NOMBRE\r\n" + //
            "ORDER BY TOTAL_SERVICIOS DESC, INGRESOS_TOTALES DESC", nativeQuery = true)
    Collection<Servicio> getReporteServiciosBogotaPorFecha(@Param("fechaInicio") Date fechaInicio, @Param("fechaFin") Date fechaFin);
    
}
