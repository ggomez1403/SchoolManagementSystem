package org.adaschool.schoolmanagementsystem.domain.model;

public class Curso {
    private int id;
    private String nombre;
    private String descripcion;
    private int numeroCreditos;
    private int version;

    private static int ultimoId;

    public Curso(String nombre, String descripcion, int numeroCreditos, int version) {
        this.id = ++ultimoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.numeroCreditos = numeroCreditos;
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        String separatorLine = "+--------+----------------------+--------------------------------------------------------------+--------------------+---------+";
        String header = "|   ID   |        Nombre        |                          Descripción                         | Número de Créditos | Versión |";
        String dataFormat = "| %-6d | %-20s | %-60.60s | %-18d | %-7d |";

        return String.format("%s%n%s%n%s%n%s%n%s%n",
                separatorLine,
                header,
                separatorLine,
                String.format(dataFormat, id, nombre, descripcion, numeroCreditos, version),
                separatorLine);
    }
}