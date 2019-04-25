package Tests;

import static org.junit.Assert.assertTrue;


class TestFile {

    @org.junit.jupiter.api.Test
    public void testExisteLineal() {
        assertTrue(inicializar(Clases.BusquedaLineal.conseguirInstancia()).existe(1));
    }

    @org.junit.jupiter.api.Test
    public void testExisteBinario() {
        assertTrue(inicializar(Clases.BusquedaBinaria.conseguirInstancia()).existe(1));
    }

    private Clases.ListaNumeros inicializar(Clases.AlgoritmoBusqueda algoritmo) {
        return new Clases.ListaNumeros(new int[] {1, 2, 3}, algoritmo);
    }
}