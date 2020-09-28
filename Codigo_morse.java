
package codigo_morse;

import java.util.Scanner;
public class Codigo_morse {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String[] codigo_morse = {
            ".-","-...","-.-.","-..",".","..-.","--.",
            "....","..",".---","-.-",".-..","--","-.",
            "---",".--.","--.-",".-.","...","-","..-",
            "...-",".--","-..-","-.--","--.."
        };
        String [] abc = {
            "a","b","c","d","e","f","g","h","i","j","k",
            "l","m","n","o","p","q","r","s","t","u","v",
            "w","x","y","z"
        };
        System.out.println("  Codigo  Morse");
        System.out.println("1- Ingresar codigo morse");
        System.out.println("2- Ingresar texto normal");
        System.out.print("- Ingrese una opcion:");
        String texto = teclado.nextLine();
        if (texto.equals("1")) {
            System.out.print("-Ingrese el codigo morse a pasar:");
            String cadena = teclado.nextLine();
            int cantidad_palabras = 1;
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i)==32) {
                    cantidad_palabras = cantidad_palabras+1;
                }
            }
            String [] palabras = new String[cantidad_palabras];
            int j = 0;
            int inicio = 0;
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i)==32) {
                    palabras[j]=cadena.substring(inicio, i);
                    j++;
                    inicio=i+1;
                }
                if (i==(cadena.length()-1)) {
                    palabras[j] = cadena.substring(inicio, cadena.length());
                }
            }
            String cadena_de_texto = "";
            for (int i = 0; i < palabras.length; i++) {
                boolean bandera = false;
                for (int k = 0; k < codigo_morse.length; k++) {
                    if (palabras[i].equals(codigo_morse[k])) {
                        cadena_de_texto = cadena_de_texto + " " + abc[k];
                        bandera=false;
                        break;
                    }else{
                        bandera=true;
                    }
                }
                if (bandera) {
                    cadena_de_texto = cadena_de_texto + " " + "NULL";
                }
            }
            System.out.println("La palabra es: "+cadena_de_texto);
        }else if (texto.equals("2")) {
            System.out.print("-Ingrese el texto a pasar:");
            String cadena = teclado.nextLine();
            String cadena_de_texto = "";
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i)!=32) {
                    String letra = "" + cadena.charAt(i);
                    for (int j = 0; j < abc.length; j++) {
                        if (letra.equalsIgnoreCase(abc[j])) {
                            cadena_de_texto=cadena_de_texto+" "+codigo_morse[j];
                        }
                    }
                }
            }
            System.out.println("El texto en morse es: "+cadena_de_texto);
        }
    }
}
