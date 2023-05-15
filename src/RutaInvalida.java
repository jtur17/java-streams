import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;

public class RutaInvalida extends Exception{


    // Constructor vacio
    public RutaInvalida(){
        super();
    }

    // Constructor con un atributo
    public RutaInvalida(String mensaje){
        super(mensaje);
    }

    // Metodos
    public static void guardarMensajeError(Exception e){

        // Sacamos la fecha actual 
        LocalTime timestamp = LocalTime.now();

        // Sacamos el stackTrace
        String stackTrace = Arrays.toString(e.getStackTrace());

        // Creamos una variable en la que es el mensaje final, el que se va a guardar en el documento
        String mensajeError = e.getMessage()+ " - " + timestamp + " - " + stackTrace + "\n";

        try{

            // Ponemos la ruta donde tiene que estar el txt
            String rutaArchivo = "./logs/error_log.txt";
            File archivo = new File(rutaArchivo);

            // Crea el archivo si no existe
            if (!archivo.exists()){
                archivo.createNewFile();
            }

            // Ahora vamos a escribir dentro del archivo
            FileWriter writer = new FileWriter(archivo,true);
            writer.write(mensajeError);
            writer.close();

        } catch (IOException e1){
            System.out.println(e1.getMessage());
        }
    }

    // Imprimir mensaje de error
    public static void imprimirError(Exception e) {
        System.out.println("Error: " + e.getMessage());
        guardarMensajeError(e);
    }

}