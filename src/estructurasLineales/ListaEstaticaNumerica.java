package estructurasLineales;

public class ListaEstaticaNumerica extends ListaEstatica{
    public ListaEstaticaNumerica(int tamanio) {
        super(tamanio);
    }

    /**
     * Multiplica los elementos de la lista por un escalar.
     * @param escalar El escalar por el que se multiplicaran los elementos.
     * @return Regresa true si se pudo multiplicar y false si no se pudo.
     */
    public boolean porEscalar(Number escalar) {
        if(vacia()) return false;
        for(int idx = 0; idx < cantidad(); idx++) {
            double curVal = ((Number) informacion[idx]).doubleValue();
            informacion[idx] = curVal * escalar.doubleValue();
        }
        return true;
    }

    /**
     * Le agrega el escalar a todos los numeros del arreglo.
     * @param escalar El valor que se va a agreagar.
     * @return Regresa true si se pudo realizar y false si no.
     */
    public boolean sumarEscalar(Number escalar) {
        if(vacia()) return false;
        for(int idx = 0; idx < cantidad(); idx++) {
            double curVal = ((Number) informacion[idx]).doubleValue();
            informacion[idx] = curVal + escalar.doubleValue();
        }
        return true;
    }

    /**
     * Convierte un Object a un double;
     * @param object Objeto que se va a convertir.
     * @return Regresa el valor double convertido.
     */
    private static double objectToDoule(Object object) {
        return ((Number) object).doubleValue();
    }


    /**
     * Suma la posición 1 del arreglo actual con la posición 1 de arreglo2, y así sucesivamente.
     * @param lista2 Lista donde la cual se sumara a la lista actual.
     * @return Regresa true si se pudo realizar y false si no se pudo.
     */
    public boolean sumar(ListaEstaticaNumerica lista2) {
        if(lista2.cantidad() != cantidad()) return false;
        for(int idx = 0; idx < cantidad(); idx++) {
            double escalar = objectToDoule(lista2.obtener(idx));
            informacion[idx] = objectToDoule(informacion[idx]) + escalar;
        }
        return true;
    }


    /**
     * Hace el producto de posición 1 del arreglo actual por posición 1 de arreglo2, y así sucesivamente.
     * @param lista2 Lista donde la cual se multiplicara a la lista actual.
     * @return Regresa true si se pudo realizar y false si no se pudo.
     */
    public boolean multiplicar(ListaEstaticaNumerica lista2) {
        if(lista2.cantidad() != cantidad()) return false;
        for(int idx = 0; idx < cantidad(); idx++) {
            double escalar = objectToDoule(lista2.obtener(idx));
            informacion[idx] = objectToDoule(informacion[idx]) * escalar;
        }
        return true;
    }


    /**
     * Hace la operación de potencia de cada elemento del arreglo (base) por el exponente pasado como escalar.
     * @param escalar Potencia a la que se va a elevar.
     * @return Regresa true si se pudo realizar y false si no se pudo.
     */
    public boolean aplicarPotencia(Number escalar) {
        if(vacia()) return false;
        for(int idx = 0; idx < cantidad(); idx++) {
            double curVal = ((Number) informacion[idx]).doubleValue();
            informacion[idx] = Math.pow(curVal,escalar.doubleValue());
        }
        return true;
    }


    /**
     * Hace la operación de potencia de cada elemento del arreglo (base) por el exponente
     * pasado como arreglo, posición por posición
     * @param listaEscalares Lista con los escalares que serán utilizados como exponentes.
     * @return Regresa true si se pudo realizar y false si no.
     */
    public boolean aplicarPotencia(ListaEstaticaNumerica listaEscalares) {
        if (vacia()) return false;
        for (int idx = 0; idx < cantidad(); idx++) {
            double curVal = ((Number) informacion[idx]).doubleValue();
            double escalar = objectToDoule(listaEscalares.obtener(idx));
            informacion[idx] = Math.pow(curVal, escalar);
        }
        return true;
    }

    /**
     * Obtiene el producto escalar de un vector.
     * @param lista2 Lista con la que se hara la operacion.
     * @return Regresa el valor del producto escalar.
     */
    public Double productoEscalar(ListaEstaticaNumerica lista2) {
        if(lista2.cantidad() != cantidad()) return null;
        double producto = 0.0;
        for(int idx = 0; idx < cantidad(); idx++) {
            double escalar = objectToDoule(lista2.obtener(idx));
            producto += objectToDoule(informacion[idx]) * escalar;
        }
        return producto;
    }

    /**
     * Obtiene la norma de arrry,
     * @return Regresa la norma del array.
     */
    public double norma() {
        double norma = 0.0;

        for(int idx = 0; idx < cantidad(); idx++) {
            double curValue = objectToDoule(informacion[idx]);
            norma += Math.pow(curValue,2);
        }
        norma = Math.sqrt(norma);
        return norma;
    }

    /**
     * Obtiene la norma euclidiana del arreglo actual con el del arreglo2
     * @param arreglo2 Arreglo con el cual se hara la operacion.
     * @return Regresa la norma euclidiana de los arreglos.
     */
    public Double normaEuclidiana(ListaEstaticaNumerica arreglo2) {
        if(arreglo2.cantidad() != cantidad()) return null;
        Double norma = 0.0;
        for(int idx = 0; idx < cantidad(); idx++) {
            double a = objectToDoule(informacion[idx]);
            double b = objectToDoule(arreglo2.obtener(idx));
            norma += Math.pow(a - b,2);
        }
        norma = Math.sqrt(norma);
        return norma;
    }

    /**
     *
     * @return Regresa la suma de los elementos del arreglo actual.
     */
    public double obtenerSuma() {
        double suma = 0.0;
        for(Object  num: informacion ) {
            suma += objectToDoule(num);
        }
        return suma;
    }

    /**
     * Suma de uno por uno un conjunto de arreglos de tipo ListaEstaticaNumerica
     * almacenados en la variable listas al arreglo actual
     * @param listas Lista que contiene las ListaEstaticNumerica.
     * @return Regresa la suma de las listas.
     */
    public double sumarListaEstatica(ListaEstatica listas) {
        double sumaTotal = 0.0;
        for(int idx = 0; idx < listas.cantidad(); idx++) {
            ListaEstaticaNumerica lista = (ListaEstaticaNumerica) listas.obtener(idx);
            sumaTotal += lista.obtenerSuma();
        }

        sumaTotal += obtenerSuma();

        return sumaTotal;
    }


    /**
     * Suma los valores de la lista escalares con los de la lista actual.
     * @param escalares Lista con la que se realizara la suma.
     * @return La suma de las dos listas.
     */
    public double sumarEscalares(ListaEstaticaNumerica escalares) {
        double suma = escalares.obtenerSuma() + obtenerSuma();
        return suma;
    }

    /**
     * Hace una sumatoria del arreglo actual, las posiciones indicadas por la lista escalares.
     * Indices invalidos seran ignorados.
     * @param listaIndices Contiene los indices que se van a sumar.
     * @return Regresa la sumatoria de los valores.
     */
    public  double sumarIndices(ListaEstaticaNumerica listaIndices) {
        double suma = 0.0;
        for(int idxLista = 0; idxLista < listaIndices.cantidad(); idxLista++) {
            int curIndice = (int) listaIndices.obtener(idxLista);
            if(validarIndice(curIndice)) {
                suma += ((Number)informacion[curIndice]).doubleValue();
            }
        }
        return suma;
    }


    /**
     * Crea una sublista del arreglo actual con los indices indicados por listaIndices.
     * @param listaIndices Lista que contiene los indices a agregar.
     * @return Regresa la sublista generada.
     */
    public ListaEstaticaNumerica subLista(ListaEstaticaNumerica listaIndices) {
        ListaEstaticaNumerica sublista = new ListaEstaticaNumerica(listaIndices.cantidad());
        for(int idxListaIndices = 0; idxListaIndices < listaIndices.cantidad(); idxListaIndices++) {
            int curIdx = (int) listaIndices.obtener(idxListaIndices);
            if(validarIndice(curIdx)) {
                sublista.agregar(informacion[curIdx]);
            }
        }
        return sublista;
    }

    /**
     * Determina si un conjunto de arreglos son linealmente dependientes.
     * @param listaVectores La lista que contiene los arreglos.
     * @return Regresa true si son linealmente dependientes y false si no.
     */

    public  static  boolean sonLinealmenteDependientes(ListaEstatica listaVectores) {
        int m = listaVectores.cantidad(); // num listas
        for(int listaIdx = 0; listaIdx < m; listaIdx++) {
            for(int lista2Idx = 1; lista2Idx < m; lista2Idx++) {
                ListaEstaticaNumerica lista1 = (ListaEstaticaNumerica) listaVectores.obtener(listaIdx);
                ListaEstaticaNumerica lista2 = (ListaEstaticaNumerica) listaVectores.obtener(lista2Idx);
                // cuando son paralelos significa que hay una relacion por lo tanto son dependintes
                boolean esParalelo = lista1.esParalelo(lista2);
                if(esParalelo) return true;

            }
        }
        return false;
    }



    /**
     * Determina si un conjunto de arreglos son linealmente independientes.
     * @param listaVectores La lista que contiene los arreglos.
     * @return Regresa true si son linealmente independientes y false si no.
     */
    public  static boolean sonLinealmenteIndependientes(ListaEstatica listaVectores) {

        return !sonLinealmenteDependientes(listaVectores);
    }

    /**
     * Determina si la lista actual y la lista2 son ortogonales.
     * @param lista2 La lista con la que se realiza la comparacion.
     * @return Regresa true si son ortogonales y false si no.
     */
    public  boolean esOrtogonal(ListaEstaticaNumerica lista2) {
        if(lista2.cantidad() != cantidad()) return false;
        return productoEscalar(lista2) == 0;
    }


    /**
     * Determina si la lista actual y la lista2 son paralelas.
     * @param lista2 La lista con la que se realiza la comparacion.
     * @return Regresa true si son paralelas y false si no.
     */
    public boolean esParalelo(ListaEstaticaNumerica lista2) {
        if(lista2.cantidad() != cantidad() || cantidad() == 0) return false;
        int n = cantidad();

        double primeraRelacion = objectToDoule(informacion[0]) / objectToDoule(lista2.obtener(0));
        for(int idx = 0; idx < n; idx++) {
            double ele1 = objectToDoule(informacion[idx]);
            double ele2 = objectToDoule(lista2.obtener(idx));
            double relacion = ele1 / ele2;
            if(primeraRelacion != relacion) return false;
        }
        return true;
    }






    @Override
    public int agregar(Object info) {
        if((info instanceof Number) == false) return -1;
        return super.agregar(info);
    }

    @Override
    public boolean cambiar(int indice, Object info) {
        if((info instanceof  Number) == false) return false;
        return super.cambiar(indice,info);
    }

    @Override
    public boolean cambiarListaEstatica(ListaEstatica indicesBusqueda, ListaEstatica infosNuevos) {
        if((infosNuevos instanceof ListaEstaticaNumerica) == false) return false;
        return super.cambiarListaEstatica(indicesBusqueda,infosNuevos);
    }


    @Override
    public Object buscar(Object info) {
        if((info instanceof  Number) == false) return false;
        return super.buscar(info);
    }

    @Override
    public Object eliminar(Object info) {
        if((info instanceof  Number) == false) return false;
        return super.eliminar(info);
    }


    @Override
    public boolean esIgual(Object lista2) {
        if ((lista2 instanceof ListaEstaticaNumerica) == false) return false;
        return super.esIgual(lista2);
    }


    @Override
    public boolean cambiar(Object infoViejo, Object infoNuevo, int numVeces) {
        if((infoViejo instanceof ListaEstaticaNumerica) == false || (infoNuevo instanceof ListaEstaticaNumerica) == false) {
            return false;
        }
        return super.cambiar(infoViejo, infoNuevo,  numVeces);
    }

    @Override
    public ListaEstatica buscarValores(Object info) {
        if((info instanceof ListaEstaticaNumerica) == false) return null;
        return super.buscarValores(info);
    }

    @Override
    public boolean agregarLista(Object lista2) {
        if((lista2 instanceof ListaEstaticaNumerica) == false) return false;
        return super.agregarLista(lista2);
    }

    @Override
    public int contar(Object info) {
        if((info instanceof Number) == false) return -1;
        return super.contar(info);
    }

    @Override
    public void rellenar(Object info, int cantidad) {
        if((info instanceof Number) == false) return;
        super.rellenar(info, cantidad);
    }

    @Override
    public boolean insertar(int indice, Object info) {
        if((info instanceof Number) == false) return false;
        return super.insertar(indice, info);
    }

    @Override
    public boolean copiarLista(Lista lista2) {
        if((lista2 instanceof ListaEstaticaNumerica) == false) return false;
        return super.copiarLista(lista2);
    }

@Override
    public void agregarBuffer(Object[] buffer) {

        informacion = new Object[buffer.length];
        for(int it = 0; it < buffer.length; it++) {
            informacion[it] = buffer[it];
        }
        tope = informacion.length - 1;
    }
}
