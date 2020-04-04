
package mx.com.gm.sga.cliente;

import java.util.List;
import javax.naming.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaSeviceRemote;
import org.apache.logging.log4j.*;

public class PruebaManejoTransacciones {
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        try {
            Context jndi=new InitialContext();
            PersonaSeviceRemote personaService=(PersonaSeviceRemote) jndi.lookup("java:global/sga-jee-web/PersonaServiceImpl!mx.com.gm.sga.servicio.PersonaSeviceRemote");
            log.debug("Inicializando prueba Manejo transaccional PersonaService");
            //busca objeto
            Persona persona=personaService.encontrarPersonaPorId(new Persona(1));
            log.debug("Persona recuperada");
            log.debug(persona);
            
            //cambiamos el nombre de la persona
            persona.setNombre("Juan");
            persona.setApellido("Perez");
            personaService.modificarPersona(persona);
            log.debug("Objeto Modifocado...");
            
        } catch (NamingException ex) {
            log.debug(ex.getMessage());
        }
    }
}