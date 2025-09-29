package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.PuntoGeografico;

public interface PuntoGeograficoRepository extends JpaRepository<PuntoGeografico, String> {
    
}
