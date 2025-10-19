
package Practica1.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import Practica1.domain.Arbol;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbolRepository extends JpaRepository<Arbol, Integer> {
    // Aquí podrías agregar consultas personalizadas 
}