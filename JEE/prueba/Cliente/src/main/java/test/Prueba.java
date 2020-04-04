package test;

import domain.Empleado;
import java.util.List;
import javax.ws.rs.client.*;
import javax.ws.rs.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Prueba {
    
    //Variables que vamos a utilizar
    private static final String URL_BASE = "http://localhost:8080/Service/webservice";
    private static Client cliente;
    private static WebTarget webTarget;
    private static Empleado empleado;
    private static List<Empleado> empleados;
    private static Invocation.Builder invocationBuilder;
    private static Response response;
    
    public static void main(String[] args) {
        cliente = ClientBuilder.newClient();
        
        //Leer una persona (metodo get)
        webTarget = cliente.target(URL_BASE).path("/empleado");
        //Proporcionamos un idPersona valido
        empleado = webTarget.path("/1").request(MediaType.APPLICATION_XML).get(Empleado.class);
        System.out.println("Empleado recuperada:" + empleado);
        
        
        //Leer todas los Empleados (metodo get con readEntity de tipo List<>
        empleados = webTarget.request(MediaType.APPLICATION_XML).get(Response.class).readEntity(new GenericType<List<Empleado>>(){});
        System.out.println("\nPersonas recuperadas");
        imprimirEmpleado(empleados);
        
        //Agregar una persona (metodo post)
        Empleado nuevaEmpleado = new Empleado();
        nuevaEmpleado.setCedula("0928914465");
        nuevaEmpleado.setNombre("Carlos");
        nuevaEmpleado.setApellido("Miranda");
        nuevaEmpleado.setCargo("Desarrollador");
        nuevaEmpleado.setSueldo("200");
        
        invocationBuilder = webTarget.request(MediaType.APPLICATION_XML);
        response = invocationBuilder.post(Entity.entity(nuevaEmpleado, MediaType.APPLICATION_XML));
        System.out.println("");
        System.out.println(response.getStatus());
        //Recuperamos los Empleados recien agregada para despues modificarla y al final eliminarla
        Empleado empleadoRecuperada = response.readEntity(Empleado.class);
        System.out.println("Persona agregada:" + empleadoRecuperada);
        
        
        //Modificar la persona (metodo put)
        //persona recuperada anteriormente
        Empleado empleadoModificar = empleadoRecuperada;
        empleadoModificar.setApellido("Ramirez");
        String pathId = "/" +empleadoModificar.getIdempleado();
        invocationBuilder = webTarget.path(pathId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.put(Entity.entity(empleadoModificar, MediaType.APPLICATION_XML));
        
        System.out.println("");
        System.out.println("response:" + response.getStatus());
        System.out.println("Empleado modifica:" + response.readEntity(Empleado.class));
        

        //eliminar una persona
        //persona recuperada anteriormente
        Empleado empleadoEliminar = empleadoRecuperada;
        String pathEliminarId = "/" + empleadoEliminar.getIdempleado();
        invocationBuilder = webTarget.path(pathEliminarId).request(MediaType.APPLICATION_XML);
        response = invocationBuilder.delete();
        System.out.println("");
        System.out.println("response:" + response.getStatus());
        System.out.println("Persona Eliminada" + empleadoEliminar);
        
        
    }

    private static void imprimirEmpleado(List<Empleado> empleados) {
        for(Empleado e: empleados){
            System.out.println("Empleado:" + e);
        }
    }
    
}
