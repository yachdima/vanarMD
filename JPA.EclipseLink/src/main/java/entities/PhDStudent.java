package entities;

import java.sql.Date;

import javax.persistence.Entity;

@Entity(name = "PhDStudent")
public class PhDStudent extends MasterStudent{
	private String institution;


	public PhDStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhDStudent(String fullName, Date dob, Float mark, Performance per, DegreeLevel level, String institution) {
		super(fullName, dob, mark, per, level);
		this.institution = institution;
	}
	
	

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	@Override
	public String toString() {
		return "PhDStudent [institution=" + institution + ", groups=" + groups + "]";
	}
	
	
}
