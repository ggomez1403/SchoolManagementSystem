package org.adaschool.schoolmanagementsystem.exceptions;

public class CursoYaAgregadoException extends Exception{
    public CursoYaAgregadoException(){
        super("El curso ya está registrado");
    }
}