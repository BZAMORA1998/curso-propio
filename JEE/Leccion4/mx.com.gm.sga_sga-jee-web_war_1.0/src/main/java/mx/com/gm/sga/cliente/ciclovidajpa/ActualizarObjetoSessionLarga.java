/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ActualizarObjetoSessionLarga {
     static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
        //iniciamos la transaccion
            EntityTransaction tx=em.getTransaction();
            tx.begin();
                Persona persona1=em.find(Persona.class,1);
                log.debug("Encontrado: "+persona1);
                persona1.setApellido("Juan");
                persona1.setNombre("Perez");
            //cerramos el entity manager
            em.close();
            //termina la transaccion
            tx.commit();
            
            log.debug("Actualizacion: "+persona1);
    }
}
