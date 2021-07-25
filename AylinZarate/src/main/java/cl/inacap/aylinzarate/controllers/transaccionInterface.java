package cl.inacap.aylinzarate.controllers;

import cl.inacap.aylinzarate.models.Cuenta;
import cl.inacap.aylinzarate.models.Movimientos;
import java.util.List;

/**
 *
 * @author Aylin
 */
public interface transaccionInterface {
    public List<Cuenta> obtenerCuenta(int numeroCuenta);
    public boolean transferencia(Movimientos movimiento);
    public boolean actualizarCuentaDeposito(Cuenta cuenta);
    public boolean actualizarCuentaDestino(Cuenta cuenta);

    
}
