/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Practica1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import Practica1.domain.Arbol;
import Practica1.service.ArbolService;

import java.util.Optional;

@Controller
@RequestMapping("/arboles")
public class ArbolController {

    @Autowired
    private ArbolService arbolService;

    @GetMapping
    public String listarArboles(Model model) {
        model.addAttribute("arboles", arbolService.listarArboles());
        model.addAttribute("title", "Lista de Árboles");
        model.addAttribute("contenido", "index :: contenido");
        return "plantilla";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoArbol(Model model) {
        model.addAttribute("arbol", new Arbol());
        return "formulario"; 
    }

    @PostMapping("/guardar")
    public String guardarArbol(@ModelAttribute Arbol arbol) {
        arbolService.guardarArbol(arbol);
        return "redirect:/arboles"; 
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Integer id, Model model) {
        Optional<Arbol> optionalArbol = arbolService.buscarPorId(id);
        if(optionalArbol.isPresent()) {
            model.addAttribute("arbol", optionalArbol.get());
            return "formulario"; 
        } else {
            return "redirect:/arboles"; 
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarArbol(@PathVariable Integer id) {
        arbolService.eliminarArbol(id);
        return "redirect:/arboles"; 
    }
}