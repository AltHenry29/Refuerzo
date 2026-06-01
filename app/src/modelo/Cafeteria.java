package modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Cafeteria implements CrudPedido {

    private String nombreCafeteria;

    private HashSet<Cliente> clientes;

    private Map<String, Double> mapaPedidos;

    public Cafeteria(String nombreCafeteria) {

        this.nombreCafeteria = nombreCafeteria;

        clientes = new HashSet<>();

        mapaPedidos = new HashMap<>();
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

            System.out.println("------------------");
            System.out.println(c);
        }
    }

    public Cliente buscarCliente(String correo) {

        for (Cliente c : clientes) {

            if (c.getCorreo().equalsIgnoreCase(correo)) {
                return c;
            }
        }

        return null;
    }

    public void mostrarPedidos() {

        if (mapaPedidos.isEmpty()) {

            System.out.println("No hay datos disponibles.");
            return;
        }

        for (Map.Entry<String, Double> pedido : mapaPedidos.entrySet()) {

            System.out.println(
                    pedido.getKey()
                            + " -> $"
                            + pedido.getValue());
        }
    }

    @Override
    public void registrarPedido(String correo,
                                double consumo) {

        Cliente cliente = buscarCliente(correo);

        if (cliente == null) {

            System.out.println("Cliente no existe.");
            return;
        }

        if (consumo <= 0) {

            System.out.println("Consumo inválido.");
            return;
        }

        mapaPedidos.put(correo, consumo);

        System.out.println("Pedido registrado.");
    }

    @Override
    public void actualizarPedido(String correo,
                                 double nuevoConsumo) {

        if (!mapaPedidos.containsKey(correo)) {

            System.out.println("Pedido no encontrado.");
            return;
        }

        mapaPedidos.put(correo, nuevoConsumo);

        System.out.println("Pedido actualizado.");
    }

    @Override
    public void eliminarPedido(String correo) {

        if (!mapaPedidos.containsKey(correo)) {

            System.out.println("Pedido inexistente.");
            return;
        }

        mapaPedidos.remove(correo);

        System.out.println("Pedido eliminado.");
    }

    @Override
    public void promedioConsumo() {

        if (mapaPedidos.isEmpty()) {

            System.out.println("No hay datos disponibles.");
            return;
        }

        double suma = 0;

        for (double valor : mapaPedidos.values()) {

            suma += valor;
        }

        System.out.println(
                "Promedio: "
                        + (suma / mapaPedidos.size()));
    }

    @Override
    public void mejorCliente() {

        if (mapaPedidos.isEmpty()) {

            System.out.println("No hay datos disponibles.");
            return;
        }

        String correoMayor = "";
        double mayor = 0;

        for (Map.Entry<String, Double> pedido
                : mapaPedidos.entrySet()) {

            if (pedido.getValue() > mayor) {

                mayor = pedido.getValue();
                correoMayor = pedido.getKey();
            }
        }

        Cliente cliente = buscarCliente(correoMayor);

        System.out.println("\nMEJOR CLIENTE");
        System.out.println(cliente);
        System.out.println("Consumo: $" + mayor);
    }
}