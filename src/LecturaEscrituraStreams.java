import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;



public class LecturaEscrituraStreams {

    static StringBuilder cartelera = new StringBuilder();
    
    public static void leerEscribirByteByte(){

        // Limpio la cartelera para reutilizarlo    
        cartelera.setLength(0);
        cartelera.append("Cartelera de Cine CIFFBMOLL:" + "\n" + "\n");
        
        try(FileInputStream entrada = new FileInputStream(Ruta.rutaEntrada());
            FileOutputStream salida = new FileOutputStream(Ruta.rutaSalida())){

            int contador = 0;
            int contadorAlmohadilla = 0;

            String titulo = "";
            String año = "";
            String director = "";
            String duracion = "";
            String sinopsis = "";
            String reparto = "";
            String sesion = "";

            while(contador != -1){

                contador = entrada.read();
                char letra = (char) contador; 

                if (letra == '#'){
                    contadorAlmohadilla++;
                    continue;
                }

                if (letra != '#' && contadorAlmohadilla == 0){
                    titulo += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 1){
                    año += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 2){
                    director += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 3){
                    duracion += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 4){
                    sinopsis += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 5){
                    reparto += letra;
                }

                if (letra != '{' && contadorAlmohadilla == 6){
                    sesion += letra;
                }

                if (letra == '{'){

                    contadorAlmohadilla = 0;

                    crearCartelera(cartelera, titulo, año, director, duracion, sinopsis, reparto, sesion);

                    titulo = "";
                    año = "";
                    director = "";
                    duracion = "";
                    sinopsis = "";
                    reparto = "";
                    sesion = "";
                    continue;
                }

            }

            entrada.close();
            crearCartelera(cartelera, titulo, año, director, duracion, sinopsis, reparto, sesion);
            salida.write(cartelera.toString().getBytes());
            salida.close();

           
        } catch(Exception e){
            RutaInvalida.imprimirError(e);
        }
    }
        
    public static void crearCartelera(StringBuilder cartelera, String titulo, String año, String director, String duracion, String sinopsis, String reparto, String sesion){
        cartelera.append("-----" + titulo + "----" + "\n" + "\n");
        cartelera.append("Año: " + año + "\n" + "\n");
        cartelera.append("Director: " + director + "\n" + "\n");
        cartelera.append("Duración: " + duracion + " minutos" + "\n" + "\n");
        cartelera.append("Sinopsis: " + sinopsis + "\n" + "\n");
        cartelera.append("Reparto: " + reparto + "\n" + "\n");
        cartelera.append("Sesión: " + sesion + " horas" + "\n" + "\n");
    }

    public static void leerEscribirCarCar(){
        
        // Limpio la cartelera para reutilizarlo    
        cartelera.setLength(0);
        cartelera.append("Cartelera de Cine CIFFBMOLL:" + "\n" + "\n");

        try(FileReader entrada = new FileReader(Ruta.rutaEntrada());
            FileWriter salida = new FileWriter(Ruta.rutaSalida())) {
            
            
            int contador = 0;
            int contadorAlmohadilla = 0;

            String titulo = "";
            String año = "";
            String director = "";
            String duracion = "";
            String sinopsis = "";
            String reparto = "";
            String sesion = "";

            while(contador != -1){

                contador = entrada.read();
                char letra = (char) contador; 

                if (letra == '#'){
                    contadorAlmohadilla++;
                    continue;
                }

                if (letra != '#' && contadorAlmohadilla == 0){
                    titulo += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 1){
                    año += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 2){
                    director += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 3){
                    duracion += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 4){
                    sinopsis += letra;
                }

                if (letra != '#' && contadorAlmohadilla == 5){
                    reparto += letra;
                }

                if (letra != '{' && contadorAlmohadilla == 6){
                    sesion += letra;
                }

                if (letra == '{'){

                    contadorAlmohadilla = 0;

                    crearCartelera(cartelera, titulo, año, director, duracion, sinopsis, reparto, sesion);

                    titulo = "";
                    año = "";
                    director = "";
                    duracion = "";
                    sinopsis = "";
                    reparto = "";
                    sesion = "";
                    continue;
                }
                
                entrada.close();

                crearCartelera(cartelera, titulo, año, director, duracion, sinopsis, reparto, sesion);
                
                for (int i = 0; i < cartelera.length(); i++){
                    salida.write(cartelera.charAt(i));
                }

                salida.close();

            } catch( IOException e){
                RutaInvalida.imprimirError(e);
            }
        }

    }
}
