package Excepciones;

public class DineroInsuficienteException extends RuntimeException {

    public static DineroInsuficienteException insuficiente(long monto, long nroCuenta) {
        throw new DineroInsuficienteException("No hay dinero suficiente para extraer [%] de la cuenta [%]", monto, nroCuenta);
    }

    private DineroInsuficienteException(String msg, Object... args) {
        super(String.format(msg, args));
    }

}
