package ar.edu.unju.fi.ejercicio4.main;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;
import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Jugador> jugadores = new ArrayList<>();
        int opcion;

        try {
            do {
                mostrarMenu();
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        altaJugador(jugadores, scanner);
                        break;
                    case 2:
                        mostrarJugadores(jugadores);
                        break;
                    case 3:
                        modificarPosicion(jugadores, scanner);
                        break;
                    case 4:
                        eliminarJugador(jugadores, scanner);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                        break;
                }
            } while (opcion != 5);
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un valor válido.");
        } finally {
            scanner.close();
        }
    }

    private static void mostrarMenu() {
        System.out.println("-- Menu de Opciones --");
        System.out.println("1 - Alta de jugador");
        System.out.println("2 - Mostrar todos los jugadores");
        System.out.println("3 - Modificar posición de un jugador");
        System.out.println("4 - Eliminar un jugador");
        System.out.println("5 - Salir");
        System.out.println("Seleccione una opción: ");
    }

    private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del jugador:");
        String apellido = scanner.nextLine();

        System.out.println("Ingrese la fecha de nacimiento del jugador (yyyy-mm-dd):");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());

        System.out.println("Ingrese la nacionalidad del jugador:");
        String nacionalidad = scanner.nextLine();

        System.out.println("Ingrese la estatura del jugador:");
        double estatura = scanner.nextDouble();

        System.out.println("Ingrese el peso del jugador:");
        double peso = scanner.nextDouble();

        // Mostrar las opciones de posición disponibles
        System.out.println("Seleccione la posición del jugador:");
        for (Posicion posicion : Posicion.values()) {
            System.out.println((posicion.ordinal() + 1) + " - " + posicion.name());
        }
        int opcionPosicion = scanner.nextInt();
        Posicion posicion = Posicion.values()[opcionPosicion - 1];

        // Crear el jugador y agregarlo a la lista
        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);

        System.out.println("Jugador agregado con éxito.");
    }

    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para mostrar.");
        } else {
            System.out.println("Lista de jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    private static void modificarPosicion(ArrayList<Jugador> jugadores, Scanner scanner) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para modificar.");
            return;
        }

        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del jugador:");
        String apellido = scanner.nextLine();

        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                // Mostrar las opciones de posición disponibles
                System.out.println("Seleccione la nueva posición del jugador:");
                for (Posicion posicion : Posicion.values()) {
                    System.out.println((posicion.ordinal() + 1) + " - " + posicion.name());
                }
                int opcionPosicion = scanner.nextInt();
                Posicion nuevaPosicion = Posicion.values()[opcionPosicion - 1];

                // Modificar la posición del jugador
                jugador.setPosicion(nuevaPosicion);
                System.out.println("Posición modificada con éxito.");
                return;
            }
        }

        System.out.println("No se encontró al jugador con el nombre y apellido ingresados.");
    }

    private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para eliminar.");
            return;
        }

        System.out.println("Ingrese el nombre del jugador:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese el apellido del jugador:");
        String apellido = scanner.nextLine();

        Iterator<Jugador> iterator = jugadores.iterator();
        while (iterator.hasNext()) {
            Jugador jugador = iterator.next();
            if (jugador.getNombre().equals(nombre) && jugador.getApellido().equals(apellido)) {
                iterator.remove(); // Eliminar el jugador de la lista
                System.out.println("Jugador eliminado con éxito.");
                return;
            }
        }

        System.out.println("No se encontró al jugador con el nombre y apellido ingresados.");
    }
}
