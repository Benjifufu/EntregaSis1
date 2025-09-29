package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Relation11;
import uniandes.edu.co.proyecto.modelo.Relation11PK;

public interface Relation11Repository extends JpaRepository<Relation11, Relation11PK> {
        
    @Query(value = "SELECT * FROM Relation11", nativeQuery = true)
    Collection<Relation11> getRelation11();

    @Query(value = "SELECT * FROM Relation11 WHERE IDRUTA=:IDRUTA AND DIRECCION=:DIRECCION", nativeQuery = true)
    Relation11 getRelation11(@Param("IDRUTA") Long IDRUTA, @Param("DIRECCION") String DIRECCION);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Relation11 (IDRUTA, DIRECCION) VALUES (:IDRUTA, :DIRECCION)", nativeQuery = true)
    void insertRelation11(@Param("IDRUTA") Long IDRUTA, @Param("DIRECCION") String DIRECCION);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Relation11 SET IDRUTA=:IDRUTA_nu, DIRECCION=:DIRECCION_nu WHERE IDRUTA=:IDRUTA AND DIRECCION=:DIRECCION", nativeQuery = true)
    void updateRelation11(@Param("IDRUTA") Long IDRUTA, @Param("DIRECCION") String DIRECCION, @Param("IDRUTA_nu") Long IDRUTA_nu, @Param("DIRECCION_nu") String DIRECCION_nu);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Relation11 WHERE IDRUTA=:IDRUTA AND DIRECCION=:DIRECCION", nativeQuery = true)
    void deleteRelation11(@Param("IDRUTA") Long IDRUTA, @Param("DIRECCION") String DIRECCION);
    
}
