/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.servicio;

import java.util.List;
import mx.com.gm.sga.domain.Empleado;

/**
 *
 * @author Bryan
 */
public interface EmpleadoServiceRemote {
    public List<Empleado> listarTodo();
    public void IngresarEmpleado(Empleado e);
    public void EliminarPorId(Empleado e);
    public void ActualizarPorId(Empleado e);
    public Empleado BuscarPorId(Empleado e);
}
