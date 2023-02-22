package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasLineales.ListaEstaticaOrdenada;
import utilerias.comunes.TipoOrden;

public class PruebaListaEstaticaOrdenada {
    public static void main(String[] args) {
        SalidaPorDefecto.terminal("probando el metod de agregar: \n");
        ListaEstaticaOrdenada listaOrdenada = new ListaEstaticaOrdenada(10, TipoOrden.INC);
        listaOrdenada.agregar(4);
        listaOrdenada.agregar(10);
        listaOrdenada.agregar(1);
        listaOrdenada.agregar(7);
        listaOrdenada.imprimirOI();

        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Eliminando el numero 4: \n");
        listaOrdenada.eliminar((Integer) 4);
        listaOrdenada.imprimirOI();

        SalidaPorDefecto.terminal("\n");

        SalidaPorDefecto.terminal("Cambiar el 7 por el 11: \n");
        listaOrdenada.cambiar(7,11, 1);
        listaOrdenada.imprimirOI();

        SalidaPorDefecto.terminal("\n\n");

        SalidaPorDefecto.terminal("Agregar la lista [1,3,5,0,11]\n");
        ListaEstatica listaEstaticaAgregar = new ListaEstatica(10);
        listaEstaticaAgregar.agregar(1);
        listaEstaticaAgregar.agregar(3);
        listaEstaticaAgregar.agregar(5);
        listaEstaticaAgregar.agregar(0);
        listaEstaticaAgregar.agregar(11);
        listaOrdenada.agregarLista(listaEstaticaAgregar);
        listaOrdenada.imprimirOI();

        SalidaPorDefecto.terminal("\n");
        listaOrdenada.invertir();
        listaOrdenada.imprimirOI();

// rellenar
          SalidaPorDefecto.terminal("Desordenar lista:\n");
          ListaEstatica listaDesordenada = (ListaEstatica) listaOrdenada.arregloDesordenado();
          listaDesordenada.imprimirOI();

        SalidaPorDefecto.terminal( "\n");
          listaOrdenada.imprimirOI();

          ListaEstaticaOrdenada sublista = new ListaEstaticaOrdenada(2,TipoOrden.DEC);
          sublista.agregar(10);
          sublista.agregar(11);
          SalidaPorDefecto.terminal( "[10,11,5] es sublista: "  + listaOrdenada.esSublista(sublista));

         SalidaPorDefecto.terminal( "\n");
         listaOrdenada.imprimirOI();
         SalidaPorDefecto.terminal("Cambiar lista lista2 = [1,5,7], nuevos = [9,10,2)\n");
         ListaEstatica cambiarLista = new ListaEstatica(3);
         ListaEstatica cambiarListaNuevos = new ListaEstatica(3);
         cambiarLista.agregar(1);
         cambiarLista.agregar(5);
         cambiarLista.agregar(7);

         cambiarListaNuevos.agregar(9);
         cambiarListaNuevos.agregar(10);
         cambiarListaNuevos.agregar(2);
         listaOrdenada.cambiarLista(cambiarLista,cambiarListaNuevos);
         listaOrdenada.imprimirOI();

         SalidaPorDefecto.terminal( "Retener lista [11, 9, 0]\n");
         ListaEstatica retenerLista = new ListaEstatica(3);
         retenerLista.agregar(11);
         retenerLista.agregar(9);
         retenerLista.agregar(1);
         listaOrdenada.retenerLista(retenerLista);
         listaOrdenada.imprimirOI();

         SalidaPorDefecto.terminal( "Insertar 8: \n");
         listaOrdenada.insertar(0,8);
         listaOrdenada.imprimirOI();

         SalidaPorDefecto.terminal("Copiar lista [1,6]:\n");
         ListaEstaticaOrdenada copiarLista = new ListaEstaticaOrdenada(2,TipoOrden.DEC);
         copiarLista.agregar(1);
         copiarLista.agregar(6);
         listaOrdenada.copiarLista(copiarLista);
         listaOrdenada.imprimirOI();

    }
}
