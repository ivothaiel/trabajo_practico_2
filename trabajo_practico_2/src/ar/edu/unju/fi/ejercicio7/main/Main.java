package ar.edu.unju.fi.ejercicio7.main;

import ar.edu.unju.fi.ejercicio1.model.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Precarga de productos
        List<Producto> productos = precargarProductos();

        // Menú de opciones
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1 - Mostrar productos (solo se muestran los productos con estado true)");
            System.out.println("2 - Mostrar los productos faltantes (muestra productos con estado false)");
            System.out.println("3 - Incrementar los precios de los productos en un 20%");
            System.out.println("4 - Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta");
            System.out.println("5 - Ordenar los productos por precio de forma descendente");
            System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");
            System.out.println("7 - Agregar nuevo producto");
            System.out.println("8 - Salir");

            // Leer opción del usuario
            Scanner scanner = new Scanner(System.in);
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductos(productos);
                    break;
                case 2:
                    mostrarProductosFaltantes(productos);
                    break;
                case 3:
                    incrementarPrecios(productos);
                    break;
                case 4:
                    mostrarProductosElectrohogar(productos);
                    break;
                case 5:
                    ordenarPorPrecioDescendente(productos);
                    break;
                case 6:
                    mostrarNombresEnMayusculas(productos);
                    break;
                case 7:
                    agregarNuevoProducto(productos);
                    break;
                case 8:
                    System.out.println("Saliendo del programa...");
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }

    // Método para precargar productos
    private static List<Producto> precargarProductos() {
        List<Producto> productos = new ArrayList<>();
        // Agregar aquí la precarga de 15 productos
        // Ejemplo:
        productos.add(new Producto(1, "Teléfono móvil", 100.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA));
        // Agregar más productos aquí...
        return productos;
    }

    // Métodos para las opciones del menú
    private static void mostrarProductos(List<Producto> productos) {
        System.out.println("Productos disponibles:");
        productos.stream()
                .filter(Producto::isEstado)
                .forEach(producto -> System.out.println(
                        "Código: " + producto.getCodigo() +
                        ", Descripción: " + producto.getDescripcion() +
                        ", Precio: $" + producto.getPrecioUnitario()));
    }

    private static void mostrarProductosFaltantes(List<Producto> productos) {
        System.out.println("Productos faltantes:");
        productos.stream()
                .filter(Predicate.not(Producto::isEstado))
                .forEach(producto -> System.out.println(
                        "Código: " + producto.getCodigo() +
                        ", Descripción: " + producto.getDescripcion() +
                        ", Precio: $" + producto.getPrecioUnitario()));
    }

    private static void incrementarPrecios(List<Producto> productos) {
        System.out.println("Incrementando precios en un 20%...");
        List<Producto> productosIncrementados = productos.stream()
                .map(producto -> {
                    producto.setPrecioUnitario(producto.getPrecioUnitario() * 1.20);
                    return producto;
                })
                .collect(Collectors.toList());
        productosIncrementados.forEach(System.out::println);
    }

    private static void mostrarProductosElectrohogar(List<Producto> productos) {
        System.out.println("Productos de Electrohogar disponibles para la venta:");
        productos.stream()
                .filter(producto -> producto.getCategoria() == Producto.Categoria.ELECTROHOGAR && producto.isEstado())
                .forEach(producto -> System.out.println(
                        "Código: " + producto.getCodigo() +
                        ", Descripción: " + producto.getDescripcion() +
                        ", Precio: $" + producto.getPrecioUnitario()));
    }

    private static void ordenarPorPrecioDescendente(List<Producto> productos) {
        System.out.println("Productos ordenados por precio de forma descendente:");
        productos.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrecioUnitario(), p1.getPrecioUnitario()))
                .forEach(producto -> System.out.println(
                        "Código: " + producto.getCodigo() +
                        ", Descripción: " + producto.getDescripcion() +
                        ", Precio: $" + producto.getPrecioUnitario()));
    }

    private static void mostrarNombresEnMayusculas(List<Producto> productos) {
        System.out.println("Nombres de productos en mayúsculas:");
        productos.stream()
                .map(producto -> {
                    producto.setDescripcion(producto.getDescripcion().toUpperCase());
                    return producto;
                })
                .forEach(producto -> System.out.println(
                        "Código: " + producto.getCodigo() +
                        ", Descripción: " + producto.getDescripcion() +
                        ", Precio: $" + producto.getPrecioUnitario()));
    }

    private static void agregarNuevoProducto(List<Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Ingrese el código del nuevo producto: ");
            int codigo = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            System.out.print("Ingrese la descripción del nuevo producto: ");
            String descripcion = scanner.nextLine();

            System.out.print("Ingrese el precio unitario del nuevo producto: ");
            double precio = scanner.nextDouble();
            scanner.nextLine(); // Limpiar el buffer

            // Asumiendo que el origen de fabricación y la categoría serán fijos por ahora
            Producto productoNuevo = new Producto(codigo, descripcion, precio, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA);
            productos.add(productoNuevo);

            System.out.println("¡Producto agregado correctamente!");
        } catch (Exception e) {
            System.out.println("Error al agregar el producto: " + e.getMessage());
        }
    }
}
