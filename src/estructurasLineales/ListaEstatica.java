package estructurasLineales;

public class ListaEstatica implements VectorLista {
    protected int tope;
    protected int MAXIMO;
    protected Object informacion[];
    protected int VACIO = -1;

    public ListaEstatica(int tamanio) {
        MAXIMO = tamanio;
        informacion = new Object[MAXIMO];
        tope = -1;
    }

    @Override
    public boolean vacia() {
        return tope == VACIO;
    }

    @Override
    public boolean llena() {
        return tope == (MAXIMO - 1);
    }

    @Override
    public int agregar(Object info) {
        if(llena()) return -1;
        tope++;
        informacion[tope] = info;
        return tope;
    }
}
