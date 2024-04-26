package ar.edu.unju.fi.ejercicio2.main;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Efemeride> listaEfemerides = new ArrayList<>();
        int opcion;

        do {
            System.out.println("--Menu de Acciones--");
            System.out.println("1 - Crear Efemeride");
            System.out.println("2 - Mostrar Efemeride");
            System.out.println("3 - Eliminar Efemeride");
            System.out.println("4 - Modificar Efemeride");
            System.out.println("5 - Salir");
            System.out.println("Seleccionar una opcion");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Creacion de nueva Efemeride");
                    System.out.println("Codigo: ");
                    String codigo = sc.next();
                    System.out.println("Dia: ");
                    int dia = sc.nextInt();

                    System.out.println("Mes (1 a 12): ");
                    int numeroMes = sc.nextInt();
                    Mes mes;

                    switch (numeroMes) {
                        case 1:
                            mes = Mes.ENERO;
                            break;
                        case 2:
                            mes = Mes.FEBRERO;
                            break;
                        case 3:
                            mes = Mes.MARZO;
                            break;
                        case 4:
                            mes = Mes.ABRIL;
                            break;
                        case 5:
                            mes = Mes.MAYO;
                            break;
                        case 6:
                            mes = Mes.JUNIO;
                            break;
                        case 7:
                            mes = Mes.JULIO;
                            break;
                        case 8:
                            mes = Mes.AGOSTO;
                            break;
                        case 9:
                            mes = Mes.SEPTIEMBRE;
                            break;
                        case 10:
                            mes = Mes.OCTUBRE;
                            break;
                        case 11:
                            mes = Mes.NOVIEMBRE;
                            break;
                        case 12:
                            mes = Mes.DICIEMBRE;
                            break;
                        default:
                            System.out.println("Numero de mes invalido.Se asigna Enero por defecto ");
                            mes = Mes.ENERO;
                            break;
                    }

                    sc.nextLine(); // Limpiar el buffer del scanner
                    System.out.println("Detalle: ");
                    String detalle = sc.nextLine();

                    Efemeride nuevaEfemeride = new Efemeride(codigo, mes, LocalDate.of(LocalDate.now().getYear(), numeroMes, dia), detalle);
                    listaEfemerides.add(nuevaEfemeride);

                    System.out.println("Efemeride creada con éxito");
                    break;

                // Caso 2: Mostrar Efemerides
                case 2:
                    if (listaEfemerides.isEmpty()) {
                        System.out.println("No hay efemerides para mostrar.");
                    } else {
                        System.out.println("Lista de Efemerides");
                        for (Efemeride efemeride : listaEfemerides) {
                            System.out.println("Codigo: " + efemeride.getCodigo());
                            System.out.println("Dia: " + efemeride.getDia());
                            System.out.println("Mes: " + efemeride.getMes());
                            System.out.println("Detalle: " + efemeride.getDetalle());
                            System.out.println("---------------------------");
                        }
                    }
                    break;

                // Caso 3: Eliminar Efemerides
                case 3:
                    if (listaEfemerides.isEmpty()) {
                        System.out.println("No hay efemerides para eliminar");
                    } else {
                        System.out.println("Lista de efemerides");
                        for (int i = 0; i < listaEfemerides.size(); i++) {
                            Efemeride efemeride = listaEfemerides.get(i);
                            System.out.println((i + 1) + ". Codigo: " + efemeride.getCodigo() + ". Mes " + efemeride.getMes() + ". Dia: " + efemeride.getDia());
                        }

                        System.out.print("Seleccione el número de la efeméride que desea eliminar: ");
                        int numeroEfemeride = sc.nextInt();
                        if (numeroEfemeride < 1 || numeroEfemeride > listaEfemerides.size()) {
                            System.out.println("Número de efeméride inválido.");
                        } else {
                            listaEfemerides.remove(numeroEfemeride - 1);
                            System.out.println("Efeméride eliminada con éxito.");
                        }
                    }
                    break;

                // Caso 4: Modificar Efemerides
                case 4:
                    if (listaEfemerides.isEmpty()) {
                        System.out.println("No hay efemérides para modificar.");
                    } else {
                        System.out.println("Lista de Efemérides:");
                        for (int i = 0; i < listaEfemerides.size(); i++) {
                            Efemeride efemeride = listaEfemerides.get(i);
                            System.out.println((i + 1) + ". Código: " + efemeride.getCodigo() + ", Mes: " + efemeride.getMes() + ", Día: " + efemeride.getDia());
                        }

                        System.out.print("Seleccione el número de la efeméride que desea modificar: ");
                        int numeroEfemeride = sc.nextInt();
                        if (numeroEfemeride < 1 || numeroEfemeride > listaEfemerides.size()) {
                            System.out.println("Número de efeméride inválido.");
                        } else {
                            Efemeride efemerideSeleccionada = listaEfemerides.get(numeroEfemeride - 1);
                            System.out.println("Ingrese los nuevos detalles para la efeméride:");

                            System.out.print("Nuevo código: ");
                            String nuevoCodigo = sc.next();
                            efemerideSeleccionada.setCodigo(nuevoCodigo);

                            System.out.print("Nuevo día: ");
                            int nuevoDia = sc.nextInt();

                            System.out.println("Nuevo mes (ingrese el número correspondiente al mes):");
                            for (int i = 0; i < Mes.values().length; i++) {
                                System.out.println((i + 1) + ". " + Mes.values()[i]);
                            }
                            int opcionMes = sc.nextInt();
                            if (opcionMes < 1 || opcionMes > Mes.values().length) {
                                System.out.println("Opción de mes inválida.");
                            } else {
                                efemerideSeleccionada.setMes(Mes.values()[opcionMes - 1]);
                            }

                            sc.nextLine(); // Limpiar el buffer del scanner
                            System.out.print("Nuevo detalle: ");
                            String nuevoDetalle = sc.nextLine();
                            efemerideSeleccionada.setDetalle(nuevoDetalle);

                            System.out.println("Efeméride modificada con éxito.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (opcion != 5);

        sc.close();
    }
}
