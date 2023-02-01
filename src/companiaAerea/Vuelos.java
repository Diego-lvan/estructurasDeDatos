package companiaAerea;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;

public class Vuelos {
    private ArrayList<Vuelo> vuelos;
    private Aeropuertos aeropuertos;
    private Aviones aviones;
    public Vuelos(Aeropuertos aeropuertos, Aviones aviones) {
        vuelos = new ArrayList<>();
        this.aeropuertos = aeropuertos;
        this.aviones = aviones;
    }
    public boolean agregarVuelo(int idAvion, int IdOrigen, int IdDestino, int idPiloto, String fechaVuelo) {
        if(aviones.obtenerAvion(idAvion).isEmpty()) return false;
        Optional<Aeropuerto> aeropuertoOrigen = aeropuertos.obtenerAeropuerto(IdOrigen);
        if(aeropuertoOrigen.isEmpty()) return false;
        Optional<Aeropuerto> aeropuertoDestino = aeropuertos.obtenerAeropuerto(IdDestino);
        if(aeropuertoDestino.isEmpty()) return false;
        if(aeropuertos.obtenerAeropuerto(IdDestino).isEmpty()) return false;
        Vuelo vuelo = new Vuelo(idAvion,aeropuertoOrigen.get(),aeropuertoDestino.get(),idPiloto,fechaVuelo);
        vuelos.add(vuelo);
        return true;
    }

    public ArrayList<Vuelo> getVueloPorOrigen(int origenID) {
        ArrayList<Vuelo> ans = new ArrayList<>();
        for(int idx = 0; idx < vuelos.size(); idx++) {
            if(vuelos.get(idx).getAeropuertoOrigen().getId() == origenID) {
                ans.add(vuelos.get(idx));
            }
        }
        return ans;
    }

    public ArrayList<Vuelo> getVuelosPorDestino(int idDestino) {
        ArrayList<Vuelo> ans = new ArrayList<>();
        for(int idx = 0; idx < vuelos.size(); idx++) {
            if(vuelos.get(idx).getAeropuertoDestino().getId() == idDestino) {
                ans.add(vuelos.get(idx));
            }
        }
        return ans;
    }
}
