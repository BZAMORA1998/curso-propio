package mx.com.gm.sga.cliente.ciclovidajpa;

import javax.persistence.*;
import javax.persistence.Persistence;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PersistirObjetoJPA {
    static Logger log =LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        EntityTransaction tx=em.getTransaction();
        
        //iniciar la transaction
        //creamos un objeto en estado transistivo
        Persona persona1=new Persona("Pedro","Luna","pluna@email.com","13135566");
        
        //iniciar transaction
        tx.begin();
        
               //ejecutar sql
               em.persist(persona1);
        
        //se le asigna clave primaria
        tx.commit();
        
        
        log.debug("Persona guardad con exito "+persona1);
        
        em.close();
        
    }
}
