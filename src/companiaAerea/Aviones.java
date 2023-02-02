package companiaAerea;

import java.util.ArrayList;
import java.util.Optional;

public class Aviones {
    public ArrayList<Avion> getListaAviones() {
        return listaAviones;
    }

    public void setListaAviones(ArrayList<Avion> listaAviones) {
        this.listaAviones = listaAviones;
    }

    private ArrayList<Avion> listaAviones = new ArrayList<>();

    public boolean agregarAvion(Avion avion) {
        return listaAviones.add(avion);
    }


    // obtiene los aviones de un tipo especificado
    public ArrayList<Avion> getPorTipo(int tipoAvion) {
        ArrayList<Avion> res = new ArrayList<>();
        for(var avion : listaAviones) {
            if(avion.getTipoAvion() == tipoAvion) {
                res.add(avion);
            }
        }
        return res;
    }
    public Optional<Avion> obtenerAvion(int idTarget) {
        Optional<Avion> avion = Optional.empty();
        if(idTarget <= listaAviones.size()) {
            int idx = idTarget - 1;
            avion = Optional.of(listaAviones.get(idx));
        }
        return avion;
    }
    public void imprimirAvionesPorTipo(int tipoAvion) {
        for(int id = 1; id <= listaAviones.size(); id++) {
            if(listaAviones.get(id - 1).getTipoAvion() == tipoAvion) {
                System.out.println(id + " -> " + listaAviones.get(id - 1));
            }
        }
    }
}
