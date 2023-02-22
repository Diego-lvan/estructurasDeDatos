package controlCosechas;

import estructurasLineales.ListaEstatica;

public class Campesino {
    int idCampesino;
    ListaEstatica producccionAnual;

    /**
     * Para inicializar el objeto se necesita pasar el id del campesino y una lista de las producciones anuales.
     * @param idCampesino Id del campesino.
     * @param producccionAnual Lista estatica de las producciones anuales.
     */
    public Campesino(int idCampesino, ListaEstatica producccionAnual) {
        this.idCampesino = idCampesino;
        this.producccionAnual = producccionAnual;
    }


    public ListaEstatica getProducccionAnual() {
        return producccionAnual;
    }





}
