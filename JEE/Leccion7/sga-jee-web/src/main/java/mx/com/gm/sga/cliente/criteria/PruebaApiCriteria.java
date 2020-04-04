
package mx.com.gm.sga.cliente.criteria;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import javax.persistence.criteria.*;
import mx.com.gm.sga.domain.Persona;
import org.apache.logging.log4j.*;

public class PruebaApiCriteria {
    
    static Logger log =LogManager.getRootLogger();
    
    public static void main(String[] args){
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em=emf.createEntityManager();
        
        CriteriaBuilder cb=em.getCriteriaBuilder();
        CriteriaQuery<Persona> criteriaQuery=null;
        Root<Persona> fromPersona=null;
        TypedQuery<Persona> query =null;
        List<Persona> personas=null;
        Persona persona=null;
        
        //Query utilizando al API de Criteria
        //Consulta de todas las personas 
        
        //1. crear una instancia criteria buelder
             cb=em.getCriteriaBuilder();
        //2. se crea un objeto criteria query
            criteriaQuery=cb.createQuery(Persona.class);
        //3. Creamos el objeto raiza de query
            fromPersona=criteriaQuery.from(Persona.class);
        //4. Seleccionamos lo necesario del from  
            criteriaQuery.select(fromPersona);
        //5. creamos e query typeSafe
            query=em.createQuery(criteriaQuery);
        //6. ejecutamos la consulata
            personas=query.getResultList();
            
            //mostrarPersonas(personas);
            
            
        //2.a consulta de la Persona con id=1;
        log.debug("2-a. consulta de la Persona con id=1;");
        //1. crear una instancia criteria buelder
            cb=em.getCriteriaBuilder();
        //2. se crea un objeto criteria query
            criteriaQuery =cb.createQuery(Persona.class);
        //3. Creamos el objeto raiza de query
            fromPersona=criteriaQuery.from(Persona.class);
        //4. Seleccionamos lo necesario del from  
            criteriaQuery.select(fromPersona).where(cb.equal(fromPersona.get("idpersona"),1));
        //5. creamos e query typeSafe
            query=em.createQuery(criteriaQuery);
        //6. ejecutamos la consulata
            persona=query.getSingleResult();
        
        //log.debug(persona);
        
        //2.a consulta de la Persona con id=1;
        log.debug("2-a. consulta de la Persona con id=1;");
        //1. crear una instancia criteria buelder
            cb=em.getCriteriaBuilder();
        //2. se crea un objeto criteria query
            criteriaQuery =cb.createQuery(Persona.class);
        //3. Creamos el objeto raiza de query
            fromPersona=criteriaQuery.from(Persona.class);
        //4. Seleccionamos lo necesario del from  
            criteriaQuery.select(fromPersona);
        
        //La clase Predicate permite agregar varios criterios dinamicamente
            List<Predicate> criterios= new ArrayList<Predicate>();
         
        //verificamos si tenemos criterios que agregar
            Integer idPersonaParam=1;
         //Tipo de parametro y el parametro
            ParameterExpression<Integer> parameter=cb.parameter(Integer.class,"idpersona");
         //Se crea el criterio y se agrega llamado la clase con su respectivo parametro
            criterios.add(cb.equal(fromPersona.get("idpersona"),parameter));
            
            //Se agregan los criterios
            if(criterios.isEmpty()){
                throw new RuntimeException("Sincriterio");
            }else if(criterios.size()==1){
                criteriaQuery.where(criterios.get(0));
            }else{
              criteriaQuery.where(cb.and(criterios.toArray(new Predicate[0])));
            }
            
            query=em.createQuery(criteriaQuery);
            query.setParameter("idpersona",idPersonaParam);
            
            //se ejecuta el query
                persona=query.getSingleResult();
                log.debug(persona);
    }
    
    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p:personas){
            log.debug(p);
        }
    }
}
