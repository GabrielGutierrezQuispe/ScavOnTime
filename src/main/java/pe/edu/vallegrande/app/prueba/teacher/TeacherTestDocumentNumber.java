package pe.edu.vallegrande.app.prueba.teacher;

import java.util.List;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestDocumentNumber {
	public static void main(String[] args) {
        try {
            CrudTeacherService teacherService = new CrudTeacherService();
            String documentNumber = "73931473"; // Número de documento que deseas buscar
            List<Teacher> teacherList = teacherService.getByDocumentNumber(documentNumber);
            
            if (!teacherList.isEmpty()) {
                System.out.println("Profesores encontrados con el número de documento " + documentNumber + ":");
                for (Teacher teacher : teacherList) {
                    System.out.println(teacher);
                }
            } else {
                System.out.println("No se encontraron profesores con el número de documento " + documentNumber);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar profesores: " + e.getMessage());
        }
    }
}
