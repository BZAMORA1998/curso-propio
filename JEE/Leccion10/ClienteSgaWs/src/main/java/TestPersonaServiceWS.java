
import clientews.servicio.Persona;
import clientews.servicio.PersonaServiceImplService;
import clientews.servicio.PersonaServiceWS;
import java.util.List;

public class TestPersonaServiceWS {
    public static void main(String[] args){
      PersonaServiceWS personaService=new PersonaServiceImplService().getPersonaServiceImplPort();
    
      System.out.println("Ejecutando servicio listar persona");
      List<Persona> personas=personaService.listarPersonas();
      for(Persona p:personas){
          System.out.println("Persona: "+p.getNombre());      
      }
    } 
}
