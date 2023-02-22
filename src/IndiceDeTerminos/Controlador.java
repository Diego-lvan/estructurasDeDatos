package IndiceDeTerminos;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstaticaOrdenada;
import utilerias.comunes.TipoOrden;


public class Controlador {
    Termino terminos;

    public Controlador() {
        terminos = new Termino(new ListaEstaticaOrdenada(15,TipoOrden.INC),"");
        iniciar();
    }


    /**
     * Incia el programa
     */
    public void iniciar() {
        while(true) {
            mostrarMenu();
            int opcion = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
            if(opcion == 1) agregarTermino(terminos);
            else if(opcion == 2) agregarSubtermino();
            else if(opcion == 3) imprimirTermino();
            else if(opcion == 4) imprimirTermino();
            else if(opcion == 5)Termino.imprimirTerminos(terminos, ""); // listar todos los terminos y subtermino
            else if(opcion == 6) listarTerminosRangoInicial();
        }
    }


    /***
     * Lista los terminos que empiezan por el valor leido.
     */
    private void listarTerminosRangoInicial() {
        Termino.imprimirTerminos(terminos,"");
        SalidaPorDefecto.terminal( "Ingresa el rango de letras iniciales a buscar: ");
        String inicio = EntradaPorDefecto.consolaCadenas();
        ListaEstaticaOrdenada terminosEnc = terminos.buscarRangoLetras(inicio);
        for(int idx = 0; idx <= terminosEnc.getTope(); idx++) {
            Termino curTermino = (Termino) terminosEnc.obtener(idx);
            SalidaPorDefecto.terminal(curTermino.nombre);
            for(int idxPag = 0; idxPag <= curTermino.paginas.getTope(); idxPag++) {
                SalidaPorDefecto.terminal( "," + curTermino.paginas.obtener(idxPag));
            }
            SalidaPorDefecto.terminal("\n");
        }
    }

    /**
     * Agrega un subtermino al termino indicado.
     */
    private void agregarSubtermino() {
        Termino.imprimirTerminos(terminos,"");
        SalidaPorDefecto.terminal( "\n");
        SalidaPorDefecto.terminal( "Ingresa el termino al cual le quiere agregar el subtermino: ");
        String targetNombre = EntradaPorDefecto.consolaCadenas();
        Termino terminoTarget = Termino.buscarTermino(terminos,targetNombre);
        if(terminoTarget == null) {
            SalidaPorDefecto.terminal( "Ese termino no existe\n");
            return;
        }
        agregarTermino(terminoTarget);
    }

    /**
     * Imprime el termino indicado por el nombre.
     */
    private void imprimirTermino() {
        Termino.imprimirTerminos(terminos,"");
        SalidaPorDefecto.terminal( "Ingresa el nombre del término a buscar (exactamente como se muestra arriba): ");
        String nombreTarget = EntradaPorDefecto.consolaCadenas();
        Termino termino = Termino.buscarTermino(terminos,nombreTarget);
        if(termino == null) {
            SalidaPorDefecto.terminal( "No se encontró el término");
            return;
        }
        Termino dummyTermino = new Termino(new ListaEstaticaOrdenada(0,TipoOrden.INC),"");
        dummyTermino.subterminos.agregar(termino);
        Termino.imprimirTerminos(dummyTermino,"");
    }

    /**
     * Agrega un nuevo termino.
     * @param termino El termino a agragar.
     */
    private void agregarTermino(Termino termino) {
        SalidaPorDefecto.terminal( "Ingresa el nombre del término: ");
        String nombre = EntradaPorDefecto.consolaCadenas();
        SalidaPorDefecto.terminal("Ingresa la cantidad de páginas: ");
        int cantidadPaginas = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        ListaEstaticaOrdenada paginas = leerRangoPaginas(cantidadPaginas);
        Termino nuevoTermino = new Termino(paginas,nombre);
        termino.subterminos.agregar(nuevoTermino);
    }


    /**
     * Lee las paginas del termino.
     * @param cantidad La cantidad de paginas a leer.
     * @return Regresa una lista ordenada con las paginas leidas.
     */
    private ListaEstaticaOrdenada leerRangoPaginas(int cantidad) {
        ListaEstaticaOrdenada paginas = new ListaEstaticaOrdenada(cantidad, TipoOrden.INC);
        while(cantidad-- > 0) {
            SalidaPorDefecto.terminal( "Ingresa el número de página: ");
            int noPagina = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
            paginas.agregar(noPagina);
        }
        return paginas;
    }

    /**
     * Muestra el menu.
     */
    private void mostrarMenu() {
        SalidaPorDefecto.terminal("1- Agregar términos\n");
        SalidaPorDefecto.terminal("2- agregar subtérmino\n");
        SalidaPorDefecto.terminal("3- Consultar término por su nombre\n");
        SalidaPorDefecto.terminal("4- Consultar subtermino por su nombre\n");
        SalidaPorDefecto.terminal("5- Listar términos/subtérminos y sus páginas\n");
        SalidaPorDefecto.terminal("6- Listar solo los términos de un rango de letras iniciales\n");
        SalidaPorDefecto.terminal("Selecciona el número de la opción: ");
    }


}
