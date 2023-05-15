import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        int opcion;

        while (!exit) {
            System.out.println("1. Lectura y escritura del fichero de cartelera byte a byte (byte Streams).");
            System.out.println("2. Lectura y escritura de fichero de cartelera carácter a carácter (character Streams).");
            System.out.println("3. Lectura y escritura de fichero línea a línea con buffers (character Streams).");
            System.out.println("4. Salir");

            try {
                System.out.print("Elige una opción: ");
                opcion = s.nextInt();
            } catch (InputMismatchException e) {

                System.out.println("Entrada inválida. Introduzca un número entero.");
                s.nextLine(); // limpiar el búfer del scanner
                continue; // volver a la parte superior del bucle while
            }

            switch (opcion) {

                case 1:
                    Ruta.rutaEntrada();
                    break;

                case 2:
                    Ruta.rutaSalida();
                    break;

                case 3:
                    LecturaEscrituraStreams.leerEscribirCarCar();
                    break;

                case 4:
                    System.out.println("Adios!!");
                    exit = true;
                    break;
            }

        }
    }
}