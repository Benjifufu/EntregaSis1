package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.Revision;

public interface RevisionRepository extends JpaRepository<Revision, Long> {
    
}
