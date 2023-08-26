package pe.edu.vallegrande.app.prueba.teacher;

import java.util.List;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestDocumentType {
	public static void main(String[] args) {
        try {
            CrudTeacherService teacherService = new CrudTeacherService();
            String documentType = "CNE"; // Tipo de documento que deseas buscar
            List<Teacher> teacherList = teacherService.getByDocumentType(documentType);
            
            if (!teacherList.isEmpty()) {
                System.out.println("Profesores encontrados con el tipo de documento " + documentType + ":");
                for (Teacher teacher : teacherList) {
                    System.out.println(teacher);
                }
            } else {
                System.out.println("No se encontraron profesores con el tipo de documento " + documentType);
            }
        } catch (Exception e) {
            System.err.println("Error al buscar profesores: " + e.getMessage());
        }
    }
}
