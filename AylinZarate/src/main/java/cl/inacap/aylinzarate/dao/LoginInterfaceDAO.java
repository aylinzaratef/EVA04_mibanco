package cl.inacap.aylinzarate.dao;

import cl.inacap.aylinzarate.models.Cliente;
import java.util.List;

/**
 *
 * @author Aylin
 */
public interface LoginInterfaceDAO {
    public List<Cliente> ObtenerLogin(Cliente usuario);
    public List<Cliente> ObtenerCliente(String rut);
        
    }

