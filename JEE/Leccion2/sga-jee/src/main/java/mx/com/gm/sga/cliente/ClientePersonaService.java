/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaSeviceRemote;

public class ClientePersonaService {
    public static void main(String[] args){
        System.out.println("Iniciando llamada al jdb desde el cliente \n");
        try{
            Context jndi=new InitialContext();
            PersonaSeviceRemote personaService=(PersonaSeviceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceRemoteImp!mx.com.gm.sga.servicio.PersonaSeviceRemote");
            List<Persona> personas=personaService.listarPersonas();
            
            listarPersona(personas);
            
        }catch(NamingException e){
            e.printStackTrace(System.out);
        }
    }

    private static void listarPersona(List<Persona> personas) {
        for(Persona p:personas){
            System.out.println(p);
        }
    }
}
