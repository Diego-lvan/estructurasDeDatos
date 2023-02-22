package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class PruebaListaEstatica {
    public static void main(String[] args) {
        ListaEstatica lista = new ListaEstatica(5);
        // pruebas agregar
        lista.agregar("A");
        lista.agregar("B");
        lista.agregar("C");
        lista.agregar("D");
        lista.agregar("E");
        lista.agregar("F");
        lista.imprimirOI();
        SalidaPorDefecto.terminal("\n");
        // pruebas buscar
        SalidaPorDefecto.terminal("Buscando a A: " + lista.buscar("A") + "\n");
        SalidaPorDefecto.terminal("Buscando a Z: " + lista.buscar("Z") + "\n");
        // pruebas eliminar
        SalidaPorDefecto.terminal("Eliminando a D: " +  lista.eliminar("D") + "\n");
        lista.imprimirOI();

        SalidaPorDefecto.terminal("Eliminando a Z: " + lista.eliminar("Z") + "\n");
        lista.imprimirOI();

        // pruebas obtener
        SalidaPorDefecto.terminal("Obteniendo el elemento en la primer posicion: " + lista.obtener(0)  + "\n");
        SalidaPorDefecto.terminal("Obteniendo el elemento en posicion invalida: " + lista.obtener(10) + "\n");

        // pruebas cambiar
        lista.cambiar(0, "Z");
        SalidaPorDefecto.terminal("Cambiando el primer elemento por una Z: " + "\n");
        lista.imprimirOI();

        // cambiarListaEstatica
        ListaEstatica indices = new ListaEstatica(2);
        indices.agregar(0);
        indices.agregar(3);
        ListaEstatica nuevoValores = new ListaEstatica(2);
        nuevoValores.agregar("D");
        nuevoValores.agregar("F");
        SalidaPorDefecto.terminal("Cambiando los indices 0 y 3 por D y F : " +  "\n");
        lista.cambiarListaEstatica(indices,nuevoValores);
        lista.imprimirOI();

        // cambiarListaEstatica
        ListaEstatica indices2 = new ListaEstatica(2);
        indices2.agregar(5);
        indices2.agregar(0);
        ListaEstatica nuevoValores2 = new ListaEstatica(2);
        nuevoValores2.agregar("D");
        nuevoValores2.agregar("F");
        SalidaPorDefecto.terminal("Cambiando lista estatica valores invalidos : " +   lista.cambiarListaEstatica(indices2,nuevoValores2) +   "\n");


        // eliminar por un indice especifico
        lista.imprimirOI();
        SalidaPorDefecto.terminal("Eliminando elemento en el indice 2: " + lista.eliminar(2) +  "\n");
        lista.imprimirOI();

        // redimensionar lista
        SalidaPorDefecto.terminal("Redimensionar array a 10: " + lista.redimensionar(10) + "\n");
        SalidaPorDefecto.terminal("El maximo tamaño es :" + lista.getMAXIMO() + "\n");
        lista.imprimirOI();

        // comparar si dos listas son iguales
        ListaEstatica listaIgual1 = new ListaEstatica(2);
        ListaEstatica listaIgual2 = new ListaEstatica(2);
        listaIgual1.agregar(1);
        listaIgual1.agregar(2);
        listaIgual2.agregar(1);
        listaIgual2.agregar(2);

        SalidaPorDefecto.terminal("Compara dos listas que son iguales: " + listaIgual1.esIgual(listaIgual2) + "\n");

        // comparar si dos listas son diferentes
        ListaEstatica listaDiff1 = new ListaEstatica(2);
        ListaEstatica listaDiff2 = new ListaEstatica(2);
        listaDiff1.agregar(2);
        listaDiff1.agregar(2);
        listaDiff2.agregar(1);
        listaDiff2.agregar(2);

        SalidaPorDefecto.terminal("Compara dos listas que no son iguales: " + listaDiff1.esIgual(listaDiff2) + "\n");

        // cambiar un objeto por otro objeto un cierto numero de veces
        ListaEstatica lista3 = new ListaEstatica(5);
        lista3.agregar(1);
        lista3.agregar(2);
        lista3.agregar(2);
        lista3.agregar(2);
        lista3.agregar(3);
        lista3.imprimirOI();
        SalidaPorDefecto.terminal("Sustutir el numero 2 dos veces por el numero 5: " + lista3.cambiar(2,5,2) + "\n");
        lista3.imprimirOI();

        SalidaPorDefecto.terminal("Buscar las veces que aparece el 5 e imprimir los indices: " + "\n");
        ListaEstatica listaIndices = lista3.buscarValores(5);
        listaIndices.imprimirOI();

        // agregar lista
        ListaEstatica agregarLista1 = new ListaEstatica(5);
        agregarLista1.agregar(1);
        agregarLista1.agregar(2);
        agregarLista1.agregar(3);
        ListaEstatica agregarLista2 = new ListaEstatica(5);
        agregarLista2.agregar(4);
        agregarLista2.agregar(5);
        agregarLista2.agregar(6);
        agregarLista2.agregar(7);
        agregarLista2.agregar(8);

        SalidaPorDefecto.terminal("Agregar lista en el caso que se necesita redimensionar" + "\n");
        agregarLista1.agregarLista(agregarLista2);
        agregarLista1.imprimirOI();

        ListaEstatica invertirLista = agregarLista1;
        SalidaPorDefecto.terminal("Invertir lista " + "\n");
        invertirLista.invertir();
        invertirLista.imprimirOI();


        // contar numero de elementos en una lista
        ListaEstatica contarNumEle = new ListaEstatica(5);
        contarNumEle.agregar(4);
        contarNumEle.agregar(4);
        contarNumEle.agregar(6);
        contarNumEle.agregar(7);
        contarNumEle.agregar(8);
        SalidaPorDefecto.terminal("\n");
        contarNumEle.imprimirOI();
        SalidaPorDefecto.terminal("Contar las veces que aparece el 4 en la lista: " + contarNumEle.contar(4) + "\n");
        SalidaPorDefecto.terminal("Contar las veces que aparece el 10 en la lista: " + contarNumEle.contar(10) + "\n");

        SalidaPorDefecto.terminal("Pruebas eliminar lista" + "\n");
        ListaEstatica eliminarLista1 = new ListaEstatica(5);
        eliminarLista1.agregar(1);
        eliminarLista1.agregar(1);
        eliminarLista1.agregar(2);
        eliminarLista1.agregar(3);
        eliminarLista1.agregar(4);
        SalidaPorDefecto.terminal("Lista inicial: " + "\n");
        eliminarLista1.imprimirOI();
        SalidaPorDefecto.terminal("Lista a eliminar: " + "\n");
        ListaEstatica eliminarLista2 = new ListaEstatica(3);
        eliminarLista2.agregar(1);
        eliminarLista2.agregar(3);
        eliminarLista2.agregar(5);
        eliminarLista2.imprimirOI();
        SalidaPorDefecto.terminal("Resultado despues de eliminar: " + "\n");
        eliminarLista1.eliminarLista(eliminarLista2);
        eliminarLista1.imprimirOI();

        // pruebas para rellenar una lista
        ListaEstatica rellenarLista = new ListaEstatica(5);
        rellenarLista.agregar(1);
        SalidaPorDefecto.terminal("Prubas rellenar lista " + "\n");
        SalidaPorDefecto.terminal("Lista antes de rellenar (contiene un elemento pero su maximo es 5) " + "\n");
        rellenarLista.imprimirOI();
        rellenarLista.rellenar(10,2);
        SalidaPorDefecto.terminal("Lista después de rellenar dos elementos con 10 " + "\n");
        rellenarLista.imprimirOI();

        // clonar una lista estatica
        SalidaPorDefecto.terminal("Lista a clonar" + "\n");
        ListaEstatica listaClonar = rellenarLista;
        listaClonar.imprimirOI();
        SalidaPorDefecto.terminal("Lista clonada" + "\n");
        ListaEstatica listaClonada = (ListaEstatica) listaClonar.clonar();
        listaClonada.imprimirOI();

        // pruebas sublista
        ListaEstatica listaOriginal = new ListaEstatica(5);
        listaOriginal.agregar(1);
        listaOriginal.agregar(2);
        listaOriginal.agregar(3);
        listaOriginal.agregar(4);
        listaOriginal.agregar(5);
        SalidaPorDefecto.terminal("Pruebas sublista" + "\n");
        SalidaPorDefecto.terminal("Lista original" + "\n");
        listaOriginal.imprimirOI();
        SalidaPorDefecto.terminal("Sublista creada del indice 1 al 3" + "\n");
        ListaEstatica sublista = (ListaEstatica) listaOriginal.sublista(1,3);
        sublista.imprimirOI();

        // insertar
        SalidaPorDefecto.terminal("Insertar el 9 en la posicion 0\n");
        sublista.insertar(0,9);
        sublista.agregar(1);
        sublista.imprimirOI();

        // copiar lista
        ListaEstatica copia = new ListaEstatica(3);
        copia.agregar(1);
        copia.agregar(2);
        copia.agregar(3);

        SalidaPorDefecto.terminal( "Copiar lista [1,2,3] \n");
        sublista.copiarLista(copia);
        sublista.imprimirOI();



    }
}
