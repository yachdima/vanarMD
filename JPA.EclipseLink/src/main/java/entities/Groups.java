package entities;

import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity

public class Groups {
	@Id
	@Column(name = "id")
	private Long id;
	
	@NotNull
	@Column(name = "name")
    private String  name;
	
	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinColumn(name = "faculty_id", nullable = true)
    private Faculty faculty;
	
	@OneToMany(mappedBy="groups")
    private List<Student> students;

	public Groups() {
		super();
	}

	public Groups(Long id, String name, Faculty faculty, List<Student> students) {
		super();
		this.id = id;
		this.name = name;
		this.faculty = faculty;
		this.students = students;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Groups [id=" + id + ", name=" + name + ", faculty=" + faculty + ", students=" + students + "]";
	}
	
	

}
