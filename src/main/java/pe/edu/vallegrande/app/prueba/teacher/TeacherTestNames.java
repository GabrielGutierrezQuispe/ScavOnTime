package pe.edu.vallegrande.app.prueba.teacher;

import java.util.List;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestNames {
	public static void main(String[] args) {
        try {
            CrudTeacherService teacherService = new CrudTeacherService();
            String names = "Antony"; // Nombres por los cuales deseas buscar
            List<Teacher> teacherList = teacherService.getByNames(names);
            
            if (!teacherList.isEmpty()) {
                System.out.println("Profesores encontrados con nombres que contienen '" + names + "':");
                for (Teacher teacher : teacherList) {
                    System.out.println(teacher);
                }
            } else {
                System.out.println("No se encontraron profesores con nombres que contengan '" + names + "'");
            }
        } catch (Exception e) {
            System.err.println("Error al buscar profesores: " + e.getMessage());
        }
    }
}
