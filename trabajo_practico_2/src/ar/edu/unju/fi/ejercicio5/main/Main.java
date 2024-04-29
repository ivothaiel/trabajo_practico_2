package ar.edu.unju.fi.ejercicio5.main;
import ar.edu.unju.fi.ejercicio1.model.Producto;
import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.ejercicio5.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio5.model.PagoTarjeta;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Precarga de productos
            ArrayList<Producto> productos = precargarProductos();

            // Mostrar menú y realizar operaciones
            mostrarMenu(productos);
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
        }
    }

    private static ArrayList<Producto> precargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        // Precarga de productos según el enunciado
        productos.add(new Producto(1, "Teléfono móvil", 500.0, Producto.OrigenFabricacion.ARGENTINA, Producto.Categoria.TELEFONIA));
        productos.add(new Producto(2, "Laptop", 1200.0, Producto.OrigenFabricacion.CHINA, Producto.Categoria.INFORMATICA));
        productos.add(new Producto(3, "Licuadora", 800.0, Producto.OrigenFabricacion.URUGUAY, Producto.Categoria.ELECTROHOGAR));
        productos.add(new Producto(4, "Taladro eléctrico", 300.0, Producto.OrigenFabricacion.BRASIL, Producto.Categoria.HERRAMIENTAS));
        // Agregar más productos según sea necesario
        return productos;
    }

    private static void mostrarMenu(ArrayList<Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            try {
                System.out.println("Menú:");
                System.out.println("1 - Mostrar productos");
                System.out.println("2 - Realizar compra");
                System.out.println("3 - Salir");
                System.out.print("Ingrese su opción: ");
                int opcion = scanner.nextInt();

                switch (opcion) {
                    case 1:
                        mostrarProductos(productos);
                        break;
                    case 2:
                        realizarCompra(productos);
                        break;
                    case 3:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, ingrese una opción válida.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        System.out.println("Listado de productos:");
        for (Producto producto : productos) {
            System.out.println(producto.getCodigo() + " - " + producto.getDescripcion() + " - $" + producto.getPrecioUnitario());
        }
    }

    private static void realizarCompra(ArrayList<Producto> productos) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        double total = 0.0;

        // Mostrar productos disponibles
        mostrarProductos(productos);

        // Seleccionar productos a comprar
        boolean seguirAgregando = true;
        while (seguirAgregando) {
            try {
                System.out.print("Ingrese el código del producto que desea agregar a la compra (0 para finalizar): ");
                int codigoProducto = scanner.nextInt();
                if (codigoProducto == 0) {
                    seguirAgregando = false;
                } else {
                    Producto productoSeleccionado = encontrarProducto(productos, codigoProducto);
                    if (productoSeleccionado != null && productoSeleccionado.isEstado()) {
                        productosSeleccionados.add(productoSeleccionado);
                        total += productoSeleccionado.getPrecioUnitario();
                    } else {
                        System.out.println("Producto no encontrado o no disponible.");
                    }
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número válido.");
                scanner.nextLine(); // Limpiar el buffer
            }
        }

        // Mostrar total y opciones de pago
        System.out.println("Total de la compra: $" + total);
        System.out.println("Seleccione una opción de pago:");
        System.out.println("1 - Pago efectivo");
        System.out.println("2 - Pago con tarjeta");

        try {
            int opcionPago = scanner.nextInt();

            // Procesar el pago
            if (opcionPago == 1) {
                // Pago efectivo
                Pago pagoEfectivo = new PagoEfectivo(total, LocalDate.now());
                pagoEfectivo.realizarPago(total);
                pagoEfectivo.imprimirRecibo();
            } else if (opcionPago == 2) {
                // Pago con tarjeta
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el número de tarjeta: ");
                String numeroTarjeta = scanner.nextLine();
                Pago pagoTarjeta = new PagoTarjeta(numeroTarjeta, LocalDate.now(), total);
                pagoTarjeta.realizarPago(total);
                pagoTarjeta.imprimirRecibo();
            } else {
                System.out.println("Opción de pago inválida.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Ingrese un número válido.");
            scanner.nextLine(); // Limpiar el buffer
        }
    }

    private static Producto encontrarProducto(ArrayList<Producto> productos, int codigoProducto) {
        for (Producto producto : productos) {
            if (producto.getCodigo() == codigoProducto) {
                return producto;
            }
        }
        return null;
    }
}
