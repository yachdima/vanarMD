import java.util.ArrayList;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class AnonimousClassApp {

	public static void main(String[] args) {

		// Consumer lambda
		Consumer<Student> showPretty = s -> System.out.println( "------------------------------\n" + s + "------------------------------\n" );
		
		// Predicate lambda
		Predicate<? super Student> f = mark ->mark.getMark() >= 8f;
		
		ArrayList<Student> students = new ArrayList<Student>();
		students.add(new Student("Vasea",5f));
		students.add(new Student("Petea",8f));
		students.add(new Student("Jora",2f));
		students.add(new Student("Evghenii",10f));
		students.add(new Student("Iulia",5.5f));
		students.add(new Student("Artem",15.5f));
		students.add(new Student("Masha",3f));
		students.add(new Student("Venera",25.1f));
		
		students
			.stream()
			.filter(f)
			.sorted(new Comparator<Student>(){
				public int compare(Student s1, Student s2) {
			        Float a = s1.getMark();
			        Float b = s2.getMark();
			        return a < b ? 1 : a == b ? 0 : -1;
			      }
				}
					)
			.forEach( showPretty );

	}

}


class Student {
	
	private String name;
	private Float mark;
	
	public Student(String name, Float mark) {
		super();
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getMark() {
		return mark;
	}

	public void setMark(Float mark) {
		this.mark = mark;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", mark=" + mark + "]";
	}
	
	
}