package pruebas;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import registros.empresas.Empleado;
import registros.empresas.Empresa;

public class PruebaEmpresa {
    public  static void main(String arg[]) {
        Empresa empresa = new Empresa("Patito Sa",5);
        ListaEstatica comisiones1 = new ListaEstatica(4);
        comisiones1.agregar(400.2);
        comisiones1.agregar(701.2);
        comisiones1.agregar(80.2);
        comisiones1.agregar(4.2);
        Empleado empleado1 = new Empleado(101,"Pedro",30,comisiones1);


        ListaEstatica comisiones2 = new ListaEstatica(4);
        comisiones2.agregar(900.3);
        comisiones2.agregar(10.2);
        comisiones2.agregar(498.1);
        Empleado empleado2 = new Empleado(201,"Rosa",30,comisiones2);

        empresa.agragarEmpleado(empleado1);
        empresa.agragarEmpleado(empleado2);

        empresa.imprimirDatosEmpresa();
        SalidaPorDefecto.terminal("\n");
        empresa.imprimirDatosDetalle();

        SalidaPorDefecto.terminal("El promedio de comisiones de Pedro es: " + empresa.obtenerPromedioEmpleado(empleado1));
    }
}
