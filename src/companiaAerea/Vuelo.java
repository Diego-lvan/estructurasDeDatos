package companiaAerea;


public class Vuelo {
    private int  idAvion;
    private Aeropuerto aeropuertoOrigen;
    private Aeropuerto aeropuertoDestino;
    private int idPiloto;
    private String fechaVuelo;

    public Vuelo(int idAvion, Aeropuerto aeropuertoOrigen, Aeropuerto aeropuertoDestino, int idPiloto, String fechaVuelo) {
        this.idAvion = idAvion;
        this.aeropuertoOrigen = aeropuertoOrigen;
        this.aeropuertoDestino = aeropuertoDestino;
        this.idPiloto = idPiloto;
        this.fechaVuelo = fechaVuelo;
    }

    @Override
    public String toString() {
        return "Vuelo{" +
                "Ciudad origen = " + aeropuertoOrigen.getCiudad() +
                ", Ciudad destino = " + aeropuertoDestino.getCiudad() +
                ", fechaVuelo = " + fechaVuelo + "}";
    }



    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }
    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }
}
