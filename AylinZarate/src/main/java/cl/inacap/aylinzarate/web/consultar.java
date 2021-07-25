package cl.inacap.aylinzarate.web;

import cl.inacap.aylinzarate.controllers.loginInterface;
import cl.inacap.aylinzarate.models.Cliente;
import cl.inacap.aylinzarate.models.Cuenta;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aylin
 */
@WebServlet(name = "consultar", urlPatterns = {"/ConsultarSaldo"})
public class consultar extends HttpServlet {

    @Inject
    loginInterface loginController;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession();
        Cliente cliente_login = (Cliente)session.getAttribute("cliente");
        Cliente cliente = loginController.login(cliente_login).get(0);
        
        System.out.println(cliente);
        Cuenta cuenta = cliente.getCuentaList().get(0);
        
        request.setAttribute("cliente", cliente);
        request.setAttribute("cuenta", cuenta);
        
        request.getRequestDispatcher("/ConsultarSaldo.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        doGet(request, response);
    }


}
