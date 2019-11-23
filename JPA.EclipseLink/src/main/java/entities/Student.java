package entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class Student {
	@Id
	private Long id;
    private String  fullName;
    
    public Student() {
		super();
	}
    
    public Student(long id, String fullName) {
    	super();
		this.id = id;
		this.fullName = fullName;
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
		return "Student [id=" + id + ", fullName=" + fullName + "]";
	}
	
   // @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
}
