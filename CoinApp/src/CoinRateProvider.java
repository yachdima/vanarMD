import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;

public class CoinRateProvider {
	public static Map<String, Object> map_rates;
	
	public static HashMap<String, Float> hash_map_curr = new HashMap<String, Float>();
	
	/**
	 * endpoint: Reques thttps://api.coinlayer.com/live
	 * возвращает карту где код валюты - ключ, а коэфициент - значение
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * */
	public static HashMap<String,Float>  getLiveRates() throws MalformedURLException, IOException {
		
		for(String key: map_rates.keySet()){
			hash_map_curr.put(key, Float.parseFloat(String.valueOf(map_rates.get(key))));
		}
		
		return hash_map_curr;
	}

	/**
	 * endpoint: Request https://api.coinlayer.com/live
	 * возвращает карту где код валюты - ключ, а коэфициент - значение
	 * параметр "currencies" служит фильтром (мы передаем коды тех валют что нас интересуют) 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * */
	public static HashMap<String,Float> getLiveRates(HashSet<String> currencies) throws MalformedURLException, IOException {
		
		for(String key: map_rates.keySet()){
			if(currencies.contains(key))
				hash_map_curr.put(key, Float.parseFloat(String.valueOf(map_rates.get(key))));
		}

		return hash_map_curr;
	}
	
	
	/**
	 * endpoint: https://api.coinlayer.com/YYYY-MM-DD
	 * возвращает карту где код валюты - ключ, а коэфициент - значение - за определенную дату
	 * */	
	public static HashMap<String,Float>  getHistoricalRates() {
		for(String key: map_rates.keySet()){
			hash_map_curr.put(key, Float.parseFloat(String.valueOf(map_rates.get(key))));
		}
		
		return hash_map_curr;
	}	

	/**
	 * endpoint: https://api.coinlayer.com/YYYY-MM-DD
	 * возвращает карту где код валюты - ключ, а коэфициент - значение - за определенную дату
	 * параметр "currencies" служит фильтром (мы передаем коды тех валют что нас интересуют) 
	 * */	
	public static HashMap<String,Float>  getHistoricalRates(HashSet<String> currencies) {
		for(String key: map_rates.keySet()){
			if(currencies.contains(key))
				hash_map_curr.put(key, Float.parseFloat(String.valueOf(map_rates.get(key))));
		}

		return hash_map_curr;
	}	

}
