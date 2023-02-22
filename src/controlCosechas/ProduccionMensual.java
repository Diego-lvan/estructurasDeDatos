package controlCosechas;

import estructurasLineales.ListaEstatica;

/**
 * Esta clase contienen los metotodos de la producción mensual de cosecha
 * @version 1.0
 * @author Clase ED
 */
public class ProduccionMensual {
    private Double toneladas;
   private int numMes;

    public ProduccionMensual(Double toneladas, int numMes) {
        this.toneladas = toneladas;
        this.numMes = numMes;
    }

    /**
     *
     * @return Regresa el numero de toneladas mensuales cosechadas.
     */
    public Double getToneladas() {
        return toneladas;
    }

    /**
     *
     * @return Regresa el numero del mes de la cosecha.
     */
    public int getNumMes() {
        return numMes;
    }
}
