
package mx.com.gm.sga.servicio;

import java.util.List;
import javax.ejb.Local;
import mx.com.gm.sga.domain.Empleado;

@Local
public interface EmpleadoServiceLocal {
    public List<Empleado> listarTodo();
    public void IngresarEmpleado(Empleado e);
    public void EliminarPorId(Empleado e);
    public void ActualizarPorId(Empleado e);
    public Empleado BuscarPorId(Empleado e);
}
