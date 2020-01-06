package entities;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.istack.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "student")
@EntityListeners( AgeUpdateListener.class )
public class Student implements Property {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "fullName")
    private String  fullName;
	
	@NotNull
	@Column(name = "dob")
    private Date dob;
	
	@Transient
    private int age;
	
	@NotNull
	@Column(name = "mark")
    private Float mark;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "groups_id", nullable = true)
    Groups groups;
    
	@Embedded
	private Performance performance;
	
    public Student() {
		super();
	}
    
    private Date created;
    private Date updated;
  //  private Date deleted;
    

    // timestamps
	public Date getCreated() {
		return created;
	}


	public void setCreated(Date created) {
		this.created = created;
	}


	public Date getUpdated() {
		return updated;
	}


	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	

	public int getAge() {
		return age;
	}


	public void setAge(int l) {
		this.age = l;
	}


	public Student(/*Long id,*/ String fullName, Date dob, Float mark, Performance per) {
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


	@Override
	public String toString() {
		return "Student [id=" + id + ", fullName=" + fullName + ", dob=" + dob + ", age=" + age + ", mark=" + mark
				+ ", groups=" + groups + ", performance=" + performance + ", created=" + created + ", updated="
				+ updated + "]";
	}


	public Performance getPerformance() {
		return performance;
	}




	public void setPerformance(Performance performance) {
		this.performance = performance;
	}


	
   // @GeneratedValue(strategy=GenerationType.AUTO)
    
    // lifecycle events
	@PreUpdate
	public void setUpdatedTime() {
		this.setUpdated(new Date());
	}
	
	@PrePersist
	public void setCreatedTime() {
		this.setCreated(new Date());
	}
	
	

    
}

class AgeUpdateListener{
	@PreUpdate
	public void UpdateAge(Student s) {
		s.setAge((int)ChronoUnit.YEARS.between( LocalDateTime.ofInstant(
				Instant.ofEpochMilli( s.getDob().getTime()), ZoneOffset.UTC),
			LocalDateTime.now())
		);
	}
}
