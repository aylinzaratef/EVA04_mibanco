package cl.inacap.aylinzarate.web;

import cl.inacap.aylinzarate.controllers.loginInterface;
import cl.inacap.aylinzarate.controllers.transaccionInterface;
import cl.inacap.aylinzarate.models.Cliente;
import cl.inacap.aylinzarate.models.Cuenta;
import cl.inacap.aylinzarate.models.Movimientos;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "Historial", urlPatterns = {"/Historial"})
public class Historial extends HttpServlet {
    
     @Inject
    transaccionInterface transaccionController;
     @Inject
    loginInterface loginController;
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         HttpSession session = request.getSession();
        Cliente cliente_login = (Cliente)session.getAttribute("cliente");
        Cliente cliente = loginController.login(cliente_login).get(0);

        List<Cuenta> cuenta_cliente = transaccionController.obtenerCuenta(cliente.getCuentaList().get(0).getNumerocta());
        Cuenta cuenta = cuenta_cliente.get(0);


        List<Movimientos> movimientos = cuenta.getMovimientosList();


        request.setAttribute("listaMovimientos", movimientos);
        request.getRequestDispatcher("/Historial.jsp").forward(request, response);
        
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }


}
