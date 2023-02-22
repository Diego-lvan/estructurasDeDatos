package estructurasLineales;

public interface VectorLista extends Lista {
    public boolean llena();

    /**
     * Regresa el objeto en la posición indicada.
     * @param indice Indica la posicion del elemento a obtener.
     * @return Retorna el elemento en la posición indicada, si no se encuentra en un rango valido regresa null
     */
    public Object obtener(int indice);

    /**
     * Reemplaza el elemento en la posicion que indica "indice" por "info".
     * @param indice Indica la posición que se va a cambiar.
     * @param info Indica el nuevo valor que tendra el elemento.
     * @return Regresa <b>true</b> si se pudo realizar la operacion y <b>false</b> si no se pudo.
     */
    public  boolean cambiar(int indice, Object info);

    /**
     * Actualiza los elementos de la lista actual en las posiciones de "indicesBusqueda" por los valores en "infosNuevos".
     * No se podra realizar la operacion si se dan dimensiones o indices invalidos.
     * @param indicesBusqueda Una lista estatica que contiene los indices a modificar.
     * @param infosNuevos Una lista estatica que contiene los nuevso valores de los elementos.
     * @return Regresa true si se pudo realizar la operacion.
     */
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica infosNuevos);

    /**
     * Elimina un elemento del vector lista en la posicion indicada por "indice".
     * @param indice La posicion del elemento a eliminar.
     * @return Regresa el valor del elemento eliminado.
     */
    public  Object eliminar(int indice);

    /**
     * Redimensiona el tamaño de la lista al nuevo tamaño indicado por "maximo".
     * @param maximo Indica el nuveo tamaño de la lista.
     * @return Regresa <b>true</b> si se pudo realizar la operacion y <b>false</b> si no se pudo.
     */
    public boolean redimensionar(int maximo);

    /**
     *
     * @return Regresa el tamanio maximo que puede tener la lista.
     */
    public  int maximo();

    /**
     *
     * @return Regresa la cantidad de elementos que contiene la lista.
     */
    public  int cantidad();
}
