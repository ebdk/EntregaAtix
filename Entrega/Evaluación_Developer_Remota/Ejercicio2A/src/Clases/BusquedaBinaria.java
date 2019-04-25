package Clases;

public class BusquedaBinaria implements AlgoritmoBusqueda {

    private static BusquedaBinaria instancia = null;

    private BusquedaBinaria() {
    }

    public static BusquedaBinaria conseguirInstancia()
    {
        if (instancia == null)
            instancia = new BusquedaBinaria();

        return instancia;
    }

    @Override
    public boolean existe(int[] numeros, int numero) {

        if (numeros.length == 0) {
            return false;
        }
        int menor = 0;
        int mayor = numeros.length-1;

        while(menor <= mayor ) {
            int middle = (menor + mayor) /2;
            if (numero > numeros[middle] ){
                menor = middle +1;
            } else if (numero < numeros[middle]){
                mayor = middle -1;
            } else {
                return true;
            }
        }
        return false;
    }
}
