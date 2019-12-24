package entities;

import java.sql.Date;

import javax.persistence.Entity;

@Entity(name = "JMHJoinMasterStudent")
public class JMHJoinMasterStudent extends JMHJoinStudent{
	public static enum DegreeLevel {
		   NOOB,
	       ADVANCED
	    }
	private DegreeLevel level;
	
	
	
	public JMHJoinMasterStudent() {
		super();
		// TODO Auto-generated constructor stub
	}


	public JMHJoinMasterStudent(String fullName, Date dob, Float mark, Performance per,DegreeLevel level) {
		super(fullName, dob, mark, per);
		this.level = level;
	}


	@Override
	public String toString() {
		return "MasterStudent [level=" + level + ", groups=" + groups + "]";
	}

	
	
}
