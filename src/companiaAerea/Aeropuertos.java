package companiaAerea;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Aeropuertos {
    private ArrayList<Aeropuerto> listaAeropuertos;

    public ArrayList<Aeropuerto> getListaAeropuertos() {
        return listaAeropuertos;
    }


    public void setListaAeropuertos(ArrayList<Aeropuerto> listaAeropuertos) {
        this.listaAeropuertos = listaAeropuertos;
    }

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
    public Optional<Aeropuerto>  obtenerAeropuerto(int idAeropuerto) {
        Optional<Aeropuerto> aeropuerto = Optional.empty();
        if(listaAeropuertos.size() >= idAeropuerto) {
            aeropuerto = Optional.of(listaAeropuertos.get(idAeropuerto - 1));
        }
        return aeropuerto;
    }

    public  void imprimirAeropuertos() {
        if(listaAeropuertos.size() == 0) {
            System.out.println("\n\nNo hay aeropuertos registrados\n");
            return;
        }
        for(int id = 1; id <= listaAeropuertos.size(); id++) {
            int idx = id - 1;
            System.out.println(id + "-> " + listaAeropuertos.get(idx));
        }
    }

    public Set<String> getCiudades() {
        Set<String> ciudades = new HashSet<>();
        for(var aeropuertos: listaAeropuertos) {
            ciudades.add(aeropuertos.getCiudad());
        }
        return ciudades;
    }
}
