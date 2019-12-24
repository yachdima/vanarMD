package entities;

import java.sql.Date;

import javax.persistence.Entity;

@Entity(name = "JMHJoinPhDStudent")
public class JMHJoinPhDStudent extends JMHJoinMasterStudent{
	private String institution;


	public JMHJoinPhDStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JMHJoinPhDStudent(String fullName, Date dob, Float mark, Performance per, DegreeLevel level, String institution) {
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
