package estructurasLineales;

import entradasalida.SalidaPorDefecto;

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

    @Override
    public void imprimir() {
        for(int celda = tope; celda >= 0; celda--) {
            SalidaPorDefecto.terminal(informacion[celda] + "\n");
        }
    }

    @Override
    public void imprimirOI() {
        for(int celda = 0; celda <= tope; celda++) {
            SalidaPorDefecto.terminal(informacion[celda] + "\n");
        }
    }

    @Override
    public Object buscar(Object info) {
        int pos = 0;
        while(pos <= tope && !info.toString().equalsIgnoreCase(informacion[pos].toString())) {
            pos++;
        }
        if(pos > tope) {
            return -1;
        }
        return pos;
    }

    @Override
    public Object eliminar(Object info) {
        Integer posTarget = (Integer) buscar(info);
        if(posTarget == -1) return null;
        Object eliminado = informacion[posTarget];
        tope--;
        for(int idx = posTarget; idx <= tope; idx++) {
            informacion[idx] = informacion[idx + 1];
        }
        return eliminado;
    }
}
