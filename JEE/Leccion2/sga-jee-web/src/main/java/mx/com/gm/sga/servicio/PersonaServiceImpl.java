/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import mx.com.gm.sga.domain.Persona;

@Stateless
public class PersonaServiceImpl implements PersonaSeviceRemote,PersonaService{

    @Override
    public List<Persona> listarPersonas() {
       
     return null;
    }
    
    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return null;    
    }

    @Override
    public void registrarPersona(Persona persona) {
       
    }

    @Override
    public void modificarPersona(Persona persona) {
        }

    @Override
    public void eliminarPersona(Persona persona) {
        
    }
    
}
