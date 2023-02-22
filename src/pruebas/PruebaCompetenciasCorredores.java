package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import registros.competenciasatleticas.ControlCompetenciasCorredor;
import registros.competenciasatleticas.Corredor;
import registros.competenciasatleticas.EventoCompetencia;

public class PruebaCompetenciasCorredores {
    public static void main(String[] args) {
        ControlCompetenciasCorredor competencias = new ControlCompetenciasCorredor(4,3,5);
        competencias.agregarAnio(1980);
        competencias.agregarAnio(2000);
        competencias.agregarAnio(2005);
        competencias.agregarAnio(2019);

        Corredor corredor1 = new Corredor(101,"Pepe",20,"Mexicana");
        Corredor corredor2 = new Corredor(201,"Lencho",29,"Mexicana");
        Corredor corredor3 = new Corredor(301,"Felipe",20,"Colombiano");

        competencias.agregarCorredor(corredor1);
        competencias.agregarCorredor(corredor2);
        competencias.agregarCorredor(corredor3);

        EventoCompetencia evento1 = new EventoCompetencia("viva la viva", "chinchis");
        EventoCompetencia evento2 = new EventoCompetencia("vamos mal", "asdfasdfasdf");

        competencias.agreagarEvento(evento1);
        competencias.agreagarEvento(evento2);

        competencias.agregarKmRecorridos(1980,301,"vamos mal", 201.2);
        competencias.agregarKmRecorridos(2000,201,"viva la viva", 102.2);
        competencias.agregarKmRecorridos(2005,101,"vamos mal", 500.4);
        competencias.agregarKmRecorridos(1980,201,"viva la viva", 45.0);

        competencias.imprimirDatosCompetencias();


        // indicar los kilometros recorridos de Lencho en "viva la vida"
        // en los anios 200, 2005, 2019, 2020
        // indicar los kilometros recorridos por lencho en 2005

        ListaEstatica aniosPedidosCorredor = new ListaEstatica(3);
        aniosPedidosCorredor.agregar(2000);
        aniosPedidosCorredor.agregar(1980);
        aniosPedidosCorredor.agregar(2020);

        double kmPedidos = competencias.kmXCorredorXEvento(201,"viva la viva", aniosPedidosCorredor);
        SalidaPorDefecto.terminal( "La salida acumulada de km de la solicitud es: " + kmPedidos + "\n");

    }
}
