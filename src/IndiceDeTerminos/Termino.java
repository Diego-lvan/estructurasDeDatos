package IndiceDeTerminos;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaOrdenada;
import utilerias.comunes.FuncionesString;
import utilerias.comunes.TipoOrden;

public class Termino {
    protected ListaEstaticaOrdenada subterminos;
    protected ListaEstaticaOrdenada paginas;
    protected String nombre;


    public Termino(ListaEstaticaOrdenada paginas, String nombre) {
        subterminos = new ListaEstaticaOrdenada(10, TipoOrden.INC);
        this.paginas = paginas;
        this.nombre = nombre;
    }

    /**
     * Busca un termino indica y lo devuelve si lo encuetra.
     * @param termino El termino donde se buscara el otro termino.
     * @param target El nombre del termino a buscar.
     * @return Regresa null si no se encontro el termino y regresa un Termino si se encontro.
     */
    public static Termino  buscarTermino(Termino termino, String target) {
        if(termino == null) return null;
        String terminoStr = termino.toString();
        if(terminoStr.equalsIgnoreCase(target)) return termino;

        for(int idx = 0; idx <= termino.subterminos.getTope(); idx++) {
            Termino curTermino = (Termino) termino.subterminos.obtener(idx);
            Termino terminoEncontrado = buscarTermino(curTermino,target);
            if(terminoEncontrado != null) return terminoEncontrado;

        }
        return null;
    }

    /**
     * Busca los terminos que empiezar por un rango de letras indicado.
     * @param rango EL rango de letras.
     * @return Regresa una lista ordenada con los terminos encotrados.
     */
    public  ListaEstaticaOrdenada buscarRangoLetras(String rango) {
        ListaEstaticaOrdenada terminosEnc = new ListaEstaticaOrdenada(10,TipoOrden.INC);
        for(int idx = 0; idx <= subterminos.getTope(); idx++) {
            Termino curTermino = (Termino) subterminos.obtener(idx);
            if(FuncionesString.startsWith(curTermino.nombre,rango)) {
                terminosEnc.agregar(curTermino);
            }
        }
        return terminosEnc;
    }

    /**
     * Imprime todos los subterminos del termino que se pasa.
     * @param terminoActual Termino del cual se imprimen los subterminos.
     * @param space Es el espacio paro que se acomoden los terminos.
     */
    public  static void imprimirTerminos(Termino terminoActual, String space) {
        if(terminoActual == null) return;
        for(int idx = 0; idx <= terminoActual.subterminos.getTope(); idx++) {
            Termino subterminoActual = (Termino) terminoActual.subterminos.obtener(idx);
            SalidaPorDefecto.terminal(space + subterminoActual.nombre);

            for (int idxPagina = 0; idxPagina <= subterminoActual.paginas.getTope(); idxPagina++) {
                SalidaPorDefecto.terminal("," + subterminoActual.paginas.obtener(idxPagina));
            }
            SalidaPorDefecto.terminal( "\n");
            imprimirTerminos(subterminoActual, space + "    ");
        }
    }
    @Override
    public String toString() {
        return nombre;
    }
}
