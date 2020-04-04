/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.Empleado;

@Stateless
public class EmpleadoDaoImpl implements EmpleadoDao{

    @PersistenceContext(unitName="SgaPU")
    EntityManager em;
    
    @Override
    public List<Empleado> ListarEmpleados() {
        return em.createNamedQuery("Empleado.findAll").getResultList();
    }

    @Override
    public Empleado ListarEmpleadoById(Empleado e) {
        return em.find(Empleado.class,e.getIdempleado());
    }

    @Override
    public void InsertarEmpleado(Empleado e) {
        em.persist(e);
    }

    @Override
    public void ActualizarEmpleado(Empleado e) {
        em.merge(e);
    }

    @Override
    public void EliminarEmpleado(Empleado e) {
        em.remove(em.merge(e));
    }
    
}
