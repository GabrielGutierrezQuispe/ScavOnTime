package pe.edu.vallegrande.app.prueba.teacher;


import pe.edu.vallegrande.app.service.CrudTeacherService;

public class TeacherTestDelete {
	public static void main(String[] args) {
		try {
			 Integer teacherId = 6;
			 
			 CrudTeacherService crudTeacherService = new CrudTeacherService();
			 crudTeacherService.delete(teacherId);
			 System.err.println("Elimino correctamente");
		 }catch(Exception e){
			 System.err.println("error al eliminar");
		 }
	}
	 
}
