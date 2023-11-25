package org.adaschool.schoolmanagementsystem.exceptions;

public class EstudianteNoInscritoEnCursoException extends Exception{
    public EstudianteNoInscritoEnCursoException(){
        super("El estudiante no se encuentra inscrito en el curso");
    }
}