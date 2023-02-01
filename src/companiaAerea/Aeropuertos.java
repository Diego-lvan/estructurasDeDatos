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

    public ArrayList<Aeropuerto> getAeropuertoPorCiudad(String ciudad) {
        ArrayList<Aeropuerto> ans = new ArrayList<>();
        for(var aeropuerto: listaAeropuertos) {
            if(aeropuerto.getCiudad().equals(ciudad)) {
                ans.add(aeropuerto);
            }
        }
        return ans;
    }
    public boolean aeropuertoExiste(String codAeropuerto) {
        boolean ans = false;
        for(var aeropuerto: listaAeropuertos) {
            if(aeropuerto.getCodigoAeropuerto().equals(codAeropuerto)) {
                ans = true;
            }
        }
        return ans;
    }

}
