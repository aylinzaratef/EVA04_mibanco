package cl.inacap.aylinzarate.web;

import cl.inacap.aylinzarate.controllers.loginInterface;
import cl.inacap.aylinzarate.controllers.transaccionInterface;
import cl.inacap.aylinzarate.models.Cliente;
import cl.inacap.aylinzarate.models.Cuenta;
import cl.inacap.aylinzarate.models.Movimientos;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Aylin
 */
@WebServlet(name = "TransferirMonto", urlPatterns = {"/TransferirMonto"})
public class TransferirMonto extends HttpServlet {

    @Inject
    transaccionInterface transaccionController;
    @Inject
    loginInterface loginController;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cliente cliente_login = (Cliente) session.getAttribute("cliente");
        Cliente cliente = loginController.login(cliente_login).get(0);

        Cuenta cuenta = cliente.getCuentaList().get(0);
        request.setAttribute("cliente", cliente);
        request.setAttribute("cuenta", cuenta);

        request.getRequestDispatcher("/TransferirMonto.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Cliente cliente = (Cliente) session.getAttribute("cliente");
        List<Cuenta> cuenta_cliente = transaccionController.obtenerCuenta(cliente.getCuentaList().get(0).getNumerocta());
        Cuenta cuenta = cuenta_cliente.get(0);
        Cuenta cuenta_destino = new Cuenta();

        List<String> errores = new ArrayList<>();
        Date fechaActual = new Date();

        int cuentaDestino = 0;
        String cuentaDestinoBuscar = request.getParameter("destino-txt").trim();
        if (cuentaDestinoBuscar.isEmpty()) {
            errores.add("Debe ingresar N° Cuenta del destinatario.");
        } else {
            try {
                cuentaDestino = Integer.parseInt(cuentaDestinoBuscar);
                List<Cuenta> lista_cuenta_destino = transaccionController.obtenerCuenta(cuentaDestino);
                if (lista_cuenta_destino.size() > 0) {
                    cuenta_destino = lista_cuenta_destino.get(0);
                } else {
                    cuenta_destino = new Cuenta();
                    errores.add("N° Cuenta del destinatario inexistente.");
                }

            } catch (Exception e) {
                errores.add("el formato de Nº Cuenta del destinatario es incorrecto.");
            }
        }

        String monto = request.getParameter("monto-txt").trim();
        if (monto.isEmpty()) {
            errores.add("Debe ingresar un Monto.");
        }

        String clave = request.getParameter("clave-txt").trim();
        if (clave.isEmpty()) { // || clave != cliente.getClave()
            errores.add("La Clave ingresada no es válida.");
        } else {
            String claveEncriptada = "";
            try {
                byte[] bytes = MessageDigest.getInstance("MD5").digest(clave.getBytes("UTF-8"));
                claveEncriptada = DatatypeConverter.printHexBinary(bytes).toUpperCase();

                if (!claveEncriptada.equals(cliente.getClave().toUpperCase())) {
                    errores.add("Contraseña Incorrecta");
                    
                }
                
                System.out.println(claveEncriptada);
                System.out.println(cliente.getClave());
            } catch (Exception ex) {
                errores.add("Fallo total del sistema");

            }

        }

        if (errores.isEmpty()) {

            String descripcion_deposito = "depósito por " + monto;
            String descripcion_destino = "recibió un depósito de " + monto;

            Movimientos movimiento_deposito = new Movimientos();
            movimiento_deposito.setCuenta(cuenta);
            movimiento_deposito.setDescripcion(descripcion_deposito);
            movimiento_deposito.setFecha(fechaActual);

            Movimientos movimiento_recibe = new Movimientos();
            movimiento_recibe.setCuenta(cuenta_destino);
            movimiento_recibe.setDescripcion(descripcion_destino);
            movimiento_recibe.setFecha(fechaActual);

            int montoValor = 0;
            int montoValorDestino = 0;
            int lineaCredito = 0;
            int lineaCreditoUsado = 0;

            try {

                montoValor = Integer.parseInt(monto);
                montoValorDestino = montoValor;

                if (montoValor > cuenta.getSaldo()) {
                    lineaCredito = (cuenta.getSaldolineacredito()) - (montoValor - cuenta.getSaldo());
                    lineaCreditoUsado = (cuenta.getSaldolineacreditousado()) + (montoValor - cuenta.getSaldo());
                    montoValor = cuenta.getSaldo();
                    if (lineaCredito < 0) {
                        errores.add("Error al tranferir no posee monto suficiente.");
                    }
                } else {
                    lineaCredito = cuenta.getSaldolineacredito();
                    lineaCreditoUsado = cuenta.getSaldolineacreditousado();
                }

                if (errores.isEmpty()) {
                    if (transaccionController.transferencia(movimiento_deposito) && transaccionController.transferencia(movimiento_recibe)) {
                        Cuenta cuenta_deposito = new Cuenta();
                        cuenta_deposito.setNumerocta(cuenta.getNumerocta());
                        cuenta_deposito.setSaldo(montoValor);
                        cuenta_deposito.setSaldolineacredito(lineaCredito);
                        cuenta_deposito.setSaldolineacreditousado(lineaCreditoUsado);
                        transaccionController.actualizarCuentaDeposito(cuenta_deposito);

                        cuenta_destino.setNumerocta(cuentaDestino);
                        cuenta_destino.setSaldo(montoValorDestino);
                        transaccionController.actualizarCuentaDestino(cuenta_destino);

                    } else {
                        errores.add("Error al tranferir.");
                    }
                }
            } catch (Exception e) {
                errores.add("Error al tranferir.");
            }

        } else {
            request.setAttribute("errores", errores);
        }

        if (!errores.isEmpty()) {
            request.setAttribute("errores", errores);
        }else{
            request.setAttribute("mensaje", "Transferencia Exitosa.");
        }
        
        doGet(request, response);

    }

}
