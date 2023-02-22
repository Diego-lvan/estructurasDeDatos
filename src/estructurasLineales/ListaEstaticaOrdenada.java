package estructurasLineales;

import estructurasnolineales.Matriz3;
import utilerias.comunes.Comparador;
import utilerias.comunes.TipoOrden;

public class ListaEstaticaOrdenada extends ListaEstatica{

    private TipoOrden orden;
    public  ListaEstaticaOrdenada(int maximo, TipoOrden orden) {
        super(maximo);
        this.orden = orden;
    }

    public boolean esIncremental() {
        switch (orden) {
            case INC:  return true;
            case DEC : return false;
            default: return true;
        }
    }
@Override
    public int agregar(Object info) {
        if(llena()) return  -1;
        int posicion = (int) buscar(info);
        if(posicion > 0) return -1;

        tope++;
        posicion = Math.abs(posicion);
        posicion--;
        for(int idx = tope; idx > posicion;  idx--) {
            Object prev = obtener(idx - 1);
            informacion[idx]  =  prev;
        }
        informacion[posicion] = info;
        return posicion;
    }
@Override
    public  Object buscar(Object info) {
        int idx = 0;
        boolean encontrado = false;
        while(idx<= tope) {
            Integer comparador = Comparador.comparadorDeObjetos(info, informacion[idx]);
            if(comparador == null) break;
            boolean esMayor = comparador > 0;
            boolean esMenor = comparador < 0;
            boolean esIgual = comparador == 0;
            if(esIgual) {
                encontrado = true;
                break;
            }
            if(esIncremental() && esMenor) break;
            if(!esIncremental() && esMayor) break;
            idx++;
        }

        if(!encontrado) {
            return (idx + 1) * -1;
        }

        return idx + 1;
    }

    @Override
    public  boolean cambiar(Object valorViejo, Object valorNuevo, int numOcurrencias) {
        if(eliminar(valorViejo) == null) return false;
        int pos = agregar(valorNuevo);
        if(pos < 0) return false;
        return true;
    }

    @Override
    public Object eliminar(Object info) {
        Integer posTarget = (Integer) buscar(info);
        posTarget--;
        return super.eliminar((int)posTarget);
    }

    @Override
    public boolean cambiar(int indice, Object info) {
        if(indice > tope || indice < 0) return false;
        eliminar(indice);
        int pos = agregar(info);
        if(pos < 0) return false;
        return true;
    }

    public boolean agregarLista(Lista lista2) {
        if((lista2 instanceof ListaEstatica) == false) return false;
        ListaEstatica listaEstatica2 = (ListaEstatica) lista2;

        int idxLista2 = 0;
        while(idxLista2 <= listaEstatica2.getTope()) {
            if(llena()) {
                redimensionar(MAXIMO + 1);
            }
            Object newVal = listaEstatica2.obtener(idxLista2);
            agregar(newVal);
            idxLista2++;
        }
        return true;
    }

    @Override
    public void invertir() {
        switch (orden) {
            case INC: this.orden = TipoOrden.DEC; break;
            case DEC: this.orden  = TipoOrden.INC;
        }
        super.invertir();
    }

    @Override
    public void rellenar(Object info) {
        vaciar();
        if(info instanceof Character){
            int asciiCaracterInicio=(int) ((char)info);
            for (int iteracion = 0; iteracion < maximo(); iteracion++) {
                agregar((char) asciiCaracterInicio);
                asciiCaracterInicio-=1;
            }
        } else if (info instanceof Number) {
            int numero = (int) info;
            if (numero<0){
                for (int iteracion = 0; iteracion < maximo(); iteracion++) {
                    agregar(numero+iteracion);
                }
            }else{
                for (int iteracion = 0; iteracion < maximo(); iteracion++) {
                    agregar(numero-iteracion);
                }
            }
        }else{
            agregar(info);
        }
    }


    @Override
    public  boolean esSublista(Lista lista2) {
        if((lista2 instanceof ListaEstatica) == false) return false;
        if(lista2.vacia()) return false;
        ListaEstaticaOrdenada listaEstaticaOrdenada2 = (ListaEstaticaOrdenada) lista2;
        if(listaEstaticaOrdenada2.getOrden() != orden) {
            lista2.invertir();
        }
        Integer idxInicio = (Integer) buscar(listaEstaticaOrdenada2.obtener(0));
        if(idxInicio <  0) return false;
        idxInicio --;
        int idxLista2 = 0;
        for(int idxLista1 = idxInicio; idxLista1 <= tope; idxLista1++) {
            if(obtener(idxLista1).toString().equalsIgnoreCase(listaEstaticaOrdenada2.obtener(idxLista2).toString()) == false) {
                break;
            }
            idxLista2++;
            if(idxLista2 > listaEstaticaOrdenada2.getTope()) return true;
        }
        return false;
    }




    @Override
    public boolean insertar(int indice, Object info) {
        if(indice < 0 || indice > tope) return false;
        eliminar(indice);
        agregar(info);
        return true;
    }

    @Override
    public boolean copiarLista(Lista lista2) {
        if((lista2 instanceof ListaEstaticaOrdenada) == false) return false;
        ListaEstaticaOrdenada listaEstatica2 = (ListaEstaticaOrdenada) lista2;
        if(orden != listaEstatica2.orden) return false;

        if(listaEstatica2.getTope() != tope) return false;
        for(int idx = tope; idx >= 0; idx--) {
            Object curObject = listaEstatica2.obtener(idx);
            cambiar(idx,curObject );
        }
        return true;
    }
    public TipoOrden getOrden() {
        return orden;
    }

    public void setOrden(TipoOrden orden) {
        this.orden = orden;
    }

}
