/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EncontrarObjetoJPA {
    static Logger log=LogManager.getRootLogger();
    public static void main(String[] arg){
        EntityManagerFactory emf =Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        //1. inciar la transacion y crear un nuevo objeto
            tx.begin();
        
        //2. Ejecuta SQL de tipo select   
            Persona persona1=em.find(Persona.class,1);
       
          tx.commit();
          
          log.debug("La persona encontrada es: "+persona1);
          
            //cerramos entity manager 
          em.close();
    }
}
