//Hecho por: Andrés López Corrales
import java.io.*;

public class SegundoEjercicio { //Ejercicio IO archivos mat
    public static final String RUTAMATA = "src\\Resources\\a.mat"; //Ruta a.mat
    public static final String RUTAMATB = "src\\Resources\\b.mat"; //Ruta b.mat
    public static final String RUTAMATC = "src\\Resources\\c.mat"; //Ruta c.mat
    public static void main(String[] args) throws IOException {

        //Leer el archivo a.mat
        DataInputStream leerArchivoMatA = new DataInputStream(new FileInputStream(RUTAMATA));

        int renglonesMatA = leerArchivoMatA.readByte(); // Renglones: 3
        int columnasMatA = leerArchivoMatA.readByte(); //Columnas: 3

        Double[][] datosMatA = new Double[renglonesMatA][columnasMatA];

        //Datos matriz a.mat
        System.out.println("Matriz a.mat: ");
        for (int i = 0; i < renglonesMatA; i++) {
            for (int j = 0; j < columnasMatA; j++) {
                datosMatA[i][j] = leerArchivoMatA.readDouble();
                System.out.print(datosMatA[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(".............");

        //Leer el archivo b.mat
        DataInputStream leerArchivoMatB = new DataInputStream(new FileInputStream(RUTAMATB));

        int renglonesMatB = leerArchivoMatB.readByte(); // Renglones: 3
        int columnasMatB = leerArchivoMatB.readByte(); //Columnas: 3

        Double[][] datosMatB = new Double[renglonesMatB][columnasMatB];

        //Datos matriz b.mat
        System.out.println("Matriz b.mat: ");
        for (int i = 0; i < renglonesMatB; i++) {
            for (int j = 0; j < columnasMatB; j++) {
                datosMatB[i][j] = leerArchivoMatB.readDouble();
                System.out.print(datosMatB[i][j] + " ");
            }
            System.out.println();
        }

        //multiplicar matrices a.mat y b.mat
        Double[][] cMat = new Double[renglonesMatA][columnasMatB];
        for (int i = 0; i < cMat.length; i++) {
            for (int j = 0; j < cMat[0].length; j++) {
                cMat[i][j] = 0.0;
                for (int k = 0; k < columnasMatB; k++) {
                    cMat[i][j] += datosMatA[i][k] * datosMatB[k][j];
                }
            }
        }
        System.out.println("............");

        //imprimir matriz multiplicada
        System.out.println("Matriz multiplicada: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cMat[i][j] + " ");
            }
            System.out.println();
        }

        //Escribir los datos de c.mat en un archivo (Output)
        DataOutputStream escribirCMat = new DataOutputStream(new FileOutputStream(RUTAMATC));

        for (int i = 0; i < renglonesMatA; i++) {
            for (int j = 0; j < columnasMatB; j++) {
                escribirCMat.writeDouble(cMat[i][j]);
            }
        }

    }//end main
}
