package pe.edu.vallegrande.app.prueba.teacher;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestUpdate {
	public static void main(String[] args) {
		try {
			Teacher teacher = new Teacher(5, "DNI", "73931436", "Luis", "Manzo Candela",
					"2001-08-21", "DIRECTOR", "E", "40");

			CrudTeacherService crudTeacherService = new CrudTeacherService();
			crudTeacherService.update(teacher);
			System.out.println("Se Actualizo Correctamente");
		} catch (Exception e) {

		}

	}
}
