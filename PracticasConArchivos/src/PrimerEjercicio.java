//Hecho por: Andrés López Corrales
import java.io.*;
import java.util.*;

public class PrimerEjercicio { //Ejercicio Histograma - Divina Comedia
    public static final String RUTA = "src\\Resources\\divina_comedia_sp.txt"; //ruta archivo texto
    static String line; //linea para leer dentro del archivo de la Divina Comedia
    public static void main(String[] args) throws IOException {

        Map <Integer, Integer> histograma = new HashMap<>(); //HashMap para sacar longitud y frecuencia

        BufferedReader br = new BufferedReader(new FileReader(RUTA)); //BR para leer archivo

        //Leer y sumar frecuancia de longitud de palabras
            while ((line = br.readLine()) != null) {
                String[] realWords = line.split("\\s+");
                for (String words : realWords) {
                    if (words.matches("[a-zA-Z]{2,10}")) { //para segregarlo en puras palabras de longitudes que van del 2 al 10
                        histograma.put(words.length(), histograma.getOrDefault(words.length(), 0) + 1);
                    }
                }
            }

            br.close(); //cerrar el BufferedReader

        //Imprimir frecuencia de las longitudes de las palabras
        for (Map.Entry<Integer, Integer> entry : histograma.entrySet()) {
            System.out.println("Longitud " + entry.getKey() + ": " + entry.getValue() + " "+
                    "- Histograma: "+ "*".repeat(entry.getValue()));
        }

    }//end main
}