package companiaAerea;public class Piloto {
    private int tipoLicencia;
    private String nombre;

    @Override
    public String toString() {
        return " Piloto{" +
                "tipoLicencia=" + tipoLicencia +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public Piloto(int tipoLicencia, String nombre) {
        this.tipoLicencia = tipoLicencia;
        this.nombre = nombre;
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
