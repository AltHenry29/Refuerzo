package app;

import modelo.*;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ControlVacunas sistema =
                new ControlVacunas();

        int opcion;

        do {

            System.out.println(
                    "\n===== VETERINARIA =====");

            System.out.println(
                    "1. Registrar mascota");
            System.out.println(
                    "2. Mostrar mascotas");
            System.out.println(
                    "3. Registrar vacuna");
            System.out.println(
                    "4. Actualizar vacuna");
            System.out.println(
                    "5. Eliminar vacuna");
            System.out.println(
                    "6. Mostrar vacunas");
            System.out.println(
                    "7. Buscar mascota");
            System.out.println(
                    "8. Mostrar mascota vacunada");
            System.out.println(
                    "9. Información general");
            System.out.println(
                    "10. Salir");

            System.out.print("Opción: ");

            opcion = Integer.parseInt(
                    sc.nextLine());

            switch (opcion) {

                case 1:

                    try {

                        System.out.print(
                                "Código: ");
                        String codigo =
                                sc.nextLine();

                        System.out.print(
                                "Nombre: ");
                        String nombre =
                                sc.nextLine();

                        System.out.print(
                                "Edad: ");
                        int edad =
                                Integer.parseInt(
                                        sc.nextLine());

                        System.out.print(
                                "Tipo (Perro/Gato/Conejo/Otro): ");

                        String tipo =
                                sc.nextLine();

                        Mascota mascota =
                                new Mascota(
                                        codigo,
                                        nombre,
                                        edad,
                                        tipo);

                        if (sistema.registrarMascota(
                                mascota)) {

                            System.out.println(
                                    "Mascota registrada.");
                        } else {

                            System.out.println(
                                    "Mascota duplicada.");
                        }

                    } catch (Exception e) {

                        System.out.println(
                                e.getMessage());
                    }

                    break;

                case 2:

                    sistema.mostrarMascotas();
                    break;

                case 3:

                    System.out.print(
                            "Código mascota: ");

                    String codigoVacuna =
                            sc.nextLine();

                    System.out.print(
                            "Vacuna: ");

                    String vacuna =
                            sc.nextLine();

                    sistema.registrarVacuna(
                            codigoVacuna,
                            vacuna);

                    break;

                case 4:

                    System.out.print(
                            "Código mascota: ");

                    String codigoActualizar =
                            sc.nextLine();

                    System.out.print(
                            "Nueva vacuna: ");

                    String nueva =
                            sc.nextLine();

                    sistema.actualizarVacuna(
                            codigoActualizar,
                            nueva);

                    break;

                case 5:

                    System.out.print(
                            "Código mascota: ");

                    String codigoEliminar =
                            sc.nextLine();

                    sistema.eliminarVacuna(
                            codigoEliminar);

                    break;

                case 6:

                    sistema.mostrarVacunas();
                    break;

                case 7:

                    System.out.print(
                            "Código: ");

                    String codigoBuscar =
                            sc.nextLine();

                    Mascota encontrada =
                            sistema.buscarMascota(
                                    codigoBuscar);

                    if (encontrada == null) {

                        System.out.println(
                                "Mascota no encontrada.");
                    } else {

                        System.out.println(
                                encontrada);
                    }

                    break;

                case 8:

                    sistema.mascotaMasVacunada();
                    break;

                case 9:

                    System.out.println(
                            "Total mascotas registradas y vacunas cargadas.");
                    sistema.mostrarMascotas();
                    sistema.mostrarVacunas();

                    break;

                case 10:

                    System.out.println(
                            "Programa finalizado.");
                    break;

                default:

                    System.out.println(
                            "Opción inválida.");
            }

        } while (opcion != 10);
    }
}