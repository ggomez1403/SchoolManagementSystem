package org.adaschool.schoolmanagementsystem.domain.model;

public enum EstadoEstudiante {
    MATRICULADO("Matriculado"),
    INACTIVO("Inactivo"),
    GRADUADO("Graduado");

    private String estado;

    EstadoEstudiante(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}