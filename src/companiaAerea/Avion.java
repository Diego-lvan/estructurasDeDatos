package companiaAerea;

public class Avion {
    public final int AVION_CARGO = 1;
    public final int AVION_PASAJEROS = 2;
    public final int AVION_MILITAR = 3;
    public final int AVION_RECREACION = 4;
    public final int AVION_EXCURSION = 5;

    private String matricula;
    private int tipoAvion;
    private String fabricante;
    private String modelo;
    private int capacidad;
    private int autonomiaKM;
    private String tipoAvionStr;

    public Avion(String matricula, int tipoAvion, String fabricante, String modelo, int capacidad, int autonomiaKM) {
        this.matricula = matricula;
        this.tipoAvion = tipoAvion;
        this.fabricante = fabricante;
        this.modelo = modelo;
        this.capacidad = capacidad;
        this.autonomiaKM = autonomiaKM;
        tipoAvionStr = tipoAvionToString(tipoAvion);
    }

    public String tipoAvionToString(int tipoAvion) {
        if(tipoAvion == 1) return "Avión de cargo";
        if(tipoAvion == 2) return "Avión de pasajeros";
        if(tipoAvion == 3) return "Avión militar";
        if(tipoAvion == 4) return "Avión de recreación";
        if(tipoAvion == 5) return "Avión de recursión";
        return "";
    }

    @Override
    public String toString() {
        return "Matrícula: " + matricula + "\nTipo avión: " + tipoAvionStr + "\nFabricante: " + fabricante + "\n";
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getTipoAvionStr() {
        return tipoAvionStr;
    }

    public void setTipoAvionStr(String tipoAvionStr) {
        this.tipoAvionStr = tipoAvionStr;
    }

    public int getTipoAvion() {
        return tipoAvion;
    }

    public void setTipoAvion(int tipoAvion) {
        this.tipoAvion = tipoAvion;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getAutonomiaKM() {
        return autonomiaKM;
    }

    public void setAutonomiaKM(int autonomiaKM) {
        this.autonomiaKM = autonomiaKM;
    }

}
