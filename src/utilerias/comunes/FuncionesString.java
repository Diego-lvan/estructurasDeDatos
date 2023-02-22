package utilerias.comunes;

import estructurasLineales.ListaEstatica;

public class FuncionesString {

   static public ListaEstatica splitByChar(String string, char sep) {
        int ocurrencias = 0;
        for(int idx = 0; idx < string.length(); idx++) {
            if(string.charAt(idx) == sep) {
                ocurrencias++;
            }
        }
        ListaEstatica res = new ListaEstatica(ocurrencias + 1);
        StringBuilder curStr = new StringBuilder();
        for(int idx = 0; idx < string.length(); idx++) {
            if(string.charAt(idx) == sep) {
                res.agregar(curStr.toString());
                curStr = new StringBuilder();
            } else {
                curStr.append(string.charAt(idx));
            }
        }
        if(!curStr.equals("")) {
            res.agregar(curStr.toString());
        }
        return res;
    }

     public static boolean startsWith(String str, String start) {
        for(int idx = 0; idx < start.length(); idx++) {
            if(str.charAt(idx) != start.charAt(idx)) return false;
        }
        return true;
    }
}
