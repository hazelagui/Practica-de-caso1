/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Practica1.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import Practica1.domain.Estado;
import Practica1.repository.EstadoRepository;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author hazelagx
 */
@Service
public class EstadoService {
    @Autowired
    private EstadoRepository estadoRepository;

    public List<Estado> listarEstados() {
        return estadoRepository.findAll();
    }

    public Optional<Estado> buscarPorId(Integer id) {
        return estadoRepository.findById(id);
    }

    public Estado guardarEstado(Estado estado) {
        return estadoRepository.save(estado);
    }

    public void eliminarEstado(Integer id) {
        estadoRepository.deleteById(id);
    }
}


