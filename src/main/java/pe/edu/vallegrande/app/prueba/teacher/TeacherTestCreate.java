package pe.edu.vallegrande.app.prueba.teacher;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestCreate {
		
	public static void main(String[] args) {
		try {
			Teacher teacher = new Teacher(8, "DNI", "73931436", "Jesus", "Manzo Candela",
					"2001-08-21", "DIRECTOR", "E", "40");
			
			CrudTeacherService crudTeacherService = new CrudTeacherService();
			crudTeacherService.insert(teacher);
			System.out.println("Se Creo correctamente");
		} catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
