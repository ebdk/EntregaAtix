package Clases;

public class BusquedaLineal implements AlgoritmoBusqueda {

    private static BusquedaLineal instancia = null;

    private BusquedaLineal() {
    }

    public static BusquedaLineal conseguirInstancia()
    {
        if (instancia == null)
            instancia = new BusquedaLineal();

        return instancia;
    }

    @Override
    public boolean existe(int[] numeros, int numero) {

        if (numeros.length == 0) {
            return false;
        }

        for (int i : numeros) {
            if (i == numero){
                return true;
            }
        }
        return false;
    }
}
