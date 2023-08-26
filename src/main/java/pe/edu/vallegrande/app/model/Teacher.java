package pe.edu.vallegrande.app.model;

public class Teacher {

	private Integer id;
	private String documentType;
	private String documentNumber;
	private String names;
	private String lastnames;
	private String birthdate;
	private String typeCharge;
	private String typeCondition;
	private String workday;
	private String active;

	public Teacher() {

	}

	public Teacher(Integer id, String documentType, String documentNumber, String names, String lastnames,
			String birthdate, String typeCharge, String typeCondition, String workday) {
		super();
		this.id = id;
		this.documentType = documentType;
		this.documentNumber = documentNumber;
		this.names = names;
		this.lastnames = lastnames;
		this.birthdate = birthdate;
		this.typeCharge = typeCharge;
		this.typeCondition = typeCondition;
		this.workday = workday;
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getDocumentType() {
		return documentType;
	}
	
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getlastnames() {
		return lastnames;
	}

	public void setLastnames(String lastnames) {
		this.lastnames = lastnames;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getTypeCharge() {
		return typeCharge;
	}

	public void setTypeCharge(String typeCharge) {
		this.typeCharge = typeCharge;
	}

	public String getTypeCondition() {
		return typeCondition;
	}

	public void setTypeCondition(String typeCondition) {
		this.typeCondition = typeCondition;
	}
	public String getWorkday() {
		return workday;
	}

	public void setworkday(String workday) {
		this.workday = workday;
	}
	
	
	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", documentType=" + documentType + ", documentNumber=" + documentNumber
				+ ", names=" + names + ", surnames=" + lastnames + ", birthdate=" + birthdate + ", typeCharge="
				+ typeCharge + ", typeCondition=" + typeCondition +",workday=" + workday + "]";
	}

	
	
}

