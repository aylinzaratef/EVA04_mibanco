package cl.inacap.aylinzarate.controllers;
import cl.inacap.aylinzarate.models.Cliente;
import java.util.List;
/**
 *
 * @author Aylin
 */
public interface loginInterface {
    
    public List<Cliente> login(Cliente cliente);
    public List<Cliente> obtenerCliente(String rut);
    
}
