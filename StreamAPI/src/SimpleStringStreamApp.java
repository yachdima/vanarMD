import java.util.ArrayList;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleStringStreamApp {
	public static void main(String[] args) {
		
		ArrayList<String> names = new ArrayList<>();
		
		names.add("Irina");
		names.add("Ivan");
		names.add("Andrei");
		names.add("Tatiana");
		names.add("Iliana");
		
		Predicate<? super String> select = name -> name.substring(0, 1).equals("I");
		Function<String,String> upper = name -> name.toUpperCase();
		
		// STREAM
		names
			.stream() // create stream
			.skip(1) // ���������� 1
			.limit(3) //  ������� ������ 3
			//.filter(name -> name.substring(0, 1).equals("I"))
			.filter(select)
			.map(upper)
			//f( String name) { return name.toUpperCase()} ��� ������ ����
			
			//.allMatch(s -> false)
			.forEach(System.out::println); // end stream
		// STREAM
		
	}
}

// ������� ��������� �����
// ���������� �����
//@FunctionalInterface
//interface Initials{
//	public boolean hasI(String name);
//}

