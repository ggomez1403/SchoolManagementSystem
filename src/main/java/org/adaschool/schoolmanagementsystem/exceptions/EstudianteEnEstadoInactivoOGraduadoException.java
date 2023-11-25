package org.adaschool.schoolmanagementsystem.exceptions;

public class EstudianteEnEstadoInactivoOGraduadoException extends Exception{
    public EstudianteEnEstadoInactivoOGraduadoException(){
        super("El estudiante se encuentra en estado Inactivo o Graduado, no es posible inscribir el curso");
    }
}