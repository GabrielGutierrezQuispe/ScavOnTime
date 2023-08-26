package pe.edu.vallegrande.app.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.CrudTeacherService;

@WebServlet({ "/TeacherProcesar", "/TeacherEliminar", "/TeacherBuscar","/TeacherActivar" })
public class TeacherController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private CrudTeacherService service = new CrudTeacherService();

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String path = request.getServletPath();
		switch (path) {
		case "/TeacherProcesar":
//			buscar(request, response);
			procesar(request, response);
			break;
		case "/TeacherEliminar":
			eliminar(request, response);
			break;
		case "/TeacherActivar":
			activar(request, response);
			break;
		case "/TeacherBuscar":
			buscar(request, response);
			break;
		}
	}

	private void procesar(HttpServletRequest request, HttpServletResponse response) {
		// Datos
		String accion = request.getParameter("accion");
		Teacher bean = new Teacher();
		
		if(request.getParameter("id") != ControllerUtil.STRING_EMPTY) {
			bean.setId(Integer.parseInt(request.getParameter("id")));
		}
		
		if(request.getParameter("workday").length() < 2) {
			bean.setworkday("0" + request.getParameter("workday"));
		} else {
			bean.setworkday(request.getParameter("workday"));
		}
		
		bean.setDocumentType(request.getParameter("document_type"));
		bean.setDocumentNumber(request.getParameter("document_number"));
		bean.setNames(request.getParameter("names"));
		bean.setLastnames(request.getParameter("lastnames"));
		bean.setBirthdate(request.getParameter("birthdate"));
		bean.setTypeCharge(request.getParameter("type_charge"));
		bean.setTypeCondition(request.getParameter("type_condition"));
		// proceso
		try {
			switch (accion) {
			case ControllerUtil.CRUD_NUEVO:
				service.insert(bean);
			case ControllerUtil.CRUD_EDITAR:
				service.update(bean);	
				break;
			}
			ControllerUtil.responseJson(response, "Teacher procesado con exito");
		} catch (Exception e) {
			ControllerUtil.responseJson(response, e.getMessage());
		}

	}
	
	private void buscar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Datos		
		String active = "A";
		if(request.getParameter("active") != ControllerUtil.STRING_EMPTY) {
			active = request.getParameter("active");
		}
		String filter = request.getParameter("filter");
		String documentType = request.getParameter("documentType");
		
		List<Teacher> listar = service.getByFilter(active, filter, documentType);
		// preparando el JSON
		Gson gson = new Gson();
		String data = gson.toJson(listar);
		// reporte
		ControllerUtil.responseJson(response, data);

	}
	
	private void eliminar(HttpServletRequest request, HttpServletResponse response) {

		Integer profesorId = Integer.parseInt(request.getParameter("id"));
		
		service.delete(profesorId);
	}
	private void activar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer ActivarprofesorId = Integer.parseInt(request.getParameter("id"));
		service.active(ActivarprofesorId);
	}
}
