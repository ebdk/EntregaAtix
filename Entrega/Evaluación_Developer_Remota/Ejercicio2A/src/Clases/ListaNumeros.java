package Clases;

public class ListaNumeros {

    private int[] numeros;
    private AlgoritmoBusqueda algoritmoBusqueda;

    public ListaNumeros(int[] numeros, AlgoritmoBusqueda algoritmoBusqueda) {
        this.numeros = numeros;
        this.algoritmoBusqueda = algoritmoBusqueda;
    }

    public int[] getNumeros() {
        return numeros;
    }

    public boolean existe(int numero) {
        return algoritmoBusqueda.existe(this.getNumeros(), numero);
    }

}
