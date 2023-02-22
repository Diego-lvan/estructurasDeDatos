package utilerias.comunes;

public class Comparador {

    public  static  Integer comparadorDeObjetos(Object objeto1, Object objeto2) {
        if(objeto1.getClass().toString().equalsIgnoreCase(objeto2.getClass().toString()) == false) return null;
        if(objeto1 instanceof Number && objeto2 instanceof  Number) {
            Double numero1 = Double.parseDouble(((Number) objeto1).toString()) ;
            Double numero2 = Double.parseDouble(((Number) objeto2).toString()) ;
            return numero1.compareTo(numero2);
        }
        String toString1 = objeto1.toString();
        String toString2 = objeto2.toString();
        return toString1.compareTo(toString2);
    }
}
