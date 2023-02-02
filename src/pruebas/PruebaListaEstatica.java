package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class PruebaListaEstatica {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        lista.agregar("A");
        lista.agregar("B");
        lista.agregar("C");
        lista.agregar("D");
        lista.agregar("E");
        lista.agregar("F");
        lista.imprimirOI();
        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Buscando a A: " + lista.buscar("A") + "\n");
        SalidaPorDefecto.terminal("Buscando a Z: " + lista.buscar("Z") + "\n");

        SalidaPorDefecto.terminal("Eliminando a D: " +  lista.eliminar("D") + "\n");
        lista.imprimirOI();

        SalidaPorDefecto.terminal("Eliminando a Z: " + lista.eliminar("Z") + "\n");
        lista.imprimirOI();
    }
}
