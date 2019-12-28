package entities;

import java.util.List;

import javax.persistence.*;

import com.sun.istack.NotNull;

@Entity
@Table(name = "groups")
public class Groups implements Property {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 	
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

	public Groups(String name) {
		super();
		this.name = name;
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

	@Override
	public Long getValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
