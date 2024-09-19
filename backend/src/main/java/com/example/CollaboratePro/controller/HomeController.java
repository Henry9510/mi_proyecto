package com.example.CollaboratePro.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return ""; // Esta es la vista de inicio, crea el archivo home.html en templates
    }

    @GetMapping("/login")
    public String login() {
        return "login"; // Página de inicio de sesión
    }
}


