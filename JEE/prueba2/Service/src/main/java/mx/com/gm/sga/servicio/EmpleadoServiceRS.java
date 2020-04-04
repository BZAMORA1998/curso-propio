package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.core.Response.Status;
import mx.com.gm.sga.domain.Empleado;
import mx.com.gm.sga.servicio.EmpleadoServiceLocal;

@Path("/empleado")
@Stateless
public class EmpleadoServiceRS {
   @Inject
   private EmpleadoServiceLocal es;//Injectamos el servicio ejb
   
   @GET//
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})//tipo de informacion q retorna
   public List<Empleado> listarEmpleados(){
       return es.listarTodo();
   }
   
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")//hace referencia a /personas/{id}
    public Empleado encontrarPersonaPorId(@PathParam("id") int id) {
        return es.BuscarPorId(new Empleado(id));
    }
    
    @POST//Se usa para modificar
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response agregarEmpleado(Empleado e){
        try{
            es.IngresarEmpleado(e);
            return Response.ok().entity(e).build();//retorna la respuesta
        }catch(Exception ec){
            ec.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{id}")
    public Response ModificarEmpleado(@PathParam("id")int id,Empleado e){
        try{
            Empleado em=es.BuscarPorId(e);
            if(em!=null){
                es.ActualizarPorId(e);
                return Response.ok().entity(e).build();//retorna la respuesta
            }else{
                return Response.status(Status.NOT_FOUND).build();
            }
            
            
        }catch(Exception ec){
             ec.printStackTrace(System.out);
            return Response.status(Status.INTERNAL_SERVER_ERROR).build();
        }
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminarPersonaPorId(@PathParam("id") int id) {
        try {
            es.EliminarPorId(new Empleado(id));
            return Response.ok().build();
        } catch (Exception e) {
            e.printStackTrace(System.out);
            return Response.status(404).build();
        }
    }
}
