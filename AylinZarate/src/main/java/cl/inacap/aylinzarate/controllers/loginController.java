package cl.inacap.aylinzarate.controllers;

import cl.inacap.aylinzarate.dao.LoginInterfaceDAO;
import cl.inacap.aylinzarate.models.Cliente;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Aylin
 */
public class loginController implements loginInterface{
    
    @Inject
    private LoginInterfaceDAO loginDAO;

    @Override
    public List<Cliente> login(Cliente cliente) {
        return loginDAO.ObtenerLogin(cliente);
    }

    @Override
    public List<Cliente> obtenerCliente(String rut) {
        return loginDAO.ObtenerCliente(rut);
    }

    
    
    
}
