package companiaAerea;

import java.util.ArrayList;

public class Aeropuertos {
    private ArrayList<Aeropuerto> listaAeropuertos;

    public  Aeropuertos() {
        listaAeropuertos = new ArrayList<>();
    }

    public boolean agregarAeropuerto(Aeropuerto aeropuerto) {
        return listaAeropuertos.add(aeropuerto);
    }

}
