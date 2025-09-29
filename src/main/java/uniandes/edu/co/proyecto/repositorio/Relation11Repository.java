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
    @Query(value = "UPDATE Relation11 SET :IDRUTA, :DIRECCION WHERE ", nativeQuery = true)
    void updateRelation11(@Param("COORDENADAX") Long COORDENADAX, @Param("Relation11PK") String Relation11PK, @Param("COORDENADAY") Long COORDENADAY, @Param("IDCIUDAD") Long IDCIUDAD);


    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Relation11 WHERE Relation11PK=:Relation11PK", nativeQuery = true)
    void deleteRelation11(@Param("Relation11PK") String Relation11PK);
    
}
