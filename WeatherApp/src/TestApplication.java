import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class TestApplication {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		//String json_string = "{ \"name\": \"Ion\", \"age\": 25}";
		
		final String ENDPOINT = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=f76d87522ec21f57fa141fee2c7ba73e";
		
		Scanner in = new Scanner(new URL(ENDPOINT).openStream());
		
		String json_string = in.nextLine();
		
		//System.out.println(json_string);
		
		JSONObject json = new JSONObject(json_string);
		Float temp = json.getJSONObject("main").getFloat("temp");
		
		System.out.println(temp);
//		System.out.println(json.getInt("age"));
	}

}
