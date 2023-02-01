package companiaAerea;

import java.util.ArrayList;

public class Pilotos {
   private ArrayList<Piloto> listaPilotos;

    public ArrayList<Piloto> getListaPilotos() {
        return listaPilotos;
    }

    public void setListaPilotos(ArrayList<Piloto> listaPilotos) {
        this.listaPilotos = listaPilotos;
    }

    public Pilotos() {
        listaPilotos = new ArrayList<>();
    }

    public void imprimirPilotos() {
        if(listaPilotos.size() == 0) {
            System.out.println("No hay pilotos registrados");
            return;
        }
        for(int id = 1; id <= listaPilotos.size(); id++) {
            System.out.println(id + " -> " + listaPilotos.get(id - 1));
        }
    }

    public boolean agregarPiloto(Piloto piloto) {
        return listaPilotos.add(piloto);
    }
}
