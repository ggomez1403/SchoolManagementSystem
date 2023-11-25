package org.adaschool.schoolmanagementsystem.domain.model;


import java.time.LocalDate;

public class Estudiante extends Persona {
    private String estado;

    public Estudiante(String nombre, String apellido, LocalDate fechaNacimiento, String estado) {
        super(nombre, apellido, fechaNacimiento);
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        String separatorLine = "+--------+----------------------+------------+----------------------+--------------------------+";
        String header = "|   ID   |        Nombre        |  Apellido  | Fecha de Nacimiento  |          Estado          |";
        String dataFormat = "| %-6d | %-20s | %-10s | %-20s | %-24s |";

        return String.format("%s%n%s%n%s%n%s%n%s%n",
                separatorLine,
                header,
                separatorLine,
                String.format(dataFormat, super.getId(), super.getNombre(), super.getApellido(), super.getFechaNacimiento(), estado),
                separatorLine);
    }
}