package org.adaschool.schoolmanagementsystem.domain.service;

import org.adaschool.schoolmanagementsystem.domain.model.Curso;
import org.adaschool.schoolmanagementsystem.domain.model.Estudiante;
import org.adaschool.schoolmanagementsystem.exceptions.*;

public interface ServiciosAcademicosI {
    void matricularEstudiante(Estudiante estudiante) throws EstudianteYaInscritoException;
    void agregarCurso(Curso curso) throws CursoYaAgregadoException;
    void inscribirEstudianteCurso(Estudiante estudiante, int idCurso) throws EstudianteYaInscritoException, EstudianteEnEstadoInactivoOGraduadoException;
    void desinscribirEstudianteCurso(int idEstudiante, int idCurso) throws EstudianteNoInscritoEnCursoException;
}