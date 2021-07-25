package cl.inacap.aylinzarate.controllers;

import cl.inacap.aylinzarate.dao.TransaccionInterfaceDAO;
import cl.inacap.aylinzarate.models.Cuenta;
import cl.inacap.aylinzarate.models.Movimientos;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author Aylin
 */
public class transaccionController implements transaccionInterface{

    @Inject
    private TransaccionInterfaceDAO transaccionDAO;
    
    @Override
    public boolean transferencia(Movimientos movimiento) {
        return transaccionDAO.insertMovimiento(movimiento);
    }

    @Override
    public boolean actualizarCuentaDeposito(Cuenta cuenta) {
        return transaccionDAO.updateCuentaDeposito(cuenta);
    }

    @Override
    public boolean actualizarCuentaDestino(Cuenta cuenta) {
        return transaccionDAO.updateCuentaDestino(cuenta);
    }

    @Override
    public List<Cuenta> obtenerCuenta(int numeroCuenta) {
        return transaccionDAO.findCuenta(numeroCuenta);
    }

  

  
}
