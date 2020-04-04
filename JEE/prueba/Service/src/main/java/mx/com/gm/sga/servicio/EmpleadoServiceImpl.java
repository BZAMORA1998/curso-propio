package mx.com.gm.sga.servicio;

import java.util.List;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.WebService;
import mx.com.gm.sga.datos.EmpleadoDao;
import mx.com.gm.sga.domain.Empleado;

@Stateless
public class EmpleadoServiceImpl implements EmpleadoServiceLocal,EmpleadoServiceRemote{
    @Inject
    private EmpleadoDao eDao;
    
    @Override
    public List<Empleado> listarTodo() {
        return eDao.ListarEmpleados();
    }

    @Override
    public void EliminarPorId(Empleado e) {
       eDao.EliminarEmpleado(e);
    }
    
    @Override
    public void ActualizarPorId(Empleado e) {
        eDao.ActualizarEmpleado(e);
    }

    @Override
    public Empleado BuscarPorId(Empleado e) {
        return eDao.ListarEmpleadoById(e);
    }

    @Override
    public void IngresarEmpleado(Empleado e) {
        eDao.InsertarEmpleado(e);
    }
    
}
