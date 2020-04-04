package mx.com.gm.sga.datos;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;

@Stateless
public class UsuarioDaoImpl implements UsuarioDao{

    @PersistenceContext(unitName="SgaPU")
    EntityManager em;
    
    @Override
    public List<Usuario> findUsuarioAll() {
        return em.createNamedQuery("Usuario.findAll").getResultList();
    }

    @Override
    public Persona findUsuarioById(Usuario usuario) {
        return null;
    }

    @Override
    public Persona findUsuarioByEmail(Usuario usuario) {
        return null;
    }

    @Override
    public void insertUsuario(Usuario usuario) {
      
    }

    @Override
    public void updateUsuario(Usuario usuario) {
       
    }

    @Override
    public void deleteUsuario(Usuario usuario) {
        
    }
}
