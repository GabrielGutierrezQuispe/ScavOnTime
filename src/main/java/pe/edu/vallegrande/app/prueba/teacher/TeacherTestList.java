package pe.edu.vallegrande.app.prueba.teacher;

import java.util.List;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestList {
    public static void main(String[] args) {
        try {
            CrudTeacherService teacherService = new CrudTeacherService();
            List<Teacher> lista = teacherService.getAll();
            if (!lista.isEmpty()) {
                System.out.println("Lista de profesores:");
                for (Teacher teacher : lista) {
                    System.out.println(teacher);
                }
            } else {
                System.out.println("No se encontraron profesores.");
            }
        } catch (Exception e) {
            System.err.println("Error al obtener la lista de profesores: " + e.getMessage());
        }
    }
}
