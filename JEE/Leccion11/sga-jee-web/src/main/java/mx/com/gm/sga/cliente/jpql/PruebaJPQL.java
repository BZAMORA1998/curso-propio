package mx.com.gm.sga.cliente.jpql;

import java.util.Iterator;
import java.util.List;
import javax.persistence.*;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;
import org.apache.logging.log4j.*;

public class PruebaJPQL {
    
    static Logger log =LogManager.getRootLogger();
    
    public static void main(String[] args){
        String jpql=null;
        Query q=null;
        List<Persona> personas=null;
        Persona persona=null;
        Iterator iter=null;//Sirve para iterar elementos de coleccion
        Object[] tupla=null;//varios objetos de diferentes tipos
        List<String> nombres=null;
        List<Usuario> usuarios=null;
        
        EntityManagerFactory emf=Persistence.createEntityManagerFactory("SgaPU");
        EntityManager em =emf.createEntityManager();
        
        //1. Consulta de todas las personas
        log.debug("1. Consulta de todas las personas");
        jpql="select p from Persona p";
        personas=em.createQuery(jpql).getResultList();//Extraigo la lista 
        //mostrarPersonas(personas);//Envio la lista para mostrar en consola}
        
        //2. Consulta de la Persona con id=1
        log.debug("2. Consulta de la Persona con id=1");
        jpql="select p from Persona p where p.idpersona=1";
        persona=(Persona) em.createQuery(jpql).getSingleResult();
        //log.debug("La persona es: "+persona);
        
        //3. Consulta de la Persona con el nombre Karla
        jpql="select p from Persona p where p.nombre='Karla'";
        personas=em.createQuery(jpql).getResultList();   
        //mostrarPersonas(personas);
        
        //4.Consultas de datos individuales, se crea un arreglo tupla
        log.debug("4.Consultas de datos individuales, se crea un arreglo tupla");
        jpql="select p.nombre as Nombre , p.apellido as Apellido, p.email as Email from Persona p";
        iter=em.createQuery(jpql).getResultList().iterator();
        
        while(iter.hasNext()){
            tupla=(Object[]) iter.next();
            String nombre=(String) tupla[0];
            String apellido=(String) tupla[1];
            String email=(String) tupla[2];
            //log.debug("nombre: "+nombre+", apellido: "+apellido+", email: "+email);
        }
        
        //5. obtiene el objeto persona y id, se crea un arreglo tipo object con 2 columnas
        log.debug("5. obtiene el objeto persona y id, se crea un arreglo tipo object con 2 columnas");
        jpql="select p, p.idpersona from Persona p";
        iter=em.createQuery(jpql).getResultList().iterator();
        
        while(iter.hasNext()){
            tupla=(Object[]) iter.next();
            persona=(Persona) tupla[0];
            int idPersona=(int) tupla[1];
            //log.debug("objeto persona: "+persona+ "id_persona"+idPersona);
        }
        
        //6. Consulta de todas las personas 
        log.debug("6. Consulta de todas las personas ");
        jpql="select new mx.com.gm.sga.domain.Persona(p.idpersona) from Persona p";
        personas=em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        
        //7. Regresa el valor minimo y maximo del idpersona (scarlet result)
        log.debug("7. Regresa el valor minimo y maximo del idpersona (scarlet result)");
        jpql="select min(p.idpersona) as MinId, max(p.idpersona) as MaxId, count(p.idpersona) as Contador from Persona p";
        iter=em.createQuery(jpql).getResultList().iterator();
        
        while(iter.hasNext()){
            tupla=(Object[]) iter.next();
            Integer idMin=(Integer) tupla[0];
            Integer idMax=(Integer) tupla[1];
            Long cont= (Long) tupla[2];
            
            //log.debug("Minimo: "+idMin+"Maximo: "+idMax+"Contador: "+cont);  
        }
        
        //8. cuenta los nombres de las personas que son distintos 
        log.debug("8. cuenta los nombres de las personas que son distintos ");
        jpql="select count(distinct p.nombre) from Persona p";
        Long cont=(Long) em.createQuery(jpql).getSingleResult();
        //log.debug("no. de personas con nombre distintos: "+cont);
        
        //9. Contador y convierte a mayusculas el nombre y apellido
        log.debug("9. Contador y convierte a mayusculas el nombre y apellido");
        jpql="select CONCAT(p.nombre,'-',p.apellido) as Nombre from Persona p";
        nombres=em.createQuery(jpql).getResultList();
        for(String n:nombres){
           // log.debug("Nombre : "+n);
        }
        
        //10 obtener el objeto persona con id igual al parametro proporcionado
        log.debug("10 obtener el objeto persona con id igual al parametro proporcionado");
        int idPersona=1;
        jpql="select p from Persona p where p.idpersona = :id";
        q=em.createQuery(jpql);
        q.setParameter("id",idPersona);
        persona=(Persona) q.getSingleResult();
        //log.debug("Persona: "+persona);
        
        //11. obtener las persona que contengan una letra a en el nombre , sin importar si es mayusculas o min
        String nombre="%a%";
        log.debug("11. obtener las persona que contengan una letra a en el nombre , sin importar si es mayusculas o min");
        jpql="select p from Persona p where upper(p.nombre) like upper(:nombre)";
        q=em.createQuery(jpql);
        q.setParameter("nombre",nombre);
        personas=q.getResultList();
        
        //mostrarPersonas(personas);
       
        //12. Uso de between
        log.debug("12. Uso de between");
        jpql="select p from Persona p where p.idpersona between 1 and 10"; 
        personas=em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //13. uso del order by
        log.debug("13. uso del order by");
        jpql="select p.nombre,p.apellido from Persona p where p.idpersona > 3 order by p.nombre";
        iter=em.createQuery(jpql).getResultStream().iterator();
        
        while(iter.hasNext()){
            tupla=(Object[]) iter.next();
            String nombr=(String) tupla[0];
            String apellido=(String) tupla[1];
            
         //   log.debug(nombr+"-"+apellido);
        }
        
        //14. uso de subquery
        log.debug("14. uso de subquery");
        jpql="select p from Persona p where p.idpersona in (select min(p1.idpersona) from Persona p1)";
        personas =em.createQuery(jpql).getResultList();
        //mostrarPersonas(personas);
        
        //15. uso de join con lazy loading
        log.debug("15. uso de join con lazy loading");
        jpql="select u from Usuario u join u.persona p";
        
        usuarios=em.createQuery(jpql).getResultList();
        //mostrarUsuarios(usuarios);
        
        //16.usoa de left join  join con eager loading
        log.debug("16.usoa de left join  join con eager loading");
        jpql="select u from Usuario u left join fetch u.persona";
        usuarios=em.createQuery(jpql).getResultList();
        mostrarUsuarios(usuarios);
    }

    private static void mostrarPersonas(List<Persona> personas) {
        for(Persona p:personas){
            log.debug("Persona: "+p);
        }
    }

    private static void mostrarUsuarios(List<Usuario> usuarios) {
        for(Usuario u:usuarios){
            log.debug("Usuario: "+u);
        }
    }
}
