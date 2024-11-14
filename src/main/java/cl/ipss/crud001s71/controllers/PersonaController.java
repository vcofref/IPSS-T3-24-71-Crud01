package cl.ipss.crud001s71.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cl.ipss.crud001s71.models.Persona;
import cl.ipss.crud001s71.services.PersonaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("/")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    //Listar
    @GetMapping
    public String listarPersonas(Model model) {
        model.addAttribute("personas", personaService.listarTodas());
        return "persona-listar";
    }
    
    //Formulario Nueva Persona
    @GetMapping("/nueva")
    public String mostrarFormularioNuevaPersona(Model model) {
        model.addAttribute("persona", new Persona());
        return "persona-crear";
    }   

    //Guardar Persona
    @PostMapping("/guardar")
    public String postMethodName(Persona persona) {
        personaService.guardar(persona);        
        return "redirect:/";
    }    

    //Formulario Editar Persona
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditarPersona(@PathVariable Long id, Model model) {
        model.addAttribute("persona", personaService.obtenerPorId(id));
        return "persona-crear";
    }   
    
    //Eliminar Persona
    @GetMapping("/eliminar/{id}")
    public String EliminarPersona(@PathVariable Long id) {
        personaService.eliminar(id);
        return "redirect:/";
    }  

}
