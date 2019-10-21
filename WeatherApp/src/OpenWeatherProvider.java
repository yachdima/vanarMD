import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class OpenWeatherProvider {

	public static void main(String[] args) throws MalformedURLException, IOException {
		
		//String json_string = "{ \"name\": \"Ion\", \"age\": 25}";
		
		//final String ENDPOINT = "http://api.openweathermap.org/data/2.5/weather?q=London,uk&APPID=f76d87522ec21f57fa141fee2c7ba73e";
		
		//final String ENDPOINT = "https://api.openweathermap.org/data/2.5/weather?q=Chisinau&units=metric,618426&APPID=f76d87522ec21f57fa141fee2c7ba73e";
		
		
		
		System.out.println(getCurrentTemperature("Chisinau"));
//		System.out.println(json.getInt("age"));
	}
	
	/**
	 * endpoint: api.openweathermap.org/data/2.5/weather
	 * params: city, units
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * */
	public static Float  getCurrentTemperature(String city) throws MalformedURLException, IOException {
		String ENDPOINT = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&appid=f76d87522ec21f57fa141fee2c7ba73e";
		
		Scanner in = new Scanner(new URL(ENDPOINT).openStream());
		
		String json_string = in.nextLine();
		
		//System.out.println(json_string);
		
		JSONObject json = new JSONObject(json_string);
		Float temp = json.getJSONObject("main").getFloat("temp");
		
		return temp;
	}
	
	/**
	 * endpoint: api.openweathermap.org/data/2.5/forecast/daily
	 * params: city, units
	 * */	
	public ArrayList<Float>  getForecast16DaysTemperature(String city) {
		String ENDPOINT = "https://api.openweathermap.org/data/2.5/weather?q="+city+"&units=metric&cnt=16&appid=f76d87522ec21f57fa141fee2c7ba73e";
		
		Scanner in = new Scanner(new URL(ENDPOINT).openStream());
		
		String json_string = in.nextLine();
		
		//System.out.println(json_string);
		
		JSONObject json = new JSONObject(json_string);
		Float temp = json.getJSONObject("main").getFloat("temp");
		
		return temp;
	}

}
