package entities;

import java.util.List;

import javax.persistence.*;

@Entity
public class Faculty {
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
    private String  name;
	
	@OneToMany(mappedBy="faculty")
    private List<Groups> groups;

	public Faculty() {
		super();
	}

	public Faculty(Long id, String name, List<Groups> groups) {
		super();
		this.id = id;
		this.name = name;
		this.groups = groups;
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

