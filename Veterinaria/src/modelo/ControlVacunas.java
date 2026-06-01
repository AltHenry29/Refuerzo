package modelo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ControlVacunas implements CrudVacuna {

    private Set<Mascota> mascotas;
    private Map<String, String> vacunas;

    public ControlVacunas() {

        mascotas = new HashSet<>();
        vacunas = new HashMap<>();
    }

    public boolean registrarMascota(Mascota mascota) {

        return mascotas.add(mascota);
    }

    public void mostrarMascotas() {

        if (mascotas.isEmpty()) {

            System.out.println("No existen mascotas.");
            return;
        }

        for (Mascota mascota : mascotas) {

            System.out.println("------------------");
            System.out.println(mascota);
        }
    }

    public Mascota buscarMascota(String codigo) {

        for (Mascota mascota : mascotas) {

            if (mascota.getCodigo().equalsIgnoreCase(codigo)) {
                return mascota;
            }
        }

        return null;
    }

    @Override
    public void registrarVacuna(String codigo,
                                String vacuna) {

        Mascota mascota = buscarMascota(codigo);

        if (mascota == null) {

            System.out.println(
                    "La mascota no existe.");
            return;
        }

        vacunas.put(codigo, vacuna);

        System.out.println(
                "Vacuna registrada correctamente.");
    }

    @Override
    public void actualizarVacuna(String codigo,
                                 String nuevaVacuna) {

        if (!vacunas.containsKey(codigo)) {

            System.out.println(
                    "La vacuna no existe.");
            return;
        }

        vacunas.put(codigo, nuevaVacuna);

        System.out.println(
                "Vacuna actualizada.");
    }

    @Override
    public void eliminarVacuna(String codigo) {

        if (!vacunas.containsKey(codigo)) {

            System.out.println(
                    "La vacuna no existe.");
            return;
        }

        vacunas.remove(codigo);

        System.out.println(
                "Vacuna eliminada.");
    }

    @Override
    public void mostrarVacunas() {

        if (vacunas.isEmpty()) {

            System.out.println(
                    "No hay datos disponibles.");
            return;
        }

        for (Map.Entry<String, String> v
                : vacunas.entrySet()) {

            System.out.println(
                    "Código: "
                            + v.getKey()
                            + " | Vacuna: "
                            + v.getValue());
        }
    }

    @Override
    public void mascotaMasVacunada() {

        if (vacunas.isEmpty()) {

            System.out.println(
                    "No hay datos disponibles.");
            return;
        }

        String codigo = vacunas.keySet()
                .iterator().next();

        Mascota mascota =
                buscarMascota(codigo);

        System.out.println(
                "Mascota registrada con vacuna:");

        System.out.println(mascota);
    }
}