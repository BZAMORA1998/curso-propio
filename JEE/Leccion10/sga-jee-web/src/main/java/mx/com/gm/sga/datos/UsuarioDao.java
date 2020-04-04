/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sga.datos;

import java.util.List;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.domain.Usuario;

/**
 *
 * @author Bryan
 */
public interface UsuarioDao {
    public List<Usuario> findUsuarioAll();
    public Persona findUsuarioById(Usuario usuario);
    public Persona findUsuarioByEmail(Usuario usuario);
    public void insertUsuario(Usuario usuario);
    public void updateUsuario(Usuario usuario);
    public void deleteUsuario(Usuario usuario);
}
