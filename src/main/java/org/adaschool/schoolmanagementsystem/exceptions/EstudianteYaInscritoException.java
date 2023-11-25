package org.adaschool.schoolmanagementsystem.exceptions;

public class EstudianteYaInscritoException extends Exception{
    public EstudianteYaInscritoException(){
        super("El estudiante ya está inscrito en el curso");
    }
}