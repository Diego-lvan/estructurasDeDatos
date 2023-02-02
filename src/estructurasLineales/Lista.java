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
}
