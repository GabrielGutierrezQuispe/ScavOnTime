package pe.edu.vallegrande.app.prueba.teacher;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestID {
	 public static void main(String[] args) {
	        try {
	            CrudTeacherService teacherService = new CrudTeacherService();
	            int teacherId = 2; // ID del profesor que deseas consultar
	            Teacher teacher = teacherService.getForId(teacherId);
	            if (teacher != null) {
	                System.out.println("Profesor encontrado:");
	                System.out.println(teacher);
	            } else {
	                System.out.println("No se encontró el profesor con ID " + teacherId);
	            }
	        } catch (Exception e) {
	            System.err.println("Error al consultar el profesor: " + e.getMessage());
	        }
	    }

}
