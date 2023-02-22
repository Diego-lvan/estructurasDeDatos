package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasnolineales.Matriz2;
import estructurasnolineales.Matriz3;

public class PruebaMatriz3 {
    public static void main(String [] args) {
        Matriz3 matriz = new Matriz3(4,3,5,0);
        matriz.imprimirXColumnas();

        SalidaPorDefecto.terminal("\n\n");
        matriz.cambiar(2,1,3,9);
        matriz.cambiar(1,2,0,8);
        matriz.cambiar(0,0,0,7);
        matriz.cambiar(3,1,4,4);

        matriz.imprimirXColumnas();

        SalidaPorDefecto.terminal("Listas\n");
        imprimirMatrices(matriz.aMtrices2());
    }

    public static void imprimirMatrices(ListaEstatica matrices) {
        for(int matrizIdx = 0; matrizIdx < matrices.cantidad(); matrizIdx++) {
            Matriz2 matriz2Temporal = (Matriz2) matrices.obtener(matrizIdx);
            matriz2Temporal.imprimirXColumnas();
            SalidaPorDefecto.terminal("\n");
        }
    }
}
