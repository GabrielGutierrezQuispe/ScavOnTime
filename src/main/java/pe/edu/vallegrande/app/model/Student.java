package pe.edu.vallegrande.app.model;

public class Student {

	private Integer student_id;
	private String names;
	private String lastname;
	private String email;
	private String document_type;
	private String document_number;
	private String active;

	public Student() {
	}

	public Student(Integer student_id, String names, String lastname, String email, String document_type,
				   String document_number, String active) {
		super();
		this.student_id = student_id;
		this.names = names;
		this.lastname = lastname;
		this.email = email;
		this.document_type = document_type;
		this.document_number = document_number;
		this.active = active;
	}


	/**
	 * @return the student_id
	 */
	public Integer getStudent_id() {
		return student_id;
	}

	/**
	 * @param student_id the student_id to set
	 */
	public void setStudent_id(Integer student_id) {
		this.student_id = student_id;
	}

	/**
	 * @return the names
	 */
	public String getNames() {
		return names;
	}

	/**
	 * @param names the names to set
	 */
	public void setNames(String names) {
		this.names = names;
	}

	/**
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * @param lastname the lastname to set
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the document_type
	 */
	public String getDocument_type() {
		return document_type;
	}

	/**
	 * @param document_type the document_type to set
	 */
	public void setDocument_type(String document_type) {
		this.document_type = document_type;
	}

	/**
	 * @return the document_number
	 */
	public String getDocument_number() {
		return document_number;
	}

	/**
	 * @param document_number the document_number to set
	 */
	public void setDocument_number(String document_number) {
		this.document_number = document_number;
	}

	/**
	 * @return the active
	 */
	public String getActive() {
		return active;
	}

	/**
	 * @param active the active to set
	 */
	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		String data = "[student_id: " + this.student_id;
		data += ", names: " + this.names;
		data += ", lastname: " + this.lastname;
		data += ", email: " + this.email;
		data += ", document_type: " + this.document_type;
		data += ", document_number: " + this.document_number;
		data += ", active: " + this.active + "]";
		return data;
	}


}