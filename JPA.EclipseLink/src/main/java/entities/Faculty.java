package entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Faculty {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
    private String  name;
	
	@OneToMany(mappedBy="faculty")
    private List<Groups> groups;

	public Faculty() {
		super();
	}

	public Faculty(String name) {
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

	public List<Groups> getGroups() {
		return groups;
	}

	public void setGroups(List<Groups> groups) {
		this.groups = groups;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", groups=" + groups + "]";
	}
	
	
}

