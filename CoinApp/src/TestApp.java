import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONObject;

public class TestApp {
	
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		String ENDPOINT;
		Boolean flag = false;
		Scanner in;
		String json_string;
		JSONObject json;
		
		
		CoinRateProvider coinRatePr = new CoinRateProvider();
		
		Scanner inp = new Scanner(System.in);
		while(true) {
	        System.out.print("На дату?(Y/NO)");
	        String dat = inp.next();
			
			if(dat.equals("Y")) {
				System.out.print("Введите дату(YYYY-MM-DD): ");
				dat = inp.next();
				ENDPOINT = "http://api.coinlayer.com/"+dat+"?access_key=be081cbdf466ddc8d69458876873bdbc";
				flag = true;
			}	
			else	
				ENDPOINT = "http://api.coinlayer.com/api/live?access_key=be081cbdf466ddc8d69458876873bdbc";	
					
			in = new Scanner(new URL(ENDPOINT).openStream());
			json_string = in.nextLine();
			
			json = new JSONObject(json_string);
			coinRatePr.map_rates = json.getJSONObject("rates").toMap();
			
			System.out.print("Все валюты?(Y/NO)");
			dat = inp.next();
			
			if(dat.equals("Y")) {
				if(flag)
					System.out.println(coinRatePr.getHistoricalRates());
				else
					System.out.println(coinRatePr.getLiveRates());
				
			}else {
				HashSet<String> currs = new HashSet<String>();
				currs.add("CDT");
				currs.add("WLK");
				currs.add("ZRX");
				if(flag)
					System.out.println(coinRatePr.getHistoricalRates(currs));
				else
					System.out.println(coinRatePr.getLiveRates(currs));
			}
			
			System.out.print("Выйти?(Y/NO)");
			dat = inp.next();
			if(dat.equals("Y")) break;
		} 
		//
		
		inp.close();

	}

}
