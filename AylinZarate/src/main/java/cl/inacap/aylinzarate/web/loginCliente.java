package cl.inacap.aylinzarate.web;

import cl.inacap.aylinzarate.controllers.loginInterface;
import cl.inacap.aylinzarate.models.Cliente;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Aylin
 */

@WebServlet(name = "loginCliente", urlPatterns = {"/loginCliente"})
public class loginCliente extends HttpServlet {

    @Inject
    loginInterface loginController;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if (request.getAttribute("redirect") != null) {
                ServletContext context = getServletContext();
                RequestDispatcher rd = context.getRequestDispatcher("/ConsultarSaldo");
                rd.forward(request, response);

            } else {
                
                HttpSession session = request.getSession();
                
                session.invalidate();
                request.getRequestDispatcher("/login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        
        List<String> errores = new ArrayList<>();
        List<Cliente> clienteLogin = new ArrayList<>();
        

        String rut = request.getParameter("rut-txt").trim();
        if (rut.isEmpty()) {
            errores.add("Debe ingresar un RUT.");
        }

        String clave = request.getParameter("clave-txt").trim();
        if (clave.isEmpty()) {
            errores.add("Debe ingresar una contraseña.");
        }
          String claveEncriptada = "";
        try {
             byte[] bytes = MessageDigest.getInstance("MD5").digest(clave.getBytes("UTF-8"));
            claveEncriptada = DatatypeConverter.printHexBinary(bytes).toUpperCase();
             
             
             
        }catch (Exception ex){
            errores.add("Fallo total del sistema");
        }
       
        
        if (errores.isEmpty()) {
            Cliente cliente = new Cliente();
            cliente.setRut(rut);
            cliente.setClave(claveEncriptada);
            try {
                clienteLogin = loginController.login(cliente);
                if (clienteLogin.size() == 0) {
                    errores.add("RUT o Contraseña incorrectos.");
                }
            } catch (Exception e) {
                errores.add("Error al iniciar sesión.");
            }

        } else {
            
            request.setAttribute("errores", errores);
        }

        if (!errores.isEmpty()) {
            request.setAttribute("errores", errores);
            
        } else {
 
            request.setAttribute("redirect", true);
            session.setAttribute("cliente", clienteLogin.get(0));
        }

        doGet(request, response);
    }
}
