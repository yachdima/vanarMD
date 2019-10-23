package data;

import java.util.Calendar;
import java.util.Date;

public class Student {
	private String fullname;
	private Date dob;
	private Float mark;
	private Integer id;
	

	public Student(Integer id, String fullname, Date dob, Float mark) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.dob = dob;
		this.mark = mark;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String fullname, Date dob, Float mark) {
		super();
		this.fullname = fullname;
		this.dob = dob;
		this.mark = mark;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date date) {
		this.dob = date;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [fullname=" + fullname + ", dob=" + dob + ", mark=" + mark + "]";
	}
	
	
	public int getAge() {
		Calendar cal = Calendar.getInstance();
		return cal.get(cal.YEAR) - dob.getYear();
		
	}

}
