package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> listaProductos = new ArrayList<>();

        int opcion;

        do {
            try {
                System.out.println("--Menu de Opciones--");
                System.out.println("1- Crear Producto");
                System.out.println("2- Mostrar Producto");
                System.out.println("3- Modificar Producto");
                System.out.println("4- Salir");
                System.out.println("Seleccione una opcion:");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        // Solicitar al usuario los datos para crear un nuevo producto
                        System.out.println("Creación de nuevo producto:");
                        System.out.print("Código: ");
                        int codigo = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer del scanner

                        System.out.print("Descripción: ");
                        String descripcion = scanner.nextLine();

                        System.out.print("Precio unitario: ");
                        double precioUnitario = scanner.nextDouble();
                        scanner.nextLine(); // Limpiar el buffer del scanner

                        // Mostrar al usuario las opciones disponibles para origen de fabricación
                        System.out.println("------ Origen de fabricación ------");
                        System.out.println("1 - Argentina");
                        System.out.println("2 - China");
                        System.out.println("3 - Brasil");
                        System.out.println("4 - Uruguay");
                        System.out.print("Elija una opción: ");
                        int opcionOrigen = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer del scanner

                        Producto.OrigenFabricacion origenFabricacion;
                        switch (opcionOrigen) {
                            case 1:
                                origenFabricacion = Producto.OrigenFabricacion.ARGENTINA;
                                break;
                            case 2:
                                origenFabricacion = Producto.OrigenFabricacion.CHINA;
                                break;
                            case 3:
                                origenFabricacion = Producto.OrigenFabricacion.BRASIL;
                                break;
                            case 4:
                                origenFabricacion = Producto.OrigenFabricacion.URUGUAY;
                                break;
                            default:
                                System.out.println("Opción no válida para origen de fabricación. Se asignará Argentina por defecto.");
                                origenFabricacion = Producto.OrigenFabricacion.ARGENTINA;
                                break;
                        }

                        // Mostrar al usuario las opciones disponibles para categoría
                        System.out.println("------ Categoría ------");
                        System.out.println("1 - Telefonía");
                        System.out.println("2 - Informática");
                        System.out.println("3 - Electro hogar");
                        System.out.println("4 - Herramientas");
                        System.out.print("Elija una opción: ");
                        int opcionCategoria = scanner.nextInt();
                        scanner.nextLine(); // Limpiar el buffer del scanner

                        Producto.Categoria categoria;
                        switch (opcionCategoria) {
                            case 1:
                                categoria = Producto.Categoria.TELEFONIA;
                                break;
                            case 2:
                                categoria = Producto.Categoria.INFORMATICA;
                                break;
                            case 3:
                                categoria = Producto.Categoria.ELECTROHOGAR;
                                break;
                            case 4:
                                categoria = Producto.Categoria.HERRAMIENTAS;
                                break;
                            default:
                                System.out.println("Opción no válida para categoría. Se asignará Telefonía por defecto.");
                                categoria = Producto.Categoria.TELEFONIA;
                                break;
                        }

                        // Crear un nuevo objeto Producto con los datos proporcionados
                        Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, origenFabricacion, categoria);

                        // Agregar el nuevo producto al ArrayList
                        listaProductos.add(nuevoProducto);

                        System.out.println("Producto creado con éxito.");
                        break;

                    case 2:
                        if (listaProductos.isEmpty()) {
                            System.out.println("No hay productos para mostrar");

                        } else {
                            System.out.println("Lista de productos");
                            for (Producto producto : listaProductos) {
                                System.out.println("Código: " + producto.getCodigo());
                                System.out.println("Descripción: " + producto.getDescripcion());
                                System.out.println("Precio unitario: " + producto.getPrecioUnitario());
                                System.out.println("Origen de fabricación: " + producto.getOrigenFabricacion());
                                System.out.println("Categoría: " + producto.getCategoria());
                                System.out.println("-----------------------------------");
                            }
                        }
                        break;

                    case 3:
                        // Verificar si hay productos en la lista
                        if (listaProductos.isEmpty()) {
                            System.out.println("No hay productos para modificar.");
                        } else {
                            // Mostrar los productos en la lista
                            System.out.println("Lista de productos:");
                            for (int i = 0; i < listaProductos.size(); i++) {
                                Producto producto = listaProductos.get(i);
                                System.out.println((i + 1) + ". Código: " + producto.getCodigo() + ", Descripción: " + producto.getDescripcion());
                            }

                            // Solicitar al usuario que elija un producto a modificar
                            System.out.print("Seleccione el número del producto que desea modificar: ");
                            int indiceProducto = scanner.nextInt();
                            scanner.nextLine(); // Limpiar el buffer del scanner

                            // Verificar si el índice es válido
                            if (indiceProducto < 1 || indiceProducto > listaProductos.size()) {
                                System.out.println("Índice no válido.");
                            } else {
                                Producto productoSeleccionado = listaProductos.get(indiceProducto - 1);

                                // Mostrar al usuario las opciones disponibles para modificar
                                System.out.println("Opciones de modificación:");
                                System.out.println("1 - Descripción");
                                System.out.println("2 - Precio unitario");
                                System.out.println("3 - Origen de fabricación");
                                System.out.println("4 - Categoría");
                                System.out.print("Seleccione una opción: ");
                                int opcionModificacion = scanner.nextInt();
                                scanner.nextLine(); // Limpiar el buffer del scanner

                                switch (opcionModificacion) {
                                    case 1:
                                        System.out.print("Nueva descripción: ");
                                        String nuevaDescripcion = scanner.nextLine();
                                        productoSeleccionado.setDescripcion(nuevaDescripcion);
                                        break;
                                    case 2:
                                        System.out.print("Nuevo precio unitario: ");
                                        double nuevoPrecioUnitario = scanner.nextDouble();
                                        scanner.nextLine(); // Limpiar el buffer del scanner
                                        productoSeleccionado.setPrecioUnitario(nuevoPrecioUnitario);
                                        break;
                                    case 3:
                                        // Mostrar al usuario las opciones disponibles para origen de fabricación
                                        System.out.println("------ Origen de fabricación ------");
                                        System.out.println("1 - Argentina");
                                        System.out.println("2 - China");
                                        System.out.println("3 - Brasil");
                                        System.out.println("4 - Uruguay");
                                        System.out.print("Elija una opción: ");
                                        int opcionOrigen1 = scanner.nextInt();
                                        scanner.nextLine(); // Limpiar el buffer del scanner

                                        Producto.OrigenFabricacion nuevoOrigen;
                                        switch (opcionOrigen1) {
                                            case 1:
                                                nuevoOrigen = Producto.OrigenFabricacion.ARGENTINA;
                                                break;
                                            case 2:
                                                nuevoOrigen = Producto.OrigenFabricacion.CHINA;
                                                break;
                                            case 3:
                                                nuevoOrigen = Producto.OrigenFabricacion.BRASIL;
                                                break;
                                            case 4:
                                                nuevoOrigen = Producto.OrigenFabricacion.URUGUAY;
                                                break;
                                            default:
                                                System.out.println("Opción no válida para origen de fabricación. Se mantendrá el valor actual.");
                                                nuevoOrigen = productoSeleccionado.getOrigenFabricacion();
                                                break;
                                        }
                                        productoSeleccionado.setOrigenFabricacion(nuevoOrigen);
                                        break;
                                    case 4:
                                        // Mostrar al usuario las opciones disponibles para categoría
                                        System.out.println("------ Categoría ------");
                                        System.out.println("1 - Telefonía");
                                        System.out.println("2 - Informática");
                                        System.out.println("3 - Electro hogar");
                                        System.out.println("4 - Herramientas");
                                        System.out.print("Elija una opción: ");
                                        int opcionCategoria1 = scanner.nextInt();
                                        scanner.nextLine(); // Limpiar el buffer del scanner

                                        Producto.Categoria nuevaCategoria;
                                        switch (opcionCategoria1) {
                                            case 1:
                                                nuevaCategoria = Producto.Categoria.TELEFONIA;
                                                break;
                                            case 2:
                                                nuevaCategoria = Producto.Categoria.INFORMATICA;
                                                break;
                                            case 3:
                                                nuevaCategoria = Producto.Categoria.ELECTROHOGAR;
                                                break;
                                            case 4:
                                                nuevaCategoria = Producto.Categoria.HERRAMIENTAS;
                                                break;
                                            default:
                                                System.out.println("Opción no válida para categoría. Se mantendrá el valor actual.");
                                                nuevaCategoria = productoSeleccionado.getCategoria();
                                                break;
                                        }
                                        productoSeleccionado.setCategoria(nuevaCategoria);
                                        break;
                                    default:
                                        System.out.println("Opción no válida para modificación.");
                                }

                                System.out.println("Producto modificado con éxito.");
                                System.out.println("¿Desea realizar otra modificación? (S/N)");
                                String continuar = scanner.nextLine().toUpperCase();
                                if (!continuar.equals("S")) {
                                    opcion = 4; // Salir del bucle y volver al menú principal
                                }

                            }
                        }
                        break;

                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor ingrese un valor válido.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                opcion = 0; // Para evitar que se quede en un bucle infinito
            } catch (NoSuchElementException e) {
                System.out.println("Error: Entrada no encontrada.");
                opcion = 0; // Para evitar que se quede en un bucle infinito
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                opcion = 0; // Para evitar que se quede en un bucle infinito
            }
        } while (opcion != 4);

        scanner.close(); // Cerrar el Scanner al salir del programa
    }
}

