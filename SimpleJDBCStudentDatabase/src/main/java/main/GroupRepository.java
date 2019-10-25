package main;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import data.Group;
import data.Student;

public class GroupRepository extends Repository {
	
	public boolean install() {
		
		try {
			statement.executeUpdate("drop table groups");
			statement.executeUpdate("CREATE TABLE groups(\r\n" + 
					"    id INTEGER PRIMARY KEY AUTOINCREMENT, \r\n" + 
					"     name VARCHAR(30),\r\n" + 
					"     code VARCHAR(30)\r\n" + 
					" ); ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
		
	}
	
	public boolean addGroup(Group group) {
		try {
			String query = "INSERT INTO groups VALUES( null, '"+group.getName()+"', '"
																+group.getCode()+"');";
			System.out.println(query);
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	public ArrayList all() throws ParseException {
		ArrayList groups = new ArrayList<>();
		
		ResultSet r;
		try {
			r = statement.executeQuery("select * from groups");
			while (r.next()) {
				Group group = new Group(r.getInt("id"),
										r.getString("name"),
										r.getString("code"));
				groups.add(group);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return groups;
		
	}
	
	public void update( Group group ) {
		try {
			statement.executeUpdate("UPDATE groups SET name = '"+group.getName()+
																"', code = '"+group.getCode()+
																"';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete( Group group ) {
		try {
			statement.executeUpdate("DELETE FROM groups WHERE id = "+group.getId()+";");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
