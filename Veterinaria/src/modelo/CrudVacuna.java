package modelo;

public interface CrudVacuna {

    void registrarVacuna(String codigo, String vacuna);

    void actualizarVacuna(String codigo, String nuevaVacuna);

    void eliminarVacuna(String codigo);

    void mostrarVacunas();

    void mascotaMasVacunada();
}