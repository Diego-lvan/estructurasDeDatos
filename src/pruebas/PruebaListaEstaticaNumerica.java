package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaNumerica;
import estructurasLineales.ListaEstaticaOrdenada;

public class PruebaListaEstaticaNumerica {

    public static void main(String[] args) {
        // multiplicar por escalar
        SalidaPorDefecto.terminal( "Agregar elementos\n");
        ListaEstaticaNumerica listaNumerica = new ListaEstaticaNumerica(7);
        listaNumerica.agregar(1);
        listaNumerica.agregar(2);
        listaNumerica.agregar(3);
        listaNumerica.agregar(4);
        listaNumerica.agregar(5);
        listaNumerica.agregar("asdf");
        listaNumerica.imprimirOI();
        SalidaPorDefecto.terminal( "Multiplicar por escalar\n");
        listaNumerica.porEscalar(2);
        listaNumerica.imprimirOI();

        // sumar escalar
        SalidaPorDefecto.terminal( "Sumar 3 al arreglo\n");
        listaNumerica.sumarEscalar(3);
        listaNumerica.imprimirOI();

        // sumar lista estatica
        ListaEstaticaNumerica listaSumar = new ListaEstaticaNumerica(5);
        listaSumar.agregar(10);
        listaSumar.agregar(10);
        listaSumar.agregar(10);
        listaSumar.agregar(10);
        listaSumar.agregar(10);
        SalidaPorDefecto.terminal( "Sumar lista [10,10,10,10,10]\n");
        listaNumerica.sumar(listaSumar);
        listaNumerica.imprimirOI();

        // multiplicar por lista
        ListaEstaticaNumerica listaMultiplicar = new ListaEstaticaNumerica(5);
        listaMultiplicar.agregar(2);
        listaMultiplicar.agregar(2);
        listaMultiplicar.agregar(1);
        listaMultiplicar.agregar(1);
        listaMultiplicar.agregar(1);

        SalidaPorDefecto.terminal( "Multiplicar por lista [2,2,1,1,1]\n");
        listaNumerica.multiplicar(listaMultiplicar);
        listaNumerica.imprimirOI();


        // aplicar potencia a la lista

        SalidaPorDefecto.terminal( "Exponer por la 2 la lista:\n");
        listaNumerica.aplicarPotencia(2);
        listaNumerica.imprimirOI();


        // aplicar potencia a una lista
        SalidaPorDefecto.terminal("Elevar elementos con la siguiente lista [1,2,1,1,1]\n");
        ListaEstaticaNumerica listaPotencia = new ListaEstaticaNumerica(5);
        listaPotencia.agregar(1);
        listaPotencia.agregar(2);
        listaPotencia.agregar(1);
        listaPotencia.agregar(1);
        listaPotencia.agregar(1);
        listaNumerica.aplicarPotencia(listaPotencia);
        listaNumerica.imprimirOI();



        // obtener producto escalar
        SalidaPorDefecto.terminal("Obtener el producto escalar con la siguiente lista [1,2,1,1,1]:");
        ListaEstaticaNumerica listaEscalar = new ListaEstaticaNumerica(5);
        listaEscalar.agregar(1);
        listaEscalar.agregar(2);
        listaEscalar.agregar(1);
        listaEscalar.agregar(1);
        listaEscalar.agregar(1);
       SalidaPorDefecto.terminal( "" + listaNumerica.productoEscalar(listaEscalar) + "\n");

       SalidaPorDefecto.terminal( "La norma del vector es: " + listaNumerica.norma() + "\n");


       //norma euclidiana
        ListaEstaticaNumerica normaEuclidiana = new ListaEstaticaNumerica(5);
        normaEuclidiana.agregar(3);
        normaEuclidiana.agregar(2);
        normaEuclidiana.agregar(4);
        normaEuclidiana.agregar(1);
        normaEuclidiana.agregar(2);


        listaNumerica.imprimirOI();
       SalidaPorDefecto.terminal( "La norma euclidiana con el vector [3,2,4,1,2] :");
       SalidaPorDefecto.terminal( "" + listaNumerica.normaEuclidiana(normaEuclidiana) +"\n");

        SalidaPorDefecto.terminal( "Sumar las listas  estatica\n");
        ListaEstaticaNumerica sumaLista1 = new ListaEstaticaNumerica(1);
        ListaEstaticaNumerica sumaLista2 = new ListaEstaticaNumerica(1);
        ListaEstaticaNumerica sumaLista3 = new ListaEstaticaNumerica(2);
        sumaLista1.agregar(1); sumaLista2.agregar(2);
        sumaLista3.agregar(1); sumaLista3.agregar(2);
        ListaEstatica sumarListas = new ListaEstatica(2);
        sumarListas.agregar(sumaLista1);
        sumarListas.agregar(sumaLista2);

        SalidaPorDefecto.terminal( "La sumatoria de las listas [1] [2]  a la lista [1,2] es: " + sumaLista3.sumarListaEstatica(sumarListas) + "\n");


        // sumar escalares
        SalidaPorDefecto.terminal( "Prueba Sumar escalares\n");
        ListaEstaticaNumerica sumarEscalar = new ListaEstaticaNumerica(2);
        sumarEscalar.agregar(1);
        sumarEscalar.agregar(5);


        SalidaPorDefecto.terminal( "La sumatoria de la lista escalar [1,5] con la lista actual [1,2] es: " + sumaLista3.sumarEscalares(sumarEscalar) + "\n");


       // sumar indices
        listaNumerica.imprimirOI();
        ListaEstaticaNumerica sumarIndices = new ListaEstaticaNumerica(3);
        sumarIndices.agregar(1);
        sumarIndices.agregar(2);
        sumarIndices.agregar(0);
        SalidaPorDefecto.terminal( "Prueba Sumar indices\n");
        SalidaPorDefecto.terminal( "Sumar los indices [1,2,0]:" + listaNumerica.sumarIndices(sumarIndices) + "\n");

        // son linealmente dependientes
        ListaEstatica listaVectores = new ListaEstatica(3);
        ListaEstaticaNumerica vector1 = new ListaEstaticaNumerica(3);
        ListaEstaticaNumerica vector2 = new ListaEstaticaNumerica(3);
        ListaEstaticaNumerica vector3 = new ListaEstaticaNumerica(3);
        vector1.agregar(1);
        vector1.agregar(2);
        vector1.agregar(3);
        vector2.agregar(2);
        vector2.agregar(4);
        vector2.agregar(6);
        vector3.agregar(3);
        vector3.agregar(5);
        vector3.agregar(8);
        listaVectores.agregar(vector1);
        listaVectores.agregar(vector2);
        listaVectores.agregar(vector3);
        SalidaPorDefecto.terminal( "Pruba linealmente dependientes\n");
        SalidaPorDefecto.terminal( "Los vectores  (1, 2, 3) (2, 4, 6) (3, 5, 8) son dependientes:  " + ListaEstaticaNumerica.sonLinealmenteDependientes(listaVectores) + "\n");
        vector1.vaciar();
        vector2.vaciar();
        vector3.vaciar();
        vector1.agregar(1);
        vector1.agregar(0);
        vector1.agregar(0);
        vector2.agregar(0);
        vector2.agregar(1);
        vector2.agregar(0);
        vector3.agregar(0);
        vector3.agregar(0);
        vector3.agregar(1);
        SalidaPorDefecto.terminal( "Los vectores  (1, 0, 0) (0, 1, 0) (0, 0, 1) son dependientes:  " + ListaEstaticaNumerica.sonLinealmenteDependientes(listaVectores) + "\n");

        SalidaPorDefecto.terminal( "\nPruba linealmente independientes\n");
        SalidaPorDefecto.terminal( "Los vectores  (1, 0, 0) (0, 1, 0) (0, 0, 1) son independientes:  " + ListaEstaticaNumerica.sonLinealmenteIndependientes(listaVectores) + "\n");



        SalidaPorDefecto.terminal( "Prueba ortogonal");
        ListaEstaticaNumerica ortogonal1 = new ListaEstaticaNumerica(2);
        ListaEstaticaNumerica ortogonal2 = new ListaEstaticaNumerica(2);
        ortogonal1.agregar(1);
        ortogonal1.agregar(0);
        ortogonal2.agregar(0);
        ortogonal2.agregar(1);

        SalidaPorDefecto.terminal( "Los vectores (1,0) (0,1) son ortogonales: " + ortogonal1.esOrtogonal(ortogonal2) + "\n\n");

        SalidaPorDefecto.terminal( "Prueba paralelo\n");
        ListaEstaticaNumerica paralelos1 = new ListaEstaticaNumerica(3);
        ListaEstaticaNumerica paralelos2 = new ListaEstaticaNumerica(3);
        paralelos1.agregar(2);
        paralelos1.agregar(3);
        paralelos1.agregar(4);

        paralelos2.agregar(4);
        paralelos2.agregar(6);
        paralelos2.agregar(8);

        SalidaPorDefecto.terminal( "Los vectores (2,3,4) y (4,6,8) son paralelos: " + paralelos1.esParalelo(paralelos2) + "\n");

    }
}
