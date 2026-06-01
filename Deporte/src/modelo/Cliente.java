package modelo;

import java.util.Objects;

public class Cliente {

    private String cedula;
    private String nombre;
    private int edad;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String cedula, String nombre,
                   int edad, String telefono) {

        setCedula(cedula);
        setNombre(nombre);
        setEdad(edad);
        setTelefono(telefono);
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {

        if (!cedula.matches("\\d{10}")) {
            throw new IllegalArgumentException(
                    "La cédula debe tener exactamente 10 dígitos.");
        }

        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nombre inválido.");
        }

        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {

        if (edad < 15 || edad > 60) {
            throw new IllegalArgumentException(
                    "La edad debe estar entre 15 y 60 años.");
        }

        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {

        if (!telefono.matches("\\d+")) {
            throw new IllegalArgumentException(
                    "El teléfono solo debe contener números.");
        }

        this.telefono = telefono;
    }

    @Override
    public String toString() {

        return "Cliente{" +
                "cedula='" + cedula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Cliente)) return false;

        Cliente otro = (Cliente) obj;

        return cedula.equals(otro.cedula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }
}