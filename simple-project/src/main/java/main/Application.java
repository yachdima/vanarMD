package main;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Application {
	public static void main(String[] args) {
		System.out.println("RUN");
		
		List<Method> methods = Arrays.asList( main.Application.class.getMethods() );
		for(Method method : methods) {
			System.out.println(method.getName());
			System.out.println(method.getReturnType().getTypeName());
			System.out.println(method.getParameters()[0].getParameterizedType().getTypeName());
		}
	}
	
	public void requiredMethod(boolean b ) {
		
	}
	
	public Boolean anotherMethod(String arg) {
		return false;
	}
}
