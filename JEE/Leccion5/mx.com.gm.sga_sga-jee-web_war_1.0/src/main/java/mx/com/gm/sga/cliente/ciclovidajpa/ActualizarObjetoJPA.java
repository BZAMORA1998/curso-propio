/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class ActualizarObjetoJPA {
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        tx.begin();
            Persona persona1=em.find(Persona.class,1);    
        tx.commit();
            log.debug("Se encontro la clase :"+persona1);
            
        tx.begin();
        
        //se modifica con setValue(numeroValor)
        EntityTransaction tx2=em.getTransaction();
            persona1.setApellido("Perez");
            em.merge(persona1);
        tx2.commit();
            log.debug("Se a modificado "+persona1);
        em.close();
    }
}
