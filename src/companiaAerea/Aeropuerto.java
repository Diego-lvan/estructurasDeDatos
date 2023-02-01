package companiaAerea;

public class Aeropuerto {
    private String ciudad;
    private  String pais;
    private String codigoAeropuerto;

    public String getCodigoAeropuerto() {
        return codigoAeropuerto;
    }

    public void setCodigoAeropuerto(String codigoAeropuerto) {
        this.codigoAeropuerto = codigoAeropuerto;
    }

    public Aeropuerto(String ciudad, String pais, String codigoAeropuerto) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.codigoAeropuerto = codigoAeropuerto;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
}
