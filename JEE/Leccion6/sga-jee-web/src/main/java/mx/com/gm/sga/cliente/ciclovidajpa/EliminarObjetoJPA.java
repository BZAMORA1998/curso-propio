package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EliminarObjetoJPA {
    static Logger log=LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
        //iniciamos la transaccion
            EntityTransaction tx=em.getTransaction();
            tx.begin();
            //Buscamos la clase q deseamos eliminar
                Persona persona1=em.find(Persona.class,5);
                tx.commit();
                log.debug("La clase encontrada: "+persona1);
            //iniciamos otra transaction
             EntityTransaction tx2=em.getTransaction();
             tx2.begin();
             //procedemos a eliminar la clase
                em.remove(persona1);
                tx2.commit();
                log.debug("La persona ha sido eliminada...");
             em.close();
            
    }
}
