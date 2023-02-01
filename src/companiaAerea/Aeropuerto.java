package companiaAerea;

public class Aeropuerto {
    private String ciudad;
    private  String pais;

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aeropuerto(String ciudad, String pais, int id) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Aeropuerto{" +
                "ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                '}';
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
