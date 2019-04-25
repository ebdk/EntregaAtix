package Clases;

import static Excepciones.DineroInsuficienteException.insuficiente;

public class CajaAhorro implements TipoCuenta {

    private static CajaAhorro instancia = null;

    private CajaAhorro() {
    }

    public synchronized static CajaAhorro conseguirInstancia()
    {
        if (instancia == null)
            instancia = new CajaAhorro();

        return instancia;
    }

    @Override
    public void extraer(Cuenta cuenta, long monto) throws Excepciones.DineroInsuficienteException {
        if ( monto > cuenta.getSaldo() )
            insuficiente(monto, cuenta.getNumeroCuenta());
        cuenta.setSaldo(cuenta.getSaldo() - monto);
    }
}
