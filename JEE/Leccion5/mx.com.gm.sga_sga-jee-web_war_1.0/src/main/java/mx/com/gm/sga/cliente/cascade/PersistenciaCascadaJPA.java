/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.cliente.cascade;

import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PersistenciaCascadaJPA {
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        tx.begin();
        
        //creamos nuevos objetos e inicializamos
        Persona persona1=new Persona("Hugo", "Hernandez","hhernadez@mail.com","55778822");
        Usuario usuario1=new Usuario("hhernandez","123",persona1);
        //insertamos en cascada 
        //El usuario ya contiene la persona

        em.persist(usuario1);
        tx.commit();
        //cerramos la transacion
        log.debug("Persona: " +persona1);
        log.debug("Usuario: "+usuario1);
        em.close();
        //
        
    }
}
