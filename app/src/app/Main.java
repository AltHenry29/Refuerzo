package app;

import modelo.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Cafeteria cafe =
                new Cafeteria("Smart Coffee");

        int opcion;

        do {

            System.out.println("\n========= SMART COFFEE =========");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Registrar pedido");
            System.out.println("4. Actualizar pedido");
            System.out.println("5. Eliminar pedido");
            System.out.println("6. Mostrar promedio");
            System.out.println("7. Mostrar mejor cliente");
            System.out.println("8. Buscar cliente");
            System.out.println("9. Mostrar pedidos");
            System.out.println("10. Salir");

            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {

                case 1:

                    try {

                        System.out.print("Código: ");
                        String codigo = sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();

                        System.out.print("Correo: ");
                        String correo = sc.nextLine();

                        System.out.print("Edad: ");
                        int edad =
                                Integer.parseInt(sc.nextLine());

                        System.out.print(
                                "Membresía (Gold/Silver/Premium): ");
                        String membresia =
                                sc.nextLine();

                        Cliente cliente =
                                new Cliente(
                                        codigo,
                                        membresia,
                                        nombre,
                                        correo,
                                        edad);

                        if (cafe.registrarCliente(cliente)) {

                            System.out.println(
                                    "Cliente registrado.");
                        } else {

                            System.out.println(
                                    "Cliente duplicado.");
                        }

                    } catch (Exception e) {

                        System.out.println(
                                "Error: "
                                        + e.getMessage());
                    }

                    break;

                case 2:

                    cafe.mostrarClientes();
                    break;

                case 3:

                    System.out.print("Correo: ");
                    String correoPedido =
                            sc.nextLine();

                    System.out.print("Consumo: ");
                    double consumo =
                            Double.parseDouble(
                                    sc.nextLine());

                    cafe.registrarPedido(
                            correoPedido,
                            consumo);

                    break;

                case 4:

                    System.out.print("Correo: ");
                    String correoActualizar =
                            sc.nextLine();

                    System.out.print("Nuevo consumo: ");

                    double nuevo =
                            Double.parseDouble(
                                    sc.nextLine());

                    cafe.actualizarPedido(
                            correoActualizar,
                            nuevo);

                    break;

                case 5:

                    System.out.print("Correo: ");
                    String correoEliminar =
                            sc.nextLine();

                    cafe.eliminarPedido(
                            correoEliminar);

                    break;

                case 6:

                    cafe.promedioConsumo();
                    break;

                case 7:

                    cafe.mejorCliente();
                    break;

                case 8:

                    System.out.print("Correo: ");

                    String correoBuscar =
                            sc.nextLine();

                    Cliente encontrado =
                            cafe.buscarCliente(
                                    correoBuscar);

                    if (encontrado == null) {

                        System.out.println(
                                "Cliente no encontrado");
                    } else {

                        System.out.println(
                                encontrado);
                    }

                    break;

                case 9:

                    cafe.mostrarPedidos();
                    break;

                case 10:

                    System.out.println("Fin del programa");
                    break;

                default:

                    System.out.println(
                            "Opción inválida");
            }

        } while (opcion != 10);
    }
}