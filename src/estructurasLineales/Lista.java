package estructurasLineales;

/**
 * Esta clase contienen los metotods de una TDA Lista.
 * @version 1.0
 * @author Clase ED
 */
public interface Lista {
    /**
     * Este metodo regresa un indicador de si la lista esta vacia.
     * @return Este método regresa <b>true</b> si esta vacio, <b>falso</b> falso en caso contrario.
     */
    public boolean vacia();

    /**
     * Este metodo añade un elemento a la lista.
     * @param info Es el nuevo valor a añadir.
     * @return Regresa la posicion en donde lo agrega o -1 en caso contrario.
     */
    public int agregar(Object info);

    public void imprimir();
    public void imprimirOI();
    public Object buscar(Object info);
    public Object eliminar(Object info);


    /**
     * Indica si la lista es igual a la lista proporcionada.
     * @param lista La lista con la que se comparra.
     * @return Regresa <b>true</b> si las listas son iguales y <b>false</b> en caso contrario.
     */
    public  boolean esIgual(Object lista);

    /**
     * Modifica el elemento viejo por el elemento nuevo haciendo una búsqueda el número de veces indicado
     * por numVeces
     *
     * @param infoViejo El objeto que se desea reemplazar.
     * @param infoNuevo El objeto nuevo que reemplaza al viejo.
     * @param numVeces  El numero de veces a reemplazar los objetos.
     * @return Regresa <b>true</b> si hace alguna modificación, <b>false</b> en caso contrario.
     */
    public default boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        return false;
    }

    /**
     * Busca dentro de la lista el elemento indicado y si encuentra alguno o varios, agrega sus indices en
     * una lista estática que es regresada.
     * @param info Objeto a buscar en la lista.
     * @return Regresa los indices de los elementos encontrados.
     */
    public  ListaEstatica buscarValores(Object info);

    /**
     * Elimina el ultimo elemento de la lista y lo regresa
     * @return Regresa el ultimo elemento de la lista
     */
    public Object eliminar();

    /**
     * Vacia el contenido de la lista
     */
    public void vaciar();

    /**
     * Añade al final de la lista actual, la lista que es pasada como argumento
     * @param lista
     * @return Regresa <b>true</b> si se pudo realizar y <b>false</b> en caso contrario.
     */
    public boolean agregarLista(Object lista);

    /**
     * Invierte el orden de los elementos de la lista.
     */
    public void invertir();

    /**
     * Contar los elementos en la lista iguales al objeto indicado.
     * @param info Objeto con el cual se hacen las comparaciones.
     * @return Regresa el numero de elemento iguales al objeto indicado.
     */
    public int contar(Object info);

    /**
     * Elimina todos los elemtos de la lista2 que se encuentren en la lista actual.
     * @param lista
     * @return Regresa <b>true</b> si se pudo realizar la operacion <b>false</b> en caso contario.
     */
    public boolean eliminarLista(Object lista);

    /**
     * Rellena la lista actual con el objeto indicado el numero de veces indicado por cantidad.
     * @param info Info el elemento con el que se rellena la lista.
     * @param cantidad La cantidad de elementos que se agregan.
     */
    public void rellenar(Object info, int cantidad);

    /**
     * Clona la lista actual.
     * @return Regresa la lista clonada.
     */
    public  Lista clonar();

    /**
     * Crea una sublista con los indices indicados.
     * @param indiceInicial Indice donde inicia la lista de manera inclusiva.
     * @param indiceFinal Indice donde termina la lista de manera inclusiva.
     * @return Regresa una sublista con los indices indicados.
     */
    public Lista sublista(int indiceInicial, int indiceFinal);

    // aqui empieza

    /**
     *
     * @param indice Indice donde se inserta el elemento.
     * @param info Objeto que se inserta.
     * @return Regresa <b>true</b> si se pudo realizar y <b>false</b> si no se pudo.
     */
    public boolean insertar(int indice, Object info);

    /**
     * Copia todos los valores de la lista2 a la lista actual.
     * @param lista2 Lista de la que se copian los elementos.
     * @return Regresa <b>true</b> si se pudo realizar y <b>false</b> si no se pudo.
     */
    public boolean copiarLista(Lista lista2);


    /**
     * Rellena la lista con los con el objeto pasado.
     * @param info Objeto con el que se rellenara la lista.
     */
    public void rellenar(Object info);


    /**
     *
     * @return Regresa el arreglo desordenado.
     */
    public Lista arregloDesordenado();

    /**
     *
     * @param lista2 Lista a comparar.
     * @return Regresa <b>true</b> si lista2 es una sublista de la lista actual y <b>false</b> en caso contrario.
     */
    public boolean esSublista(Lista lista2);

    /**
     * Cambia los elementos de lista2 que se encuentren en la lista
     * actual con los elementos de la lista2Nuevos
     * @param lista2 Lista con los indices a reemplazar.
     * @param lista2Nuevos Lista con los objetos nuevos.
     * @return Regresa true si se pudo realizar y false si no se pudo.
     */

    public boolean cambiarLista(Lista lista2, Lista lista2Nuevos);

    /**
     * Deja en la lista actual solo los elementos que se encuentran en lista2.
     * @param lista2
     * @return Regresa true si se pudo realizar y false si no se pudo.
     */
    public boolean retenerLista(Lista lista2);

    public Object verUltimo();




}
