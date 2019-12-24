package entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class JMHJoinStudent {
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
    
	@Embedded
	private Performance performance;
    
    public JMHJoinStudent() {
		super();
	}
    
    public JMHJoinStudent(/*Long id,*/ String fullName, Date dob, Float mark, Performance per) {
		super();
		//this.id = id;
		this.fullName = fullName;
		this.dob = dob;
		this.mark = mark;
		this.performance = per;
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



	public Performance getPerformance() {
		return performance;
	}

	public void setPerformance(Performance performance) {
		this.performance = performance;
	}

	@Override
	public String toString() {
		return "JoinStudent [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", mark=" + mark + ", groups=" + groups
				+ "]";
	}


}
