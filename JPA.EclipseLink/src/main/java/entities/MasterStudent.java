package entities;

import java.sql.Date;

import javax.persistence.Entity;

@Entity(name = "MasterStudent")
public class MasterStudent extends Student{
	public static enum DegreeLevel {
		   NOOB,
	       ADVANCED
	    }
	private DegreeLevel level;
	
	
	
	public MasterStudent() {
		super();
		// TODO Auto-generated constructor stub
	}


	public MasterStudent(String fullName, Date dob, Float mark, Performance per,DegreeLevel level) {
		super(fullName, dob, mark, per);
		this.level = level;
	}


	@Override
	public String toString() {
		return "MasterStudent [level=" + level + ", groups=" + groups + "]";
	}

	
	
}
