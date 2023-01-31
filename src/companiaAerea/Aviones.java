package companiaAerea;

import java.util.ArrayList;

public class Aviones {
    private ArrayList<Avion> listaAviones = new ArrayList<>();

    public boolean agregarAvion(Avion avion) {
        return listaAviones.add(avion);
    }

    public ArrayList<Avion> getPorTipo(int tipoAvion) {
        ArrayList<Avion> res = new ArrayList<>();
        for(var avion : listaAviones) {
            res.add(avion);
        }
        return res;
    }
}
