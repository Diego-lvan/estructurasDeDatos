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
        comisionesAnio = new ListaEstatica(12);
    }

    public double obtenerPromedio() {
        if(comisionesAnio.cantidad() == 0) return 0.0;
        double promedio = 0.0;
        for(int mes = 0; mes < comisionesAnio.cantidad(); mes++) {
            promedio += (double) comisionesAnio.obtener(mes);
        }
        promedio /= comisionesAnio.cantidad();
        return promedio;
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
