package Clases;

import Excepciones.DineroInsuficienteException;

public interface TipoCuenta {

    void extraer(Cuenta cuenta, long monto) throws DineroInsuficienteException;

}
