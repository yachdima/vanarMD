package entities;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity

public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "fullName")
    private String  fullName;
	
	@NotNull
	@Column(name = "dob")
    private Date dob;
	
	@NotNull
	@Column(name = "mark")
    private Float mark;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "groups_id", nullable = true)
    Groups groups;
    
    
    public Student() {
		super();
	}
    


	public Student(/*Long id,*/ String fullName, Date dob, Float mark) {
		super();
		//this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.mark = mark;
	}



	public Date getDob() {
		return dob;
	}



	public void setDob(Date dob) {
		this.dob = dob;
	}



	public Float getMark() {
		return mark;
	}



	public void setMark(Float mark) {
		this.mark = mark;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", mark=" + mark + ", groups=" + groups
				+ "]";
	}



	

	
   // @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
}