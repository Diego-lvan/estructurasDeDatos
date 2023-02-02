package registros.empresas;

import estructurasLineales.Lista;
import estructurasLineales.ListaEstatica;

public class Empleado {
    protected int numeroEmpleado;
    protected  String nombre;
    protected int edad;
    protected ListaEstatica comisionesAnio;

    public Empleado(int numeroEmpleado, String nombre, int edad, ListaEstatica comisionesAnio) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.edad = edad;
        this.comisionesAnio = comisionesAnio;
    }

    public Empleado(int numeroEmpleado, String nombre, int edad) {
        this.numeroEmpleado = numeroEmpleado;
        this.nombre = nombre;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "" + numeroEmpleado;
    }

    public int getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(int numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ListaEstatica getComisionesAnio() {
        return comisionesAnio;
    }

    public void setComisionesAnio(ListaEstatica comisionesAnio) {
        this.comisionesAnio = comisionesAnio;
    }
}
