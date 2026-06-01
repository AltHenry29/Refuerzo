package modelo;

public interface CrudReserva {

    void registrarReserva(String cedula, int horas);

    void actualizarReserva(String cedula, int horas);

    void eliminarReserva(String cedula);

    void calcularTotalHoras();

    void clienteMayorReserva();
}