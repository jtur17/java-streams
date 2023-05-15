import java.util.Scanner;
import java.io.File;

public class Ruta {

    static Scanner s = new Scanner(System.in);


    // Pedimos la ruta del fichero de entrada
    public static String rutaEntrada(){

        String ruta = "";

        do{
            try{
                ruta = solicitarRutaEntrada();
            } catch(RutaInvalida e){
                RutaInvalida.imprimirError(e);
            }
            
        } while(ruta.isEmpty());
        System.out.println("La ruta de entrada es correcta");
        return ruta;
    }

    // Comprueba si la ruta del fichero existe
    public static String solicitarRutaEntrada() throws RutaInvalida{

        
        System.out.println("Introduce la ruta del fichero de entrada: ");
        String rutaEntrada = s.nextLine();

        File archivo = new File(rutaEntrada);

        if (!archivo.exists() || !archivo.isFile()){

            throw new RutaInvalida("Error, la ruta del fichero no se ha encontrado");
        }
        
        return rutaEntrada;
    }

    // Pedimos la ruta del fichero de salida
    public static String rutaSalida(){
        
        String ruta = "";

        do{
            try{
                ruta = solicitarRutaSalida();
            } catch(RutaInvalida e){
                RutaInvalida.imprimirError(e);
            }
            
        } while(ruta.isEmpty());
        System.out.println("La ruta de salida es correcta");
        return ruta;
    }


    // Comprueba si la ruta del fichero existe
    public static String solicitarRutaSalida() throws RutaInvalida{

        System.out.println("Introduce la ruta del fichero de salida: ");
        String rutaEntrada = s.nextLine();

        File archivo = new File(rutaEntrada);

        if (!archivo.exists() || !archivo.isFile()){
            throw new RutaInvalida("Error, la ruta del fichero no se ha encontrado");
        }
        
        return rutaEntrada;
    }      
}
