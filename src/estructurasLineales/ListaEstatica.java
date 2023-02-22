package estructurasLineales;

import entradasalida.SalidaPorDefecto;

import javax.management.ObjectName;

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
    public Object obtener(int indice) {
        if(indice > tope || indice < 0) return null;
        return informacion[indice];
    }

    @Override
    public boolean cambiar(int indice, Object info) {
        if(indice > tope || indice < 0) return false;
        informacion[indice] = info;
        return true;
    }

    @Override
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica infosNuevos) {
        if(indicesBusqueda.getTope() != infosNuevos.getTope()) return  false;
        boolean invalid = false;
        for(int it = 0; it <= indicesBusqueda.getTope(); it++) {
            Integer curIdxVal = (Integer) indicesBusqueda.obtener(it);
            if(curIdxVal > tope || curIdxVal < 0) {
                invalid = true;
                break;
            }
        }
        if(invalid) return false;

        for(int it = 0; it <= indicesBusqueda.getTope(); it++) {
            Integer curIdxVal = (Integer) indicesBusqueda.obtener(it);
            informacion[curIdxVal] = infosNuevos.obtener(it);
        }
        return true;
    }

    @Override
    public Object eliminar(int indiceTarget) {
        if(indiceTarget > tope || indiceTarget < 0) return null;
        Object eliminado = obtener(indiceTarget);
        for(int idx = indiceTarget; idx < tope; idx++) {
            informacion[idx] = informacion[idx + 1];
//            cambiar(idx,obtener(idx + 1));
        }
        tope--;
        return eliminado;

    }

    @Override
    public boolean redimensionar(int maximo) {
        if(maximo < 0) return  false;
        Object nuevaInformacion[] = new Object[maximo];
        int idx = 0;
        while(idx <= tope && idx < maximo) {
            nuevaInformacion[idx] = informacion[idx];
            idx++;
        }
        informacion = nuevaInformacion;
        tope = maximo - 1;
        MAXIMO = maximo;
        return true;
    }

    @Override
    public int maximo() {
        return MAXIMO;
    }

    @Override
    public int cantidad() {
        return tope + 1;
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

    @Override
    public boolean esIgual(Object lista2) {
        if((lista2 instanceof ListaEstatica) == false) return false;
        ListaEstatica listaEstatica2 = (ListaEstatica) lista2;
        if(listaEstatica2.getTope() != tope)  {
            return false;
        }
        for(int idx = 0; idx <= tope; idx++) {
            if(this.obtener(idx).toString().equalsIgnoreCase(listaEstatica2.obtener(idx).toString()) == false) {
                return false;
            }
        }
        return true;
    }



    @Override
    public ListaEstatica buscarValores(Object info) {
        int cntNumElementos = contar(info);
        ListaEstatica indicesEncontrados = new ListaEstatica(cntNumElementos);
        int idxInfo = 0;
        while(idxInfo <= tope) {
            if(this.obtener(idxInfo).toString().equalsIgnoreCase(info.toString())) {
                indicesEncontrados.agregar(idxInfo);
            }
            idxInfo++;
        }
        return indicesEncontrados;
    }

    @Override
    public Object eliminar() {
        if(tope == VACIO) return null;
        Object eliminado = this.obtener(tope);
        tope--;
        return eliminado;
    }

    @Override
    public void vaciar() {
        tope = -1;
    }

    @Override
    public boolean agregarLista(Object lista2) {
        if((lista2 instanceof ListaEstatica) == false) return false;
        ListaEstatica listaEstatica2 = (ListaEstatica) lista2;
        int totalElemLista2 = listaEstatica2.getTope() + 1;
        int elemRestantesLista1 = MAXIMO - tope - 1;
        // si no caben los elementos, redimensionamos la lista
        int prevTope = tope;
        if(totalElemLista2 > elemRestantesLista1) {
            redimensionar(MAXIMO + (totalElemLista2 - elemRestantesLista1));
        }
        int idxLista1 = prevTope + 1;
        int idxLista2 = 0;
        while(idxLista1 <= tope) {
            informacion[idxLista1] = listaEstatica2.obtener(idxLista2);
            idxLista1++;
            idxLista2++;
        }
        return true;
    }

    @Override
    public void invertir() {
        int inicio = 0;
        int fin = tope;
        while(inicio < fin) {
            Object finValor = obtener(fin);
            Object inicioValor = obtener(inicio);
            informacion[inicio] = finValor;
            informacion[fin] = inicioValor;
            inicio++;
            fin--;
        }
    }

    @Override
    public int contar(Object info) {
        // TODO: verificar que funciona
        int cnt = 0;
        for(var ele: informacion) {
            if(ele.toString().equalsIgnoreCase(info.toString()) == true) cnt++;
        }
        return cnt;
    }

    @Override
    public boolean eliminarLista(Object lista2) {
        if((lista2 instanceof ListaEstatica) == false) return false;
        ListaEstatica listaEstatica2 = (ListaEstatica) lista2;
        for(int idxLista2 = 0; idxLista2 < listaEstatica2.getTope(); idxLista2++) {
            for(int idxLista1 = 0; idxLista1 < tope; idxLista1++) {
                if(obtener(idxLista1).toString().equalsIgnoreCase(listaEstatica2.obtener(idxLista2).toString()) == true) {
                    eliminar(idxLista1);
                    break;
                }
            }
        }
        return true;
    }

    @Override
    public void rellenar(Object info, int cantidad) {
        int idxLista = tope + 1;
        int prevCantidad = cantidad;
        while(idxLista < MAXIMO && cantidad > 0) {
            agregar(info);
            idxLista++;
            cantidad--;
        }
    }

    @Override
    public Lista clonar() {
        ListaEstatica clon = new ListaEstatica(tope + 1);
        for(var elemento: informacion) {
            clon.agregar(elemento);
        }
        return clon;
    }

    @Override
    public Lista sublista(int indiceInicial, int indiceFinal) {
        if(indiceInicial > indiceFinal) return null;
        if(indiceInicial < 0 || indiceFinal > tope) return null;
        int size = indiceFinal - indiceInicial + 1;
        ListaEstatica sublista = new ListaEstatica(size);
        int idxSublista = 0;
        int idxLista = indiceInicial;
        while(idxSublista < size) {
            sublista.agregar(obtener(idxLista));
            idxLista++;
            idxSublista++;
        }
        return sublista;
    }

    @Override
    public boolean insertar(int indice, Object info) {
        if(indice > tope || indice < 0) return false;
        informacion[indice] = info;
        return true;
    }

    @Override
    public boolean copiarLista(Lista lista2) {
        if((lista2 instanceof ListaEstatica) == false) return false;
        ListaEstatica listaEstatica2 = (ListaEstatica) lista2;
        if(listaEstatica2.getTope() != tope) return false;
        for(int idx = 0; idx <= tope; idx++) {
            informacion[idx] = listaEstatica2.obtener(idx);
        }
        return true;
    }

    @Override
    public void rellenar(Object info) {

    }

    @Override
    public  Lista arregloDesordenado() {
        ListaEstatica desordenada = new ListaEstatica(tope  + 1);
        for(int idx = 0; idx < tope; idx +=2) {
            desordenada.agregar(informacion[idx + 1]) ;
            desordenada.agregar(informacion[idx]);
        }
        return desordenada;
    }

    @Override
    public boolean esSublista(Lista lista2) {
        if((lista2 instanceof ListaEstatica) == false) return false;
        if(lista2.vacia()) return false;
        ListaEstatica listaEstatica2 = (ListaEstatica) lista2;
        Integer idxInicio = (Integer) buscar(listaEstatica2.obtener(0));
        if(idxInicio <  0) return false;
        idxInicio --;
        int idxLista2 = 0;
        for(int idxLista1 = idxInicio; idxLista1 <= tope; idxLista1++) {
            if(obtener(idxLista1).toString().equalsIgnoreCase(listaEstatica2.obtener(idxLista2).toString()) == false) {
                break;
            }
            idxLista2++;
            if(idxLista2 > listaEstatica2.getTope()) return true;
        }
        return false;
    }

    @Override
    public boolean cambiarLista(Lista lista2, Lista lista2Nuevos) {
        ListaEstatica listaEstatica2 = (ListaEstatica) lista2;
        ListaEstatica listaNuevosEstatica2 = (ListaEstatica) lista2Nuevos;
        if(listaEstatica2.getTope() != listaNuevosEstatica2.getTope()) return false;
        for(int idx = 0; idx <= listaEstatica2.getTope(); idx++) {
            Object curEle = listaEstatica2.obtener(idx);
            Object eliminado =  eliminar(curEle);
            if(eliminado != null) {
                Object nuevoEle = listaNuevosEstatica2.obtener(idx);
                agregar(nuevoEle);
            }
        }
        return true;
    }

    @Override
    public boolean retenerLista(Lista lista2) {
        ListaEstatica listaEstatica2 = (ListaEstatica) lista2;
        int idx = 0;
        while(idx <= tope) {
            Object curEle = obtener(idx);
            Integer idxCurEle = (Integer) listaEstatica2.buscar(curEle);
            if(idxCurEle < 0) {
                eliminar(idx);
            } else {
                idx++;
            }
        }

        return true;
    }

    @Override
    public Object verUltimo() {
        return obtener(cantidad() - 1);
    }

    /**
     * Valida que el indice sea un indice valido para la lista.
     * @param indice Indice a validar.
     * @return Regresa true si es un indice valido y false si no.
     */
    public boolean validarIndice(int indice) {
        if(indice < 0 || indice > tope) return false;
        return true;
    }

    /**
     * Crea una sublista del arreglo actual con los indices indicados por listaIndices.
     * @param listaIndices Lista que contiene los indices a agregar.
     * @return Regresa la sublista generada.
     */
    public ListaEstatica subLista(ListaEstaticaNumerica listaIndices) {
        ListaEstatica sublista = new ListaEstatica(listaIndices.cantidad());
        for(int idxListaIndices = 0; idxListaIndices < listaIndices.cantidad(); idxListaIndices++) {
            int curIdx = (int) listaIndices.obtener(idxListaIndices);
            if(validarIndice(curIdx)) {
                sublista.agregar(informacion[curIdx]);
            }
        }
        return sublista;
    }

    public int getTope() {
        return tope;
    }

    public void setTope(int tope) {
        this.tope = tope;
    }

    public int getMAXIMO() {
        return MAXIMO;
    }

    public void setMAXIMO(int MAXIMO) {
        this.MAXIMO = MAXIMO;
    }

    public void agregarBuffer(Object[] buffer) {
        informacion = new Object[buffer.length];
        for(int it = 0; it < buffer.length; it++) {
            informacion[it] = buffer[it];
        }
    }

    public Object[] leerArreglo() {
        return ((ListaEstatica) clonar()).informacion;
    }

   static public Object[] doubleArrayToObject(double [] array) {
        Object[] arrayNuevo = new Object[array.length];
        for(int idx = 0; idx < array.length; idx++) {
            arrayNuevo[idx] = array[idx];
        }
        return arrayNuevo;
    }


}