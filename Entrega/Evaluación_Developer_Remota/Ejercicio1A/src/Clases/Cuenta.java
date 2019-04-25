package Clases;

public class Cuenta {

    private TipoCuenta tipo;
    private long numeroCuenta ;
    private String titular ;
    private long saldo ;
    private long descubiertoAcordado ;

    public Cuenta(long nCuenta , String titular , long descAcordado) {
        this . tipo = CuentaCorriente.conseguirInstancia() ;
        this . numeroCuenta = nCuenta ;
        this . titular = titular ;
        this . descubiertoAcordado = descAcordado ;
        saldo = 0 ;
    }

    public Cuenta(long numeroCuenta, String titular) {
        this . tipo = CajaAhorro.conseguirInstancia();
        this . numeroCuenta = numeroCuenta ;
        this . titular = titular ;
        this . descubiertoAcordado = 0 ;
        saldo = 0 ;
    }

    public void depositar ( long monto ) {
        saldo += monto ;
    }

    public synchronized void extraer(long monto) {
        tipo.extraer(this, monto);
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }

    public long getDescubiertoAcordado() {
        return descubiertoAcordado;
    }
}