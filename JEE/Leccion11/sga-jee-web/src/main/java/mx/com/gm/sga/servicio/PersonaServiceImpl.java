/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import com.mysql.cj.Session;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.PersonaDao;
import mx.com.gm.sga.domain.Persona;

@Stateless
@WebService(endpointInterface="mx.com.gm.sga.servicio.PersonaServiceWS")
public class PersonaServiceImpl implements PersonaSeviceRemote,PersonaService,PersonaServiceWS{

    @Inject 
    private PersonaDao personaDao;
    @Resource
    private SessionContext contexto;//Sirve para hacer rollback
    
    @Override
    public List<Persona> listarPersonas() {
       
     return personaDao.findPersonaAll();
    }
    
    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return personaDao.findPersonaById(persona);
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return personaDao.findPersonaByEmail(persona);    
    }

    @Override
    public void registrarPersona(Persona persona) {
       personaDao.insertPersona(persona);
    }

    @Override
    public void modificarPersona(Persona persona) {
        try{
            personaDao.updatePersona(persona);
        }catch(Throwable t){
            contexto.setRollbackOnly();
            t.printStackTrace(System.out);
        }
    }

    @Override
    public void eliminarPersona(Persona persona) {
        try{
         personaDao.deletePersona(persona);
        }catch(Throwable t){
            
        }
    }    
}
