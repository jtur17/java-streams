import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.Buffer;

import javax.xml.catalog.Catalog;


public class LecturaEscrituraStreams {
    
    public static void leerEscribirByteByte(){

        int i; 
        
        try(FileInputStream fin = new FileInputStream(Ruta.rutaEntrada());
            FileOutputStream fout = new FileOutputStream(Ruta.rutaSalida())){

            do {
                // Read devuelve un entero perteneciente al código
                // ascii del byte leido

                i = fin.read();
                if ( i != -1){
                    fout.write(i);
                }

            } while( i != -1); // Cuando i es igual a -1, se ha 
            // alcanzado el final del archivo EOF
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void leerEscribirCarCar(){

        // Definimos los archivos a usar
        File entrada = new File(Ruta.rutaEntrada());
        File salida = new File(Ruta.rutaSalida());

        try(FileReader lector = new FileReader(entrada);
            FileWriter escritor = new FileWriter(salida)){

            int c;

            while ((c = lector.read()) != -1){
                escritor.write(c);
            }

            System.out.println("Archivo copiado exitosamente.");

        } catch(Exception e){
            RutaInvalida.imprimirError(e);
        }
    }

    public static void leerEscribirBuffer(){

        // Definimos los archivos a usar
        File entrada = new File(Ruta.rutaEntrada());
        File salida = new File(Ruta.rutaSalida());


        try(BufferedReader lector = new BufferedReader(new FileReader(entrada));
            BufferedWriter escritor = new BufferedWriter(new FileWriter(salida))){

            // Construye un BufferedReader
            BufferedReader lectorMejorado = new BufferedReader(lector);
            
            // Defino variables
            boolean eof = false;
            String lineaLeida = "";
            String[] broken_text = null;

            while(!eof){

                // Lee una linea entera
                lineaLeida = lectorMejorado.readLine();

                // Una vez leida la linea la podemos partir con el metodo split,
                // suele ser muy útil
                broken_text = lineaLeida.split(" ");

            }
                



        } catch(Exception e){
            RutaInvalida.imprimirError(e);
        }
        
    }
}
