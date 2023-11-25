package org.adaschool.schoolmanagementsystem;

import org.adaschool.schoolmanagementsystem.domain.model.Curso;
import org.adaschool.schoolmanagementsystem.domain.model.EstadoEstudiante;
import org.adaschool.schoolmanagementsystem.domain.model.Estudiante;
import org.adaschool.schoolmanagementsystem.domain.service.GestorAcademico;

import java.time.LocalDate;

public class SchoolManagementApplication {
    public static void main(String[] args) {
        Estudiante estudiante1 = new Estudiante("Geraldine", "Gomez", LocalDate.of(2004, 3, 14), EstadoEstudiante.MATRICULADO.getEstado());
        Estudiante estudiante2 = new Estudiante("Jennifer", "Gomez", LocalDate.of(1996, 5, 23), EstadoEstudiante.INACTIVO.getEstado());
        Estudiante estudiante3 = new Estudiante("Sandra", "Romero", LocalDate.of(1969, 8, 30), EstadoEstudiante.GRADUADO.getEstado());
        Estudiante estudiante4 = new Estudiante("Juan", "Parra", LocalDate.of(2003, 7, 24), EstadoEstudiante.MATRICULADO.getEstado());
        Estudiante estudiante5 = new Estudiante("Fabian", "Vazquez", LocalDate.of(2004, 9, 18), EstadoEstudiante.MATRICULADO.getEstado());

        Curso curso1 = new Curso("Frontend", "Curso de desarrollo Frontend con HTML,CSS y JavaScript", 4, 1);
        Curso curso2 = new Curso("POO", "Curso de programacion orientada a objetos con Java", 2, 2);
        Curso curso3 = new Curso("Backend", "Curso de desarrollo Backend con Java", 6, 3);

        GestorAcademico gestorAcademico = new GestorAcademico();

        try {
            gestorAcademico.matricularEstudiante(estudiante1);
            gestorAcademico.matricularEstudiante(estudiante2);
            gestorAcademico.matricularEstudiante(estudiante3);
            gestorAcademico.matricularEstudiante(estudiante4);
            gestorAcademico.matricularEstudiante(estudiante5);
        } catch (Exception e) {
            System.err.println("\n" + e.getMessage() + "\n");
        }

        try {
            gestorAcademico.agregarCurso(curso1);
            gestorAcademico.agregarCurso(curso2);
            gestorAcademico.agregarCurso(curso3);
        } catch (Exception e) {
            System.err.println("\n" + e.getMessage() + "\n");
        }

        gestorAcademico.mostrarTodosLosEstudiantes();
        gestorAcademico.mostrarTodosLosCursos();

        try {
            gestorAcademico.inscribirEstudianteCurso(estudiante1, 1);
            gestorAcademico.inscribirEstudianteCurso(estudiante4, 1);
            gestorAcademico.inscribirEstudianteCurso(estudiante5, 3);
            gestorAcademico.inscribirEstudianteCurso(estudiante3, 3);
            gestorAcademico.inscribirEstudianteCurso(estudiante2, 2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        gestorAcademico.mostrarEstudiantesInscritosEnCursos();

        try {
            gestorAcademico.desinscribirEstudianteCurso(4, 1);
        } catch (Exception e) {
            System.err.println("\n" + e.getMessage() + "\n");
        }

        gestorAcademico.mostrarEstudiantesInscritosEnCursos();

    }
}