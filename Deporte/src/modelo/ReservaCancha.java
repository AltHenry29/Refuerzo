package modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReservaCancha implements CrudReserva {

    private Set<Cliente> clientes;
    private Map<String, Integer> reservas;

    public ReservaCancha() {

        clientes = new HashSet<>();
        reservas = new HashMap<>();
    }

    public boolean registrarCliente(Cliente cliente) {

        return clientes.add(cliente);
    }

    public void mostrarClientes() {

        if (clientes.isEmpty()) {

            System.out.println("No existen clientes.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println(c);
        }
    }

    public Cliente buscarCliente(String cedula) {

        for (Cliente c : clientes) {

            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }

        return null;
    }

    public void mostrarReservas() {

        if (reservas.isEmpty()) {

            System.out.println("No hay datos disponibles.");
            return;
        }

        for (Map.Entry<String, Integer> r : reservas.entrySet()) {

            System.out.println(
                    "Cédula: "
                            + r.getKey()
                            + " | Horas: "
                            + r.getValue());
        }
    }

    @Override
    public void registrarReserva(String cedula,
                                 int horas) {

        Cliente cliente = buscarCliente(cedula);

        if (cliente == null) {

            System.out.println(
                    "Cliente no encontrado.");
            return;
        }

        if (horas < 1 || horas > 5) {

            System.out.println(
                    "Las horas deben estar entre 1 y 5.");
            return;
        }

        reservas.put(cedula, horas);

        System.out.println(
                "Reserva registrada.");
    }

    @Override
    public void actualizarReserva(String cedula,
                                  int horas) {

        if (!reservas.containsKey(cedula)) {

            System.out.println(
                    "Reserva no encontrada.");
            return;
        }

        reservas.put(cedula, horas);

        System.out.println(
                "Reserva actualizada.");
    }

    @Override
    public void eliminarReserva(String cedula) {

        if (!reservas.containsKey(cedula)) {

            System.out.println(
                    "Reserva no encontrada.");
            return;
        }

        reservas.remove(cedula);

        System.out.println(
                "Reserva eliminada.");
    }

    @Override
    public void calcularTotalHoras() {

        if (reservas.isEmpty()) {

            System.out.println(
                    "No hay datos disponibles.");
            return;
        }

        int total = 0;

        for (int horas : reservas.values()) {
            total += horas;
        }

        System.out.println(
                "Total de horas reservadas: "
                        + total);
    }

    @Override
    public void clienteMayorReserva() {

        if (reservas.isEmpty()) {

            System.out.println(
                    "No hay datos disponibles.");
            return;
        }

        String cedulaMayor = "";
        int mayor = 0;

        for (Map.Entry<String, Integer> r
                : reservas.entrySet()) {

            if (r.getValue() > mayor) {

                mayor = r.getValue();
                cedulaMayor = r.getKey();
            }
        }

        Cliente cliente =
                buscarCliente(cedulaMayor);

        System.out.println(
                "\nCliente con mayor reserva:");

        System.out.println(cliente);

        System.out.println(
                "Horas reservadas: "
                        + mayor);
    }
}