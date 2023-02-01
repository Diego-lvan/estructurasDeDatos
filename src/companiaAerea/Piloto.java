package companiaAerea;public class Piloto {
    private int tipoLicencia;
    private String nombre;
    private String matricula;

    public Piloto(int tipoLicencia, String nombre, String matricula) {
        this.tipoLicencia = tipoLicencia;
        this.nombre = nombre;
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Piloto(int tipoPiloto) {
        this.tipoLicencia = tipoPiloto;
    }

    public int getTipoLicencia() {
        return tipoLicencia;
    }

    public void setTipoLicencia(int tipoLicencia) {
        this.tipoLicencia = tipoLicencia;
    }
}
