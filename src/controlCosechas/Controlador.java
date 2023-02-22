package controlCosechas;

import entradasalida.EntradaPorDefecto;
import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;
import utilerias.comunes.FuncionesString;

public class Controlador {
    private Campesino campesino1;
    private Campesino campesino2;


    public Controlador() {
        ListaEstatica producionAnual1 = new ListaEstatica(4);
        producionAnual1.agregar(new ProduccionAnual());
        producionAnual1.agregar(new ProduccionAnual());
        producionAnual1.agregar(new ProduccionAnual());
        producionAnual1.agregar(new ProduccionAnual());

        ListaEstatica producionAnual2 = new ListaEstatica(4);
        producionAnual2.agregar(new ProduccionAnual());
        producionAnual2.agregar(new ProduccionAnual());
        producionAnual2.agregar(new ProduccionAnual());
        producionAnual2.agregar(new ProduccionAnual());

        campesino1 = new Campesino(1,producionAnual1);
        campesino2 = new Campesino(2,producionAnual2);
    }

    /**
     * Es la funcion principal para ejecutar el programa.
     */
    public  void iniciar() {
        ingresarDatos();
        while(true) {
            Menu.mostrarMenu();
            int opcion = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
            if(opcion == 1) {
                promedioAnualCampesinos(); continue;
            }
            if(opcion == 2) {
               mesesMayorPromedio(); continue;
            }
            if(opcion == 3) {
                mesConMenosToneladasPorAnio(); continue;
            }
            if(opcion == 4) {
                ultimoMesDeCadaAnio();continue;
            }
            if(opcion == 5) {
                toneladasSegundoTrimestre(); continue;
            }
            if(opcion == 6) {
                peorCampesinoPorAnio();
            }
            if(opcion == 7) {
                mesMayorDividendo(); continue;
            }
            if(opcion == 8) {
                mayorProduccionPorEpoca();
            }
        }
    }


    /**
     * La funcion muestra en consola el campesino que tiene menor cosecha por cada anio.
     */
    public void peorCampesinoPorAnio() {
        ListaEstatica produccionAnuales1 = campesino1.getProducccionAnual();
        ListaEstatica produccionAnuales2 = campesino2.getProducccionAnual();

        for(int anio = 0; anio < 4; anio++) {
           ProduccionAnual produccionAnual1 = (ProduccionAnual) produccionAnuales1.obtener(anio);
           ProduccionAnual produccionAnual2 = (ProduccionAnual) produccionAnuales2.obtener(anio);
           SalidaPorDefecto.terminal("El campesino que tuvo la peor producción en el año " + anio + 1 + " es : ");
           if(produccionAnual1.sumaAnual() > produccionAnual2.sumaAnual()) {
               SalidaPorDefecto.terminal("el campesino 2" +"\n");
           }
           else if(produccionAnual2.sumaAnual() > produccionAnual1.sumaAnual()) {
               SalidaPorDefecto.terminal("el campesino 1"+"\n");
           }
           else {
               SalidaPorDefecto.terminal("los dos campesinos vendieron la misma cantidad de toneladas" +"\n");
           }
        }
    }

    /**
     * Muestra el mes en el que se realizan la mayor cantidad de cosecha de los dos campesinos.
     */
    public void mesMayorDividendo() {
        ListaEstatica produccionAnuales1 = campesino1.getProducccionAnual();
        ListaEstatica produccionAnuales2 = campesino2.getProducccionAnual();
        Double mayorDividendo =  -1.0;
        int idMesMayorDividendo = -1;
        for(int mes = 0; mes < 12; mes++) {
            Double mesDividendo = 0.0;
            for(int anio = 0; anio < 4; anio++) {
                ProduccionAnual produccionAnual1 = (ProduccionAnual) produccionAnuales1.obtener(anio);
                ProduccionAnual produccionAnual2 = (ProduccionAnual) produccionAnuales2.obtener(anio);
                ProduccionMensual produccionMensual1 = produccionAnual1.obtenerMes(mes);
                ProduccionMensual produccionMensual2 = produccionAnual2.obtenerMes(mes);
                mesDividendo += produccionMensual1.getToneladas();
                mesDividendo += produccionMensual2.getToneladas();
            }
            if(mesDividendo > mayorDividendo) {
                mayorDividendo = mesDividendo;
                idMesMayorDividendo = mes;
            }
        }
        SalidaPorDefecto.terminal("El mes donde cosechan más es el mes " + (idMesMayorDividendo + 1) + " con una catidadd total cosechada de " + mayorDividendo + "\n");
    }

    /**
     * El metodo lee los datos de las cosechas y llena las producciones anuales de cada campesino.
     */
    private void ingresarDatos() {
        Menu.ingresarDatosCampesino1();
        String mesesCampesino1Str = EntradaPorDefecto.consolaCadenas();
        ListaEstatica listaMesesCampesino1 =  FuncionesString.splitByChar(mesesCampesino1Str,',');
        if(listaMesesCampesino1.getTope() < 47) {
            Menu.errorIngresarDatos();
            ingresarDatos();
        }

        Menu.ingresarDatosCampesino2();
        String mesesCampesino2Str = EntradaPorDefecto.consolaCadenas();
        ListaEstatica listaMesesCampesino2 =  FuncionesString.splitByChar(mesesCampesino2Str,',');
        if(listaMesesCampesino2.getTope() < 47) {
            Menu.errorIngresarDatos();
            ingresarDatos();
        }

        for(int anio = 0; anio < 4; anio++) {
            for(int mes = 0; mes < 12; mes++) {
                int curMes = (anio * 12)  + mes;
                Double curMesCampesino1 = Double.parseDouble((String) listaMesesCampesino1.obtener(curMes)) ;
                Double curMesCampesino2 = Double.parseDouble((String) listaMesesCampesino2.obtener(curMes)) ;
                ListaEstatica producccionAnuales1 = campesino1.getProducccionAnual();
                ListaEstatica producccionAnuales2 = campesino2.getProducccionAnual();
                ProduccionAnual produccionAnual1 = (ProduccionAnual) producccionAnuales1.obtener(anio);
                ProduccionAnual produccionAnual2 = (ProduccionAnual) producccionAnuales2.obtener(anio);
                produccionAnual1.getMeses().agregar(new ProduccionMensual(curMesCampesino1,mes));
                produccionAnual2.getMeses().agregar(new ProduccionMensual(curMesCampesino2,mes));
            }
        }
    }

    /**
     * Muestra el promedio anual de los dos campesinos por consoola.
     */
    public void promedioAnualCampesinos() {
        ListaEstatica produccionAnuales1 = campesino1.getProducccionAnual();
        ListaEstatica produccionAnuales2 = campesino2.getProducccionAnual();
        for(int anio = 0; anio < 4; anio ++) {
            ProduccionAnual produccionAnual1 = (ProduccionAnual) produccionAnuales1.obtener(anio);
            ProduccionAnual produccionAnual2 = (ProduccionAnual) produccionAnuales2.obtener(anio);
            Double promedio1 = produccionAnual1.promedioAnual();
            Double promedio2 = produccionAnual2.promedioAnual();
            SalidaPorDefecto.terminal("Promedios del año " + (anio + 1) + "\n");
            SalidaPorDefecto.terminal("Promedio del primer campesino " + promedio1 + "\n");
            SalidaPorDefecto.terminal("Promedio del segundo campesino " + promedio2 + "\n");
        }
    }

    /**
     * Muestra los meses de cosecha de cada anio que son mayor al promedio.
     */
    public  void mesesMayorPromedio() {
        Menu.ingresarCampesino();
        int campesinoID = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        Campesino curCampesino;
        if(campesinoID == 1) {
            curCampesino = campesino1;
        } else {
            curCampesino = campesino1;
        }
        ListaEstatica produccionAnuales = curCampesino.getProducccionAnual();

        for(int anio = 0; anio < 4; anio++) {
            ProduccionAnual produccionAnual = (ProduccionAnual) produccionAnuales.obtener(anio);
            int cantidadMayorPromedio = produccionAnual.cantidadMesesMayorPromedio();
            SalidaPorDefecto.terminal("En el año " + (anio + 1) + " se obtuvieron " + cantidadMayorPromedio + " meses mayor al promedio anual\n");
        }
    }

    /**
     * Lee el id del campesino y muestra el mes donde se obtuvo la menor cantidad de toneladas por cada anio.
     */

    public  void mesConMenosToneladasPorAnio() {
        Menu.ingresarCampesino();
        int campesinoID = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        Campesino curCampesino;
        if(campesinoID == 1) {
            curCampesino = campesino1;
        } else {
            curCampesino = campesino1;
        }
        ListaEstatica produccionAnuales = curCampesino.getProducccionAnual();
        for(int anio = 0; anio < 4; anio++) {
            ProduccionAnual produccionAnual = (ProduccionAnual) produccionAnuales.obtener(anio);
            ProduccionMensual minMes = produccionAnual.menorMes();
            Double minToneladasMensual = minMes.getToneladas();
            int numeroMes = minMes.getNumMes() + 1;
            SalidaPorDefecto.terminal("En el año " + (anio + 1) + " la mínima producción mensual fue de " + minToneladasMensual + " toneladas en el mes " + numeroMes + "\n");
        }
    }

    /**
     * Lee el id del campesino y muestra la cantidd de toneladas del ultimo mes de cada anio.
     */
    public void ultimoMesDeCadaAnio() {
        Menu.ingresarCampesino();
        int campesinoID = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        Campesino curCampesino;
        if(campesinoID == 1) {
            curCampesino = campesino1;
        } else {
            curCampesino = campesino1;
        }
        ListaEstatica produccionAnuales = curCampesino.getProducccionAnual();
        for(int anio = 0; anio < 4; anio++) {
            ProduccionAnual produccionAnual = (ProduccionAnual) produccionAnuales.obtener(anio);
            ProduccionMensual ultimoMes = produccionAnual.obtenerMes(11);
            SalidaPorDefecto.terminal("En el último mes del año " + (anio + 1) + " se obtuvieron " + ultimoMes.getToneladas() + " toneladas de cosecha\n");
        }
    }

    /**
     * Lee el id del campesino y muestra las toneladas cosechadad en el segundo triemestre.
     */
    public void toneladasSegundoTrimestre() {
        Menu.ingresarCampesino();
        int campesinoID = Integer.parseInt(EntradaPorDefecto.consolaCadenas());
        Campesino curCampesino;
        if(campesinoID == 1) {
            curCampesino = campesino1;
        } else {
            curCampesino = campesino1;
        }
        ListaEstatica produccionAnuales = curCampesino.getProducccionAnual();
        for(int anio = 0; anio < 4; anio++) {
            ProduccionAnual produccionAnual = (ProduccionAnual) produccionAnuales.obtener(anio);
            Double sumatoriaTrimestre = produccionAnual.sumatoriaTrimestre(2);
            SalidaPorDefecto.terminal("La sumatorio del trimestre 2 en el año " + (anio + 1) + " es de " + sumatoriaTrimestre + "\n");
        }
    }

    /**
     * Muestra la epoca del anio  (primavera, verano, otoño o invierno) con la mayor produccion de los campesinos.
     */
    public void  mayorProduccionPorEpoca() {
        ListaEstatica produccionAnuales1 = campesino1.getProducccionAnual();
        ListaEstatica produccionAnuales2 = campesino2.getProducccionAnual();
        Double primavera = 0.0, verano = 0.0, otonio = 0.0, invierno = 0.0;
        for(int anio = 0; anio < 4; anio ++) {
            ProduccionAnual produccionAnual1 = (ProduccionAnual) produccionAnuales1.obtener(anio);
            ProduccionAnual produccionAnual2 = (ProduccionAnual) produccionAnuales2.obtener(anio);
            primavera += produccionAnual1.obtenerSumatoriaPorRango(2,5);
            primavera += produccionAnual2.obtenerSumatoriaPorRango(2,5);

            verano += produccionAnual1.obtenerSumatoriaPorRango(5,8);
            verano += produccionAnual2.obtenerSumatoriaPorRango(5,8);

            otonio +=  produccionAnual1.obtenerSumatoriaPorRango(8,11);
            otonio += produccionAnual2.obtenerSumatoriaPorRango(8,11);

            invierno += produccionAnual1.obtenerSumatoriaPorRango(11,11) + produccionAnual1.obtenerSumatoriaPorRango(0,2);
            invierno += produccionAnual2.obtenerSumatoriaPorRango(11,11) + produccionAnual2.obtenerSumatoriaPorRango(0,2);


        }
        Double maximaEpoca = Math.max(primavera,Math.max(verano,Math.max(otonio,invierno)));
        if(maximaEpoca.equals(primavera)) {
            SalidaPorDefecto.terminal("La epoca  donde se genera más producción es primavera con " + maximaEpoca + " toneladas\n");
        }
        else if(maximaEpoca.equals(verano)) {
            SalidaPorDefecto.terminal("La epoca  donde se genera más producción es verano con " + maximaEpoca + " toneladas\n");
        }
        else if(maximaEpoca.equals(otonio)) {
            SalidaPorDefecto.terminal("La epoca  donde se genera más producción es otoño con " + maximaEpoca + " toneladas\n");
        }
        else {
            SalidaPorDefecto.terminal("La epoca  donde se genera más producción es invierno con " + maximaEpoca + " toneladas\n");
        }
    }
}
