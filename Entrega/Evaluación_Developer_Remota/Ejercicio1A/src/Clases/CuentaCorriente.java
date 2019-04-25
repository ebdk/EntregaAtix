package Clases;

import Excepciones.DineroInsuficienteException;

import static Excepciones.DineroInsuficienteException.insuficiente;

public class CuentaCorriente implements TipoCuenta {

    private static CuentaCorriente instancia = null;

    private CuentaCorriente() {
    }

    public synchronized static CuentaCorriente conseguirInstancia()
    {
        if (instancia == null)
            instancia = new CuentaCorriente();

        return instancia;
    }

    @Override
    public void extraer(Cuenta cuenta, long monto) throws DineroInsuficienteException {
        if ( monto > cuenta.getSaldo() + cuenta.getDescubiertoAcordado())
            insuficiente(monto, cuenta.getNumeroCuenta());
        cuenta.setSaldo(cuenta.getSaldo() - monto);
    }
}
