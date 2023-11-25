package org.adaschool.schoolmanagementsystem.domain.service;

import org.adaschool.schoolmanagementsystem.domain.model.Curso;
import org.adaschool.schoolmanagementsystem.domain.model.EstadoEstudiante;
import org.adaschool.schoolmanagementsystem.domain.model.Estudiante;
import org.adaschool.schoolmanagementsystem.exceptions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GestorAcademico implements ServiciosAcademicosI{
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;
    private HashMap<Integer, ArrayList<Integer>> estudiantesInscritos;

    public GestorAcademico() {
        this.estudiantes = new ArrayList<>();
        this.cursos = new ArrayList<>();
        this.estudiantesInscritos = new HashMap<>();
    }

    @Override
    public void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException {
        if(!estudiantes.contains(estudiante)){
            estudiantes.add(estudiante);
        } else{
            throw new EstudianteYaInscritoException();
        }
    }

    @Override
    public void agregarCurso(Curso curso) throws CursoYaAgregadoException {
        if(!cursos.contains(curso)){
            cursos.add(curso);
        } else{
            throw new CursoYaAgregadoException();
        }
    }

    @Override
    public void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException, EstudianteEnEstadoInactivoOGraduadoException {
        verificarEstadoEstudianteInactivoOGraduado(estudiante);

        verificarExistenciaCurso(idCurso);
        ArrayList<Integer> idEstudiantesInscritos = estudiantesInscritos.get(idCurso);

        if (idEstudiantesInscritos == null) {
            idEstudiantesInscritos = new ArrayList<>();
            estudiantesInscritos.put(idCurso, idEstudiantesInscritos);
        }

        if (!idEstudiantesInscritos.contains(estudiante.getId())) {
            idEstudiantesInscritos.add(estudiante.getId());
        } else {
            throw new EstudianteYaInscritoException();
        }
    }

    @Override
    public void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException {
        verificarExistenciaCurso(idCurso);

        ArrayList<Integer> idEstudiantesInscritos = estudiantesInscritos.get(idCurso);

        if (idEstudiantesInscritos != null && idEstudiantesInscritos.contains(idEstudiante)) {
            idEstudiantesInscritos.remove(Integer.valueOf(idEstudiante));
            estudiantesInscritos.put(idCurso, idEstudiantesInscritos);
        } else {
            throw new EstudianteNoInscritoEnCursoException();
        }
    }

    public void verificarExistenciaCurso(int idCurso){
        if (cursos.stream().noneMatch(curso -> curso.getId() == idCurso)) {
            throw new IllegalArgumentException("El ID del curso no es válido");
        }
    }

    public void mostrarTodosLosCursos(){
        System.out.println("Listado de todos los cursos: ");

        for(Curso curso: cursos){
            System.out.println(curso);
        }
    }

    public void mostrarTodosLosEstudiantes(){
        System.out.println("Listados de todos los estudiantes: ");

        for(Estudiante estudiante:estudiantes){
            System.out.println(estudiante);
        }
    }

    public void mostrarEstudiantesInscritosEnCursos() {
        System.out.println("Listado de estudiantes inscritos en cursos");

        if (estudiantesInscritos.isEmpty()) {
            System.out.println("No hay estudiantes inscritos en cursos.");
        } else {
            for (Map.Entry<Integer, ArrayList<Integer>> entry : estudiantesInscritos.entrySet()) {
                int idCurso = entry.getKey();
                ArrayList<Integer> estudiantesInscritosEnCurso = entry.getValue();

                System.out.println("Curso ID " + idCurso + ":");
                if (estudiantesInscritosEnCurso.isEmpty()) {
                    System.out.println("No hay estudiantes inscritos en este curso.");
                } else {
                    for (Integer idEstudiante : estudiantesInscritosEnCurso) {
                        Estudiante estudiante = obtenerEstudiantePorId(idEstudiante);
                        System.out.println(estudiante);
                    }
                }
            }
        }
    }

    public void verificarEstadoEstudianteInactivoOGraduado(Estudiante estudiante) throws EstudianteEnEstadoInactivoOGraduadoException {
        if(Objects.equals(estudiante.getEstado(), EstadoEstudiante.INACTIVO.getEstado()) || Objects.equals(estudiante.getEstado(), EstadoEstudiante.GRADUADO.getEstado())) throw new EstudianteEnEstadoInactivoOGraduadoException();
    }

    private Estudiante obtenerEstudiantePorId(int idEstudiante){
        Estudiante estudianteEncontrado = null;
        for(Estudiante estudiante: estudiantes){
            if(estudiante.getId() == idEstudiante){
                estudianteEncontrado = estudiante;
            }
        }
        return estudianteEncontrado;
    }
}