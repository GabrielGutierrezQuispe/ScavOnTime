package pe.edu.vallegrande.app.prueba.teacher;

import java.util.List;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestLastNames {
	public static void main(String[] args) {
        try {
            CrudTeacherService teacherService = new CrudTeacherService();
            String lastnames = "Ascencio"; // Apellidos por los cuales deseas buscar
            List<Teacher> teacherList = teacherService.getByLastnames(lastnames);
            
            if (!teacherList.isEmpty()) {
                System.out.println("Profesores encontrados con apellidos que contienen '" + lastnames + "':");
                for (Teacher teacher : teacherList) {
                    System.out.println(teacher);
                }
            } else {
                System.out.println("No se encontraron profesores con apellidos que contengan '" + lastnames + "'");
            }
        } catch (Exception e) {
            System.err.println("Error al buscar profesores: " + e.getMessage());
        }
    }
}
