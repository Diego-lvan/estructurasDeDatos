package estructurasnolineales;

import entradasalida.SalidaPorDefecto;
import estructurasLineales.ListaEstatica;

public class Matriz3 {
    protected int renglones;
    protected int columnas;
    protected  int profundidad;
    protected Object informacion[][][];

    public Matriz3(int renglones, int columnas, int profundidad) {
        this.renglones = renglones;
        this.columnas = columnas;
        this.profundidad = profundidad;
        informacion = new Object[renglones][columnas][profundidad];
    }

    public Matriz3(int renglones, int columnas, int profundidad, Object defecto) {
        this.renglones = renglones;
        this.columnas = columnas;
        this.profundidad = profundidad;
        informacion = new Object[renglones][columnas][profundidad];
        rellenar(defecto);
    }

    public void rellenar(Object info) {
        for(int curRenglon = 0; curRenglon < this.renglones; curRenglon++) {
            for(int curCol = 0; curCol < this.columnas; curCol++) {
                for(int curProfundidad = 0; curProfundidad < this.profundidad; curProfundidad++) {
                    informacion[curRenglon][curCol][curProfundidad] = info;
                }
            }
        }
    }

    public boolean validarRango(int indice, int limSup) {
        if(indice >= 0 && indice < limSup) return true;
        return false;
    }

    public boolean cambiar(int fila, int columna, int prof, Object nuevoVal) {
      if(validarRango(fila,renglones) && validarRango(columna, columnas) && validarRango(prof,profundidad)) {
            informacion[fila][columna][prof] = nuevoVal;
            return true;
      }
      return  false;
    }

    public Object obtener(int fila, int columna, int prof) {
        if(validarRango(fila,renglones) && validarRango(columna, columnas) && validarRango(prof,profundidad)) {
            return informacion[fila][columna][prof];
        }
        return  null;
    }

    public void imprimirXColumnas() {
        // lo trataremos como rebanadas donde cada rebanada es una columna
        for(int cadaRebanada = 0; cadaRebanada < columnas; cadaRebanada++) {
            for(int cadaRenglon = 0; cadaRenglon < renglones; cadaRenglon++) {
                for(int cadaColumna = 0; cadaColumna < profundidad; cadaColumna++) {
                    SalidaPorDefecto.terminal(informacion[cadaRenglon][cadaRebanada][cadaColumna] + " ");
                }
                SalidaPorDefecto.terminal("\n");
            }
            SalidaPorDefecto.terminal("\n");
        }
    }


    public ListaEstatica aMtrices2() {
        // obtener cada rebanada ( que es una matriz 2D)
        ListaEstatica matrices2 = new ListaEstatica(columnas);
        for(int col = 0; col < columnas; col++) {
            Matriz2 matriz2Temporal = new Matriz2(renglones,profundidad);
            for(int curRen = 0; curRen < renglones; curRen++) {
                for(int curProf = 0; curProf < profundidad; curProf++) {
                    matriz2Temporal.cambiar(curRen,curProf,informacion[curRen][col][curProf]);
                }
            }
            matrices2.agregar(matriz2Temporal);
        }

        return matrices2;
    }



    public void setRenglones(int renglones) {
        this.renglones = renglones;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setProfundidad(int profundidad) {
        this.profundidad = profundidad;
    }
}
