package modelo;

import java.util.Objects;

public class Mascota {

    private String codigo;
    private String nombre;
    private int edad;
    private String tipo;

    public Mascota() {
    }

    public Mascota(String codigo, String nombre, int edad, String tipo) {
        setCodigo(codigo);
        setNombre(nombre);
        setEdad(edad);
        setTipo(tipo);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {

        if (codigo == null || codigo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El código no puede estar vacío");
        }

        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío");
        }

        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {

        if (edad < 0 || edad > 20) {
            throw new IllegalArgumentException(
                    "La edad debe estar entre 0 y 20 años");
        }

        this.edad = edad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {

        if (!tipo.equalsIgnoreCase("Perro")
                && !tipo.equalsIgnoreCase("Gato")
                && !tipo.equalsIgnoreCase("Conejo")
                && !tipo.equalsIgnoreCase("Otro")) {

            throw new IllegalArgumentException(
                    "Tipo inválido");
        }

        this.tipo = tipo;
    }

    @Override
    public String toString() {

        return "\nCódigo: " + codigo
                + "\nNombre: " + nombre
                + "\nEdad: " + edad
                + "\nTipo: " + tipo;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Mascota)) {
            return false;
        }

        Mascota otra = (Mascota) obj;

        return codigo.equals(otra.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }
}