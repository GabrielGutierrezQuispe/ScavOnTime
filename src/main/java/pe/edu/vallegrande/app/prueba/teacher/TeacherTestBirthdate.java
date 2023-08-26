package pe.edu.vallegrande.app.prueba.teacher;

import java.sql.Date;
import java.util.List;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestBirthdate {
	public static void main(String[] args) {
        try {
            CrudTeacherService teacherService = new CrudTeacherService();
            Date birthdate = Date.valueOf("2001-08-21"); // Fecha de nacimiento por la cual deseas buscar
            List<Teacher> teacherList = teacherService.getByBirthdate(birthdate);
            
            if (!teacherList.isEmpty()) {
                System.out.println("Profesores encontrados con fecha de nacimiento igual a '" + birthdate + "':");
                for (Teacher teacher : teacherList) {
                    System.out.println(teacher);
                }
            } else {
                System.out.println("No se encontraron profesores con fecha de nacimiento igual a '" + birthdate + "'");
            }
        } catch (Exception e) {
            System.err.println("Error al buscar profesores: " + e.getMessage());
        }
    }
}
