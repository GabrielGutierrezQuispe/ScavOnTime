package pe.edu.vallegrande.app.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.vallegrande.app.db.AccesoDB;
import pe.edu.vallegrande.app.model.Teacher;
import pe.edu.vallegrande.app.service.spec.CrudServiceSpec;

public class CrudTeacherService implements CrudServiceSpec<Teacher> {
	// variables generales
	private Connection connection;
	private PreparedStatement statement;

	// Listar a la lista de los docentes
	@Override
	public List<Teacher> getAll() {
		List<Teacher> listaTeacher = new ArrayList<>();

		String sql = "SELECT * FROM teacher WHERE active = 'A'";

		try {
			connection = AccesoDB.getConnection();
			statement = connection.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setDocumentType(resultSet.getString("document_type"));
				teacher.setDocumentNumber(resultSet.getString("document_number"));
				teacher.setNames(resultSet.getString("names"));
				teacher.setLastnames(resultSet.getString("lastnames"));
				teacher.setBirthdate(resultSet.getDate("birthdate").toString());
				teacher.setTypeCharge(resultSet.getString("type_charge"));
				teacher.setTypeCondition(resultSet.getString("type_condition"));
				teacher.setworkday(resultSet.getString("workday"));

				listaTeacher.add(teacher);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return listaTeacher;
	}

	private void closeResources() {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Consultar Por ID Teacher
	@Override
	public Teacher getForId(Integer id) {
		Teacher teacher = null;
		String sql = "SELECT * FROM teacher WHERE id = ?";

		try {
			connection = AccesoDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setDocumentType(resultSet.getString("document_type"));
				teacher.setDocumentNumber(resultSet.getString("document_number"));
				teacher.setNames(resultSet.getString("names"));
				teacher.setLastnames(resultSet.getString("lastnames"));
				teacher.setBirthdate(resultSet.getDate("birthdate").toString());
				teacher.setTypeCharge(resultSet.getString("type_charge"));
				teacher.setTypeCondition(resultSet.getString("type_condition"));
				teacher.setworkday(resultSet.getString("workday"));
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return teacher;
	}

	// Consultar por Tipo de documento
	public List<Teacher> getByDocumentType(String documentType) {
		List<Teacher> teacherList = new ArrayList<>();
		String sql = "SELECT * FROM teacher WHERE document_type = ?";

		try {
			connection = AccesoDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, documentType);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setDocumentType(resultSet.getString("document_type"));
				teacher.setDocumentNumber(resultSet.getString("document_number"));
				teacher.setNames(resultSet.getString("names"));
				teacher.setLastnames(resultSet.getString("lastnames"));
				teacher.setBirthdate(resultSet.getDate("birthdate").toString());
				teacher.setTypeCharge(resultSet.getString("type_charge"));
				teacher.setTypeCondition(resultSet.getString("type_condition"));
				teacher.setworkday(resultSet.getString("workday"));

				teacherList.add(teacher);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return teacherList;
	}

	// ...
	// COnsultar por NUMERO DE DOCUMENTO
	public List<Teacher> getByDocumentNumber(String documentNumber) {
		List<Teacher> teacherList = new ArrayList<>();
		String sql = "SELECT * FROM teacher WHERE document_number = ?";

		try {
			connection = AccesoDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, documentNumber);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setDocumentType(resultSet.getString("document_type"));
				teacher.setDocumentNumber(resultSet.getString("document_number"));
				teacher.setNames(resultSet.getString("names"));
				teacher.setLastnames(resultSet.getString("lastnames"));
				teacher.setBirthdate(resultSet.getDate("birthdate").toString());
				teacher.setTypeCharge(resultSet.getString("type_charge"));
				teacher.setTypeCondition(resultSet.getString("type_condition"));
				teacher.setworkday(resultSet.getString("workday"));

				teacherList.add(teacher);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return teacherList;
	}

	// Consultar por NOMBRES
	public List<Teacher> getByNames(String names) {
		List<Teacher> teacherList = new ArrayList<>();
		String sql = "SELECT * FROM teacher WHERE active = 'A' AND names LIKE ?";

		try {
			connection = AccesoDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + names + "%");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setDocumentType(resultSet.getString("document_type"));
				teacher.setDocumentNumber(resultSet.getString("document_number"));
				teacher.setNames(resultSet.getString("names"));
				teacher.setLastnames(resultSet.getString("lastnames"));
				teacher.setBirthdate(resultSet.getDate("birthdate").toString());
				teacher.setTypeCharge(resultSet.getString("type_charge"));
				teacher.setTypeCondition(resultSet.getString("type_condition"));
				teacher.setworkday(resultSet.getString("workday"));

				teacherList.add(teacher);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return teacherList;
	}

	// Consultar por APELLIDOS
	public List<Teacher> getByLastnames(String lastnames) {
		List<Teacher> teacherList = new ArrayList<>();
		String sql = "SELECT * FROM teacher WHERE lastnames LIKE ?";

		try {
			connection = AccesoDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setString(1, "%" + lastnames + "%");
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setDocumentType(resultSet.getString("document_type"));
				teacher.setDocumentNumber(resultSet.getString("document_number"));
				teacher.setNames(resultSet.getString("names"));
				teacher.setLastnames(resultSet.getString("lastnames"));
				teacher.setBirthdate(resultSet.getDate("birthdate").toString());
				teacher.setTypeCharge(resultSet.getString("type_charge"));
				teacher.setTypeCondition(resultSet.getString("type_condition"));
				teacher.setworkday(resultSet.getString("workday"));

				teacherList.add(teacher);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return teacherList;
	}

	// Consultar por Fecha de cumpleaños
	public List<Teacher> getByBirthdate(Date birthdate) {
		List<Teacher> teacherList = new ArrayList<>();
		String sql = "SELECT * FROM teacher WHERE birthdate = ?";

		try {
			connection = AccesoDB.getConnection();
			statement = connection.prepareStatement(sql);
			statement.setDate(1, birthdate);
			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				Teacher teacher = new Teacher();
				teacher.setId(resultSet.getInt("id"));
				teacher.setDocumentType(resultSet.getString("document_type"));
				teacher.setDocumentNumber(resultSet.getString("document_number"));
				teacher.setNames(resultSet.getString("names"));
				teacher.setLastnames(resultSet.getString("lastnames"));
				teacher.setBirthdate(resultSet.getDate("birthdate").toString());
				teacher.setTypeCharge(resultSet.getString("type_charge"));
				teacher.setTypeCondition(resultSet.getString("type_condition"));
				teacher.setworkday(resultSet.getString("workday"));

				teacherList.add(teacher);
			}

			resultSet.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources();
		}

		return teacherList;
	}
	
	// Consultar por Fecha de cumpleaños
		public List<Teacher> getByFilter(String active, String filter, String documentType) {
			List<Teacher> teacherList = new ArrayList<>();
			String sql = "SELECT * FROM teacher "
					+ "WHERE active = ? "
					+ "AND document_type LIKE ? "
					+ "AND (document_number LIKE ? "
					+ "OR LOWER(names) LIKE LOWER(?) "
					+ "OR LOWER(lastnames) LIKE LOWER(?) "
					+ "OR LOWER(type_charge) LIKE LOWER(?)) "
					+ "ORDER BY names, lastnames";

			try {
				connection = AccesoDB.getConnection();
				statement = connection.prepareStatement(sql);
				statement.setString(1, active);
				statement.setString(2, "%" + documentType + "%");
				statement.setString(3, "%" + filter + "%");
				statement.setString(4, "%" + filter + "%");
				statement.setString(5, "%" + filter + "%");
				statement.setString(6, "%" + filter + "%");
				
				ResultSet resultSet = statement.executeQuery();

				while (resultSet.next()) {
					Teacher teacher = new Teacher();
					teacher.setId(resultSet.getInt("id"));
					teacher.setDocumentType(resultSet.getString("document_type"));
					teacher.setDocumentNumber(resultSet.getString("document_number"));
					teacher.setNames(resultSet.getString("names"));
					teacher.setLastnames(resultSet.getString("lastnames"));
					teacher.setBirthdate(resultSet.getDate("birthdate").toString());
					teacher.setTypeCharge(resultSet.getString("type_charge"));
					teacher.setTypeCondition(resultSet.getString("type_condition"));
					teacher.setworkday(resultSet.getString("workday"));
					teacher.setActive(resultSet.getString("active"));

					teacherList.add(teacher);
				}

				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeResources();
			}

			return teacherList;
		}

	// Guardar teacher
	@Override
	public void insert(Teacher bean) {

		String sql = null;

		try {

			connection = AccesoDB.getConnection();

			sql = "INSERT INTO teacher (document_type, document_number, names, lastnames, birthdate,  type_charge, type_condition, workday) VALUES (?,?,?,?,?,?,?,?)";
			statement = connection.prepareStatement(sql);

			statement.setString(1, bean.getDocumentType());
			statement.setString(2, bean.getDocumentNumber());
			statement.setString(3, bean.getNames());
			statement.setString(4, bean.getlastnames());
			statement.setString(5, bean.getBirthdate());
			statement.setString(6, bean.getTypeCharge());
			statement.setString(7, bean.getTypeCondition());
			statement.setString(8, bean.getWorkday());

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// editar teacher
	@Override
	public void update(Teacher bean) {
		String sql = null;

		try {

			connection = AccesoDB.getConnection();
			sql = "UPDATE teacher SET document_type=?, document_number=?, names=?, lastnames=?, birthdate=?,  type_charge=?, type_condition=?, workday=? WHERE id=?";
			statement = connection.prepareStatement(sql);

			statement.setString(1, bean.getDocumentType());
			statement.setString(2, bean.getDocumentNumber());
			statement.setString(3, bean.getNames());
			statement.setString(4, bean.getlastnames());
			statement.setString(5, bean.getBirthdate());
			statement.setString(6, bean.getTypeCharge());
			statement.setString(7, bean.getTypeCondition());
			statement.setString(8, bean.getWorkday());
			statement.setInt(9, bean.getId());

			statement.executeUpdate();

			statement.close();
			connection.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	// eliminar Teacher
	@Override
	public void delete(Integer id) {

		String sql = null;

		try {
			connection = AccesoDB.getConnection();

			sql = "UPDATE teacher SET active = 'I' WHERE id=?";
			statement = connection.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	//Reactivar Profesor 
		@Override
		public void active(Integer id) {
		    String sql = null;

		    try {
		        connection = AccesoDB.getConnection();

		        sql = "UPDATE teacher SET active = 'A' WHERE id=?";
		        statement = connection.prepareStatement(sql);
		        statement.setInt(1, id);
		        statement.executeUpdate();

		        statement.close();
		        connection.close();

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
	@Override
	public List<Teacher> get(Teacher bean) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		
	}

}
