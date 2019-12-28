package entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;

import com.sun.istack.NotNull;

import entities.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Award {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 	@Column(name = "id")
	private Long id;
	
	@Any(
	        metaDef = "AwardMetaDef",
	        metaColumn = @Column( name = "award_type" )
	    )
	
	@AnyMetaDef( name= "AwardMetaDef", metaType = "string", idType = "long",
    metaValues = {
            @MetaValue(value = "student", targetEntity = Student.class),
            @MetaValue(value = "groups", targetEntity = Groups.class)
        }
    )
	
	@JoinColumn( name = "entit_id" )
	private Property property;
	
	@NotNull
	@Column(name = "title")
	private String title;
	
	@NotNull
	@Column(name = "date")
	private Date date;
	
	
	public static enum Type {
		MEDAL,
		TROPHY,
		DIMPLOMA
	    }
	
	 @Enumerated(EnumType.STRING)
	 private Type type;

	

	public Award(Property property, String title, Date date, Type type) {
		this.property = property;
		this.title = title;
		this.date = date;
		this.type = type;
	}

	public Award() {
		super();
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Award [id=" + id + ", title=" + title + ", date=" + date + ", type=" + type
				+ "]";
	}
	 
	 
}
