
package mx.com.gm.sga.cliente.asociaciones;

import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class ClienteAsosacionesJPA {
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        
        //ASOCIACION EAGER
        
        EntityManagerFactory emf= Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
       List<Persona> personas=em.createNamedQuery("Persona.findAll").getResultList();
       //cerramos
       em.close();
       //imprimir los objetos de tipo persona
       
       for(Persona p: personas){
           log.debug("Personas: "+p);
           //recuperamos los usuarios de cada persona
           for(Usuario u:p.getUsuarioList()){
             log.debug("Usuarios: "+u);
           }
       }
    }
}
