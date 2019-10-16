package unsafe;

public class VolatileApplication {

	public static void main(String[] args) {
		String name = "John";
		Integer age = 30;
		Boolean employed = true;
		
		System.out.println("Before");
		System.out.println(name.hashCode());
		System.out.println(age.hashCode());
		System.out.println(employed.hashCode());
		
		
		name = name + " D.";
		age++;
		employed = false;
		
		System.out.println("After");
		System.out.println(name.hashCode());
		System.out.println(age.hashCode());
		System.out.println(employed.hashCode());
	}

}
