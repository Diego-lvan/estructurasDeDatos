package registros.competenciasatleticas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import estructurasnolineales.Matriz3;

public class ControlCompetenciasCorredor {
    protected Matriz3 kmRecorridos;
    protected ListaEstatica anios;
    protected  ListaEstatica corredores;
    protected ListaEstatica eventosCompetencias;

    public ControlCompetenciasCorredor(int numAnios, int numCorredores, int numEventos) {
        kmRecorridos = new Matriz3(numAnios,numCorredores,numEventos);
        anios = new ListaEstatica(numAnios);
        corredores = new ListaEstatica(numCorredores);
        eventosCompetencias = new ListaEstatica(numEventos);
        kmRecorridos.rellenar(0.0);
    }

    public boolean agregarAnio(int anio) {
        int indiceAnio = (int) anios.buscar(anio);
        if(indiceAnio == -1) {
            int pos = anios.agregar(anio);
            return pos == -1 ? false: true;
        }
        return false;
    }

    public  boolean agregarCorredor(Corredor corredor) {
        int indiceCorredor = (int) corredores.buscar(corredor);
        if(indiceCorredor == -1) {
            int pos = corredores.agregar(corredor);
            return pos == -1 ? false: true;
        }
        return false;
    }

    public  boolean agreagarEvento(EventoCompetencia evento) {
        int indiceEvento = (int) eventosCompetencias.buscar(evento);
        if(indiceEvento == -1) {
            int pos = eventosCompetencias.agregar(evento);
            return pos == -1 ? false: true;
        }
        return false;
    }

    public boolean agregarKmRecorridos(int anio, int numCorredor, String nombreEvento, double cantidadkm) {
        ListaEstatica listaIndices = buscarIndicesCuboKms(anio,numCorredor,nombreEvento);
        if(listaIndices == null) return false;
        return kmRecorridos.cambiar((int)listaIndices.obtener(0), (int)listaIndices.obtener(1),
                (int)listaIndices.obtener(2), cantidadkm);

    }

    private ListaEstatica buscarIndicesCuboKms(int anio, int numCorredor, String evento) {
        int indiceAnio = (int) anios.buscar(anio);
        int indiceCorredor = (int) corredores.buscar(numCorredor);
        int indiceEvento = (int) eventosCompetencias.buscar(evento);
        if(indiceAnio < 0 || indiceCorredor < 0 || indiceEvento < 0) return null;

        ListaEstatica listaIndices = new ListaEstatica(3);
        listaIndices.agregar(indiceAnio);
        listaIndices.agregar(indiceCorredor);
        listaIndices.agregar(indiceEvento);
        return listaIndices;


    }

    public void imprimirAnios() {
        SalidaPorDefecto.terminal("Anios:\n");
        anios.imprimirOI();
    }
    public void imprimirCorredor() {
        SalidaPorDefecto.terminal("Corredores:\n");
        corredores.imprimirOI();
    }
    public void imprimirEventos() {
        SalidaPorDefecto.terminal("Eventos:\n");
        eventosCompetencias.imprimirOI();
    }
    public void imprimirAKm() {
        SalidaPorDefecto.terminal("Kilometros:\n");
        kmRecorridos.imprimirXColumnas();
    }

    public void imprimirDatosCompetencias() {
        imprimirAnios();
        imprimirCorredor();
        imprimirEventos();
        imprimirAKm();
    }

    // preguntas comunes
    // indicar los kilometros recorridos de Lencho en "viva la vida"
    // en los anios 200, 2005, 2019, 2020
    // indicar los kilometros recorridos por lencho en 2005

    public  double kmXCorredorXEvento(int numCorredor, String evento, ListaEstatica aniosPedidos) {
        double totalKm = 0;
        for(int curAnio = 0; curAnio < aniosPedidos.cantidad(); curAnio++) {
            int anioPedido = (int) aniosPedidos.obtener(curAnio);
            double kmsAnio =  kmXCorredorXEventoXAnio(numCorredor,evento,anioPedido);
            if(kmsAnio >= 0) {
                totalKm += kmsAnio;
            }
        }

        return totalKm;
    }

    public double kmXCorredorXEventoXAnio(int numCorredor, String evento, int anio) {
        ListaEstatica listaIndices = buscarIndicesCuboKms(anio,numCorredor,evento);
        if(listaIndices == null) return -1;
        return (double) kmRecorridos.obtener((int) listaIndices.obtener(0),
                (int) listaIndices.obtener(1), (int) listaIndices.obtener(2));

    }
}
