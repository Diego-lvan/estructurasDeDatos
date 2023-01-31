package companiaAerea;

public class Avion {
    public final int AVION_CARGO = 1;
    public final int AVION_PASAJEROS = 2;
    public final int AVION_MILITAR = 3;
    public final int AVION_RECREACION = 4;
    public final int AVION_EXCURSION = 5;

    private String matricula;
    private String tipoAvion;
    private String fabricante;
    private String modelo;
    private int capacidad;
    private int autonomiaKM;

    public Avion(String matricula, String tipoAvion, String fabricante, String modelo, int capacidad, int autonomiaKM) {
        this.matricula = matricula;
        this.tipoAvion = tipoAvion;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.autonomiaKM = autonomiaKM;
    }
}
