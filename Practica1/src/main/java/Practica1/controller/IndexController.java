/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Practica1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import Practica1.service.ArbolService;

@Controller
public class IndexController {

    private final ArbolService arbolService;

    public IndexController(ArbolService arbolService) {
        this.arbolService = arbolService;
    }

    @GetMapping("/")
    public String mostrarIndex(Model model) {
        model.addAttribute("arboles", arbolService.listarArboles());
        model.addAttribute("title", "Lista de Árboles");
        model.addAttribute("contenido", "index :: contenido");
        return "plantilla";
    }
}

