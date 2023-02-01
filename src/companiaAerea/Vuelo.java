package companiaAerea;

import java.util.Date;

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

    public String getFechaVuelo() {
        return fechaVuelo;
    }

    public void setFechaVuelo(String fechaVuelo) {
        this.fechaVuelo = fechaVuelo;
    }

    public int getIdAvion() {
        return idAvion;
    }

    public void setIdAvion(int idAvion) {
        this.idAvion = idAvion;
    }

    public Aeropuerto getAeropuertoOrigen() {
        return aeropuertoOrigen;
    }

    public void setAeropuertoOrigen(Aeropuerto aeropuertoOrigen) {
        this.aeropuertoOrigen = aeropuertoOrigen;
    }

    public Aeropuerto getAeropuertoDestino() {
        return aeropuertoDestino;
    }

    public void setAeropuertoDestino(Aeropuerto aeropuertoDestino) {
        this.aeropuertoDestino = aeropuertoDestino;
    }

    public int getIdPiloto() {
        return idPiloto;
    }

    public void setIdPiloto(int idPiloto) {
        this.idPiloto = idPiloto;
    }
}
