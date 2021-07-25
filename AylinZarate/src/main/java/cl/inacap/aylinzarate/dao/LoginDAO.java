package cl.inacap.aylinzarate.dao;

import cl.inacap.aylinzarate.models.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Aylin
 */
public class LoginDAO implements LoginInterfaceDAO{
    
    @PersistenceContext(unitName = "MIBANCO_PU")
    private EntityManager em;

    @Override
    public List<Cliente> ObtenerLogin(Cliente cliente) {
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.rut=:rut AND c.clave=:clave");
        query.setParameter("rut", cliente.getRut());
        query.setParameter("clave", cliente.getClave());
        return query.getResultList();
    }

    @Override
    public List<Cliente> ObtenerCliente(String rut) {
        Query query = em.createQuery("SELECT c FROM Cliente c WHERE c.rut=:rut");
        query.setParameter("rut", rut);
        //query.setParameter("clave", "123");
        return query.getResultList();
    }
   
  
    
}
