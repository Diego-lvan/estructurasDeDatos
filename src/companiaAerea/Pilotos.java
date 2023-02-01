package companiaAerea;

import java.util.ArrayList;

public class Pilotos {
    ArrayList<Piloto> listaPilotos;
    public Pilotos() {
        listaPilotos = new ArrayList<>();
    }

    public boolean agregarPiloto(Piloto piloto) {
        return listaPilotos.add(piloto);
    }
}
