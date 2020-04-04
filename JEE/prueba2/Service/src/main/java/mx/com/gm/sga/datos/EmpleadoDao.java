
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Empleado;

public interface EmpleadoDao {
    public List<Empleado> ListarEmpleados();
    public Empleado ListarEmpleadoById(Empleado e);
    public void InsertarEmpleado(Empleado e);
    public void ActualizarEmpleado(Empleado e);
    public void EliminarEmpleado(Empleado e);
}
