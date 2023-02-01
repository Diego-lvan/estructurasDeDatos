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
            if(avion.getTipoAvion() == tipoAvion) {
                res.add(avion);
            }
        }
        return res;
    }
    public boolean avionExiste(String matricula) {
        boolean ans = false;
        for(var avion: listaAviones) {
            if(avion.getMatricula().equals(matricula)) {
                ans = true;
            }
        }
        return ans;
    }
}
