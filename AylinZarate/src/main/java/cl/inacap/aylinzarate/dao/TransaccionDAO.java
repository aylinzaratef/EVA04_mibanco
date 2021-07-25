package cl.inacap.aylinzarate.dao;

import cl.inacap.aylinzarate.models.Cuenta;
import cl.inacap.aylinzarate.models.Movimientos;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 *
 * @author Aylin
 */
public class TransaccionDAO implements TransaccionInterfaceDAO{
    
    @PersistenceContext(unitName = "MIBANCO_PU")
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRED)
    public boolean insertMovimiento(Movimientos movimiento) {
        try {
            em.persist(movimiento);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public boolean updateCuentaDeposito(Cuenta cuenta) {
        
        boolean r = true;
        
        try {
            Query query = em.createQuery("UPDATE Cuenta c "
                + "SET c.saldo = c.saldo - :saldo, "
                + "c.saldolineacredito = :saldoCredito, "
                + "c.saldolineacreditousado = :saldoCreditoUsado "
                + "where c.numerocta = :numerocta ");
            query.setParameter("saldo", cuenta.getSaldo());
            query.setParameter("saldoCredito", cuenta.getSaldolineacredito());
            query.setParameter("saldoCreditoUsado", cuenta.getSaldolineacreditousado());
            query.setParameter("numerocta", cuenta.getNumerocta());

            query.executeUpdate();
        } catch (Exception e) {
            r = true;
        }
        
        return r;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public boolean updateCuentaDestino(Cuenta cuenta) {
        boolean r = true;
        System.out.println(cuenta);
        try {
            Query query = em.createQuery("UPDATE Cuenta c "
                + "SET c.saldo = c.saldo + :saldo "
                + "WHERE c.numerocta = :numerocta ");
            query.setParameter("saldo", cuenta.getSaldo());
            query.setParameter("numerocta", cuenta.getNumerocta());

            query.executeUpdate();
        } catch (Exception e) {
            r = true;
        }
        
        return r;
    }

    @Override
    public List<Cuenta> findCuenta(int numeroCuenta) {
        return em.createNamedQuery("Cuenta.findByNumerocta").setParameter("numerocta", numeroCuenta).getResultList();
    }
    
    
}
