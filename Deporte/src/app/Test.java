package app;

import modelo.*;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ReservaCancha sistema =
                new ReservaCancha();

        int opcion;

        do {

            System.out.println(
                    "\n===== COMPLEJO DEPORTIVO =====");

            System.out.println("1. Registrar cliente");
            System.out.println("2. Mostrar clientes");
            System.out.println("3. Registrar reserva");
            System.out.println("4. Actualizar reserva");
            System.out.println("5. Eliminar reserva");
            System.out.println("6. Mostrar reservas");
            System.out.println("7. Buscar cliente");
            System.out.println("8. Total horas reservadas");
            System.out.println("9. Cliente con mayor reserva");
            System.out.println("10. Resumen general");
            System.out.println("11. Salir");

            System.out.print("Opción: ");

            opcion = Integer.parseInt(
                    sc.nextLine());

            switch (opcion) {

                case 1:

                    try {

                        System.out.print("Cédula: ");
                        String cedula =
                                sc.nextLine();

                        System.out.print("Nombre: ");
                        String nombre =
                                sc.nextLine();

                        System.out.print("Edad: ");
                        int edad =
                                Integer.parseInt(
                                        sc.nextLine());

                        System.out.print("Teléfono: ");
                        String telefono =
                                sc.nextLine();

                        Cliente cliente =
                                new Cliente(
                                        cedula,
                                        nombre,
                                        edad,
                                        telefono);

                        if (sistema.registrarCliente(
                                cliente)) {

                            System.out.println(
                                    "Cliente registrado.");
                        } else {

                            System.out.println(
                                    "Cliente duplicado.");
                        }

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage());
                    }

                    break;

                case 2:

                    sistema.mostrarClientes();
                    break;

                case 3:

                    System.out.print("Cédula: ");
                    String cedulaReserva =
                            sc.nextLine();

                    System.out.print("Horas: ");
                    int horas =
                            Integer.parseInt(
                                    sc.nextLine());

                    sistema.registrarReserva(
                            cedulaReserva,
                            horas);

                    break;

                case 4:

                    System.out.print("Cédula: ");
                    String cedulaAct =
                            sc.nextLine();

                    System.out.print("Horas nuevas: ");
                    int nuevasHoras =
                            Integer.parseInt(
                                    sc.nextLine());

                    sistema.actualizarReserva(
                            cedulaAct,
                            nuevasHoras);

                    break;

                case 5:

                    System.out.print("Cédula: ");
                    String cedulaElim =
                            sc.nextLine();

                    sistema.eliminarReserva(
                            cedulaElim);

                    break;

                case 6:

                    sistema.mostrarReservas();
                    break;

                case 7:

                    System.out.print("Cédula: ");
                    String cedulaBus =
                            sc.nextLine();

                    Cliente encontrado =
                            sistema.buscarCliente(
                                    cedulaBus);

                    if (encontrado == null) {

                        System.out.println(
                                "Cliente no encontrado.");
                    } else {

                        System.out.println(
                                encontrado);
                    }

                    break;

                case 8:

                    sistema.calcularTotalHoras();
                    break;

                case 9:

                    sistema.clienteMayorReserva();
                    break;

                case 10:

                    sistema.mostrarClientes();
                    sistema.mostrarReservas();
                    break;

                case 11:

                    System.out.println(
                            "Programa finalizado.");
                    break;

                default:

                    System.out.println(
                            "Opción inválida.");
            }

        } while (opcion != 11);
    }
}