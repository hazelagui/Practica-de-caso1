package Practica1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Practica1.domain.Arbol;
import Practica1.repository.ArbolRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ArbolService {

    @Autowired
    private ArbolRepository arbolRepository;

    // Listar todos los árboles
    public List<Arbol> listarArboles() {
        return arbolRepository.findAll();
    }

    // Guardar o actualizar un árbol
    public Arbol guardarArbol(Arbol arbol) {
        // Aquí podrías poner validaciones, por ejemplo nombre obligatorio
        if(arbol.getNombreComun() == null || arbol.getNombreComun().isEmpty()) {
            throw new IllegalArgumentException("El nombre del árbol no puede estar vacío");
        }
        return arbolRepository.save(arbol);
    }

    // Buscar un árbol por id
    public Optional<Arbol> buscarPorId(Integer id) {
        return arbolRepository.findById(id);
    }

    // Eliminar un árbol por id
    public void eliminarArbol(Integer id) {
        arbolRepository.deleteById(id);
    }
}
