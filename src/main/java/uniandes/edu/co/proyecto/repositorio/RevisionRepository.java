package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Revision;

public interface RevisionRepository extends JpaRepository<Revision, Long> {
        
    @Query(value = "SELECT * FROM Revision", nativeQuery = true)
    Collection<Revision> getRevision();

    @Query(value = "SELECT * FROM Revision WHERE IDREVISION = :IDREVISION", nativeQuery = true)
    Revision getRevision(@Param("IDREVISION") Long IDREVISION);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Revision (IDREVISION, CALIFICACION, COOMENTARIO, REVISIONSERVICIOUSUARIO, IDUSUARIOCLIENTE, IDUSUARIOCONDUCTOR) VALUES (REVISION_SEQ.nextval, :CALIFICACION, :COOMENTARIO, :REVISIONSERVICIOUSUARIO, :IDUSUARIOCLIENTE, :IDUSUARIOCONDUCTOR)", nativeQuery = true)
    void insertRevision(@Param("CALIFICACION") Long CALIFICACION, @Param("COMENTARIO") String COMENTARIO, @Param("REVISIONSERVICIOUSUARIO") String REVISIONSERVICIOUSUARIO, @Param("IDUSUARIOCLIENTE") Long IDUSUARIOCLIENTE, @Param("IDUSUARIOCONDUCTOR") Long IDUSUARIOCONDUCTOR);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Revision SET CALIFICACION=:CALIFICACION, COOMENTARIO=:COOMENTARIO, REVISIONSERVICIOUSUARIO=:REVISIONSERVICIOUSUARIO, IDUSUARIOCLIENTE=:IDUSUARIOCLIENTE, IDUSUARIOCONDUCTOR=:IDUSUARIOCONDUCTOR WHERE IDREVISION=:IDREVISION", nativeQuery = true)
    void updateRevision(@Param("IDREVISION") Long IDREVISION, @Param("CALIFICACION") Long CALIFICACION, @Param("COMENTARIO") String COMENTARIO, @Param("REVISIONSERVICIOUSUARIO") String REVISIONSERVICIOUSUARIO, @Param("IDUSUARIOCLIENTE") Long IDUSUARIOCLIENTE, @Param("IDUSUARIOCONDUCTOR") Long IDUSUARIOCONDUCTOR);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Revision WHERE IDREVISION=:IDREVISION", nativeQuery = true)
    void deleteRevision(@Param("IDREVISION") String IDREVISION);
    
}
