/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Practica1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import Practica1.domain.Estado;
/**
 *
 * @author hazelagx
 */
@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
