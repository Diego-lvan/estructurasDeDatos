package controlCosechas;

import entradasalida.SalidaPorDefecto;

public class Menu {

    /**
     * Muestra el menu con las opciones disponibles.
     */
    static public void mostrarMenu() {
       SalidaPorDefecto.terminal("\n");
       SalidaPorDefecto.terminal("1. El promedio anual de toneladas por campesino<\n");
       SalidaPorDefecto.terminal("2. Meses que tuvieron toneladas mayores al promedio anual del campesino X\n");
       SalidaPorDefecto.terminal("3. El mes que obtuvo menos toneladas por cada año del campesino X\n");
       SalidaPorDefecto.terminal("4. Toneladas que se obtuvieron el último mes de cada año del campesino X\n");
       SalidaPorDefecto.terminal("5. Toneladas que se obtuvieron en el segundo trimestre de cada año del campesino X\n");
       SalidaPorDefecto.terminal("6. Campesino ha realizado peor su trabajo en cada año\n");
       SalidaPorDefecto.terminal("7. Mes es el que produce mayores dividendos a los campesinos\n");
       SalidaPorDefecto.terminal("8. Época del año (primavera, verano, otoño o invierno) genera mayor ganancia en producción\n");
       SalidaPorDefecto.terminal("Ingresa el número de la acción a realizar: ");

    }

    static public  void ingresarDatosCampesino1() {
        SalidaPorDefecto.terminal("Ingresa todos los meses del primer campesino: (48 meses separados por coma): \n");
    }
    static public  void ingresarDatosCampesino2() {
        SalidaPorDefecto.terminal("Ingresa todos los meses del segundo campesino: (48 meses separados por coma): \n");
    }

    static public void errorIngresarDatos() {
       SalidaPorDefecto.terminal("No ingresaste los datos correctamente\n");
    }


    /**
     * Muestra la lista de campesinos.
     */
    static public void ingresarCampesino() {
        SalidaPorDefecto.terminal("1- Primer campesino\n");
        SalidaPorDefecto.terminal("2- Segundo campesino\n");
        SalidaPorDefecto.terminal("Ingresa el campesino: ");
    }
}
