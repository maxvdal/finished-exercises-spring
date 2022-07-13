package com.example.HolaSpring;

import com.example.HolaSpring.domain.Persona;
import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class ControladorInicio {

    @Value("${index.saludo}")
    private String saludo;

    @GetMapping("/")
    public String inicio(Model model) {
        String mensaje = "Hola Mundo desde Thymeleaf";
        
        Persona persona = new Persona();
        persona.setNombre("Maxi");
        persona.setApellido("Vidal");
        persona.setMail("maxi@mail.com");
        persona.setTelefono("2233344");
        
        Persona persona2 = new Persona();
        persona2.setNombre("Maximiliano");
        persona2.setApellido("Vidal");
        persona2.setMail("maxi2@mail.com");
        persona2.setTelefono("556677");
        
        List<Persona> personas = new ArrayList();
        personas.add(persona);
        personas.add(persona2);

        
        log.info("ejecutando el controlador Spring MVC");
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("saludo", saludo);
        //model.addAttribute("persona", persona);
        model.addAttribute("personas", personas);
        return "index";
    }
}
