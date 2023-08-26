package pe.edu.vallegrande.app.prueba.teacher;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

import java.util.List;

public class TeacherListTest {
    public static void main(String[] args) {
        try {
            CrudTeacherService teacherService = new CrudTeacherService();
            List<Teacher> listaTeacher = teacherService.getAll();

            if (!listaTeacher.isEmpty()) {
                System.out.println("Lista de docentes encontrada:");
                for (Teacher teacher : listaTeacher) {
                    System.out.println(teacher);
                }
            } else {
                System.out.println("No se encontraron docentes en la lista.");
            }
        } catch (Exception e) {
            System.err.println("Error al obtener la lista de docentes: " + e.getMessage());
        }
    }
}
