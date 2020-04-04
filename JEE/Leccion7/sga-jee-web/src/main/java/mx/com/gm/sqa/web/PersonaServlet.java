/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.com.gm.sqa.web;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mx.com.gm.sga.domain.Persona;
import mx.com.gm.sga.servicio.PersonaService;

@WebServlet("/personas")
public class PersonaServlet extends HttpServlet {

    @Inject
    PersonaService personaService;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
            List<Persona> personas=personaService.listarPersonas();
            System.out.println("Personas: "+personas);
            request.setAttribute("personas",personas);
            request.getRequestDispatcher("/listadoPersonas.jsp").forward(request,response);
    }

}
