package cl.inacap.aylinzarate.dao;

import cl.inacap.aylinzarate.models.Cuenta;
import cl.inacap.aylinzarate.models.Movimientos;
import java.util.List;

/**
 *
 * @author Aylin
 */
public interface TransaccionInterfaceDAO {
    public List<Cuenta> findCuenta(int numeroCuenta);
    public boolean insertMovimiento(Movimientos movimiento);
    public boolean updateCuentaDeposito(Cuenta cuenta);
    public boolean updateCuentaDestino(Cuenta cuenta);
}
