package cl.ipss.crud001s71.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.ipss.crud001s71.models.Persona;
import cl.ipss.crud001s71.repositories.PersonaRepository;

@Service
public class PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    //Listar
    public List<Persona> listarTodas(){
        return personaRepository.findAll();        
    }

    //Guardar
    public Persona guardar(Persona persona){
        return personaRepository.save(persona);
    }

    //buscar
    public Persona obtenerPorId(Long id){
        return personaRepository.findById(id).orElse(null);
    }

    //Eliminar
    public void eliminar(Long id){
        personaRepository.deleteById(id);
    }

}
