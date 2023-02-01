package companiaAerea;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Vuelos {
    private ArrayList<Vuelo> vuelos;
    private Aeropuertos aeropuertos;
    private Aviones aviones;
    public Vuelos(Aeropuertos aeropuertos, Aviones aviones) {
        vuelos = new ArrayList<>();
        this.aeropuertos = aeropuertos;
        this.aviones = aviones;
    }
    public boolean agregarVuelo(String matriculaAvion, String codAeroOrigen, String codAeroDestino, String nombrePiloto, Date fechaVuelo) {
        if(!aviones.avionExiste(matriculaAvion)) return false;
        if(!aeropuertos.aeropuertoExiste(codAeroOrigen)) return false;
        if(!aeropuertos.aeropuertoExiste(codAeroDestino)) return false;

        return true;
    }

    public ArrayList<Vuelo> getVueloPorOrigen(String origen) {
        ArrayList<Vuelo> ans = new ArrayList<>();
        for(var vuelo : vuelos) {

            if(vuelo.getAeropuertoOrigen().getCiudad().equals(origen)) {
                ans.add(vuelo);
            }
        }
        return ans;
    }

    public ArrayList<Vuelo> getVueloPorDestino(String destino) {
        ArrayList<Vuelo> ans = new ArrayList<>();
        for(var vuelo : vuelos) {
            if(vuelo.getAeropuertoDestino().getCiudad().equals(destino) ) {
                ans.add(vuelo);
            }
        }
        return ans;
    }
}
