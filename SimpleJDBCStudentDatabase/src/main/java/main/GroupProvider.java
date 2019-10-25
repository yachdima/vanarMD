package main;

import java.util.ArrayList;
import java.util.Locale;

import com.github.javafaker.Faker;

import data.Group;
import data.Student;

public class GroupProvider {
	
	public Group provideOneGroup() {
		Group group = new Group();
		Faker faker = new Faker(new Locale("ru"));
		group.setName(faker.name().name());
		group.setCode(faker.code().toString());
		return group;
		
	}
	
	public ArrayList provideManyGroups(int quantity) {
		ArrayList<Group> groups = new ArrayList<>();
		Group group = new Group();
		
		for(int i = 0; i < quantity; i++) {
			group =  provideOneGroup();
			groups.add(group);
		}
		
		return null;
		
	}
			
}
