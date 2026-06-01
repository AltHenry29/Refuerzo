package modelo;

import java.util.Objects;

public class Cliente extends Persona {

    private String codigoCliente;
    private String tipoMembresia;

    public Cliente(String codigoCliente,
                   String tipoMembresia,
                   String nombre,
                   String correo,
                   int edad) {

        super(nombre, correo, edad);

        this.codigoCliente = codigoCliente;
        setTipoMembresia(tipoMembresia);
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getTipoMembresia() {
        return tipoMembresia;
    }

    public void setTipoMembresia(String tipoMembresia) {

        if (!tipoMembresia.equalsIgnoreCase("Gold")
                && !tipoMembresia.equalsIgnoreCase("Silver")
                && !tipoMembresia.equalsIgnoreCase("Premium")) {

            throw new IllegalArgumentException(
                    "Membresía inválida");
        }

        this.tipoMembresia = tipoMembresia;
    }

    @Override
    public String toString() {

        return super.toString()
                + "\nCódigo: " + codigoCliente
                + "\nMembresía: " + tipoMembresia;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Cliente)) {
            return false;
        }

        Cliente otro = (Cliente) obj;

        return codigoCliente.equals(otro.codigoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigoCliente);
    }
}