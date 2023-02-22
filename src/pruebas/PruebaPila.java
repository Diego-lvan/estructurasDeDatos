package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.PilaEstatica;

public class PruebaPila {
    public static void main(String[] args) {
        PilaEstatica pila = new PilaEstatica(5);
        pila.poner("A");
        pila.poner("B");
        pila.poner("C");
        pila.poner("D");
        pila.poner("E");
        pila.imprimir();


        SalidaPorDefecto.terminal( "Eliminando: " + pila.quitar() + "\n");

        pila.imprimir();

        SalidaPorDefecto.terminal( "Viendo tope: " + pila.verTope() + "\n");
    }
}
