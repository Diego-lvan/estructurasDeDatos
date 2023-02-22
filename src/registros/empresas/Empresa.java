package registros.empresas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class Empresa {
    protected ListaEstatica empleados;
    protected String nombre;

    public Empresa(String nombre, int cantidadEmpl) {
        this.nombre = nombre;
        empleados = new ListaEstatica(cantidadEmpl);
    }

    public boolean agragarEmpleado(Empleado empleado){
        int retornoEmpleado=(Integer) empleados.buscar(empleado);

        if (retornoEmpleado==-1){
            int retornoPosicionE=empleados.agregar(empleado);
            if (retornoPosicionE>=0){
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    public void imprimirDatosEmpresa() {
        SalidaPorDefecto.terminal("Los datos de la empresa " + nombre + " son:\n");
        empleados.imprimirOI();
    }

    public void imprimirDatosDetalle() {
        SalidaPorDefecto.terminal("Los datos dd la escuela " + nombre + " son: \n");
        for(int idxEmpl = 0; idxEmpl <  empleados.cantidad(); idxEmpl++) {
            Empleado empleadoTmp = (Empleado) empleados.obtener(idxEmpl);
            SalidaPorDefecto.terminal(empleadoTmp.getNombre() + "(" + empleadoTmp.numeroEmpleado + ")" + "\n");
            SalidaPorDefecto.terminal("Sus comisiones son: \n");
            empleadoTmp.getComisionesAnio().imprimir();
            SalidaPorDefecto.terminal("\n");
        }
    }
    public Double obtenerPromedioEmpleado(Empleado empleado) {
        int idxEmpleado = (int) empleados.buscar(empleado);
        if(idxEmpleado == -1) {
            return null;
        }
        return empleado.obtenerPromedio();

    }
}