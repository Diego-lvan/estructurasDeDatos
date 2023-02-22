package controlCosechas;

import estructurasLineales.ListaEstatica;
/**
 * Esta clase contienen los metotodos de la producción anual de cosecha
 * @version 1.0
 * @author Clase ED
 */
public class ProduccionAnual {
    final private int  NUM_MESES = 12;
    ListaEstatica meses;



    public ProduccionAnual() {
        meses = new ListaEstatica(NUM_MESES);
    }

    /**
     * Este metodo suma todas las cosechas mensuales realizadas y las regresa.
     * @return Regresa la suma de todas las cosechas en el anio.
     */

    public Double sumaAnual() {
        Double suma = 0.0;
        for(int mes = 0; mes < 12; mes++) {
            ProduccionMensual produccionMensual = (ProduccionMensual) meses.obtener(mes);
            suma += produccionMensual.getToneladas();
        }
        return suma;
    }

    /**
     * Hace el promedio de las cosechas mensuales del anio actual.
     * @return Regresa el promedio de las cosechas mensuales.
     */
    Double promedioAnual() {
        Double sumaAnual = sumaAnual();
        Double promedio = sumaAnual / NUM_MESES;
        return promedio;
    }

    /**
     *
     * @return Regresa la cantidad de cosechas mensuales que sobrepasan el promedio anual.
     */
    public int  cantidadMesesMayorPromedio() {
        double promedio = promedioAnual();
        int cantidadMeses = 0;
        for(int mes = 0; mes < NUM_MESES; mes++) {
            ProduccionMensual produccionMensual = (ProduccionMensual) meses.obtener(mes);
            if(produccionMensual.getToneladas() > promedio) {
                cantidadMeses++;
            }
        }
        return cantidadMeses;
    }

    /**
     *
     * @return Regresa el mes con menor cosecha en el anio.
     */

    public ProduccionMensual menorMes() {
        Double menor = Double.MAX_VALUE;
        ProduccionMensual mesMenor = null ;
        for(int mes = 0; mes < NUM_MESES; mes++) {
            ProduccionMensual mesActual = (ProduccionMensual) meses.obtener(mes);
            if(mesActual.getToneladas() < menor) {
                menor = mesActual.getToneladas();
                mesMenor = mesActual;
            }
        }
        return mesMenor;
    }

    /**
     * @param mesId Es el identificador del mes 0 - 11.
     * @return Regresa la produccion mensual en el indice especificado por mesId.
     */
    public ProduccionMensual obtenerMes(int mesId) {
        if(mesId < 0 || mesId >= NUM_MESES) return null;
        return (ProduccionMensual) meses.obtener(mesId);
    }

    /**
     * Realiza una sumatoria de las cosechas mensuales trimestre del anio especificado (1 - 4) y la regresa.
     * @param numTrimestre Es el trimestre del cual se quiere obtener la sumatoria (1 - 4).
     * @return Regresa la sumatoria del trimestre y null si se da un trimestre invalido.
     */
    public Double sumatoriaTrimestre(int numTrimestre) {
        if(numTrimestre < 1 || numTrimestre > 4) return null;
        int finTrimestre = numTrimestre * 3;
        int inicioTrimestre = finTrimestre - 3;
        Double sumaTrimestral = 0.0;
        for(int idxMes = inicioTrimestre; idxMes < finTrimestre; idxMes++) {
            ProduccionMensual mesActual = (ProduccionMensual) meses.obtener(idxMes);
            sumaTrimestral += mesActual.getToneladas();
        }
        return sumaTrimestral;
    }

    /**
     * @param inicio Es el indice que indica el inicio del rango.
     * @param fin Es el indice que indica el fin del rango.
     * @return Regresa la sumatoria de la cosecha mensual en el rango especificado, regresa null si se da un rango invalido.
     */
    public Double obtenerSumatoriaPorRango(int inicio, int fin) {
        if(  inicio < 0 || fin > 11) {
            return null;
        }
        Double suma = 0.0;
        for(int mes = inicio; mes <= fin; mes++) {
            ProduccionMensual produccionMensual = (ProduccionMensual) meses.obtener(mes);
            suma += produccionMensual.getToneladas();
        }
        return suma;
    }

    public ListaEstatica getMeses() {
        return meses;
    }


}
