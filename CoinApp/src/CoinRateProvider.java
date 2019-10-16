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
		
	public static HashMap<String, Float> hash_map_curr = new HashMap<String, Float>();
	static Scanner in;
	static String json_string;
	static JSONObject json;
	static Map<String, Object> map_rates;
	
	public static void main(String[] args) throws MalformedURLException, IOException {
		String ENDPOINT;
		Boolean flag = false;
		
		Scanner inp = new Scanner(System.in);
		while(true) {
	        System.out.print("�� ����?(Y/NO)");
	        String dat = inp.next();
			
			if(dat.equals("Y")) {
				System.out.print("������� ����(YYYY-MM-DD): ");
				dat = inp.next();
				ENDPOINT = "http://api.coinlayer.com/"+dat+"?access_key=be081cbdf466ddc8d69458876873bdbc";
				flag = true;
			}	
			else	
				ENDPOINT = "http://api.coinlayer.com/api/live?access_key=be081cbdf466ddc8d69458876873bdbc";	
					
			in = new Scanner(new URL(ENDPOINT).openStream());
			json_string = in.nextLine();
			
			json = new JSONObject(json_string);
			map_rates = json.getJSONObject("rates").toMap();
			
			System.out.print("��� ������?(Y/NO)");
			dat = inp.next();
			
			if(dat.equals("Y")) {
				if(flag)
					System.out.println(getHistoricalRates());
				else
					System.out.println(getLiveRates());
				
			}else {
				HashSet<String> currs = new HashSet<String>();
				currs.add("CDT");
				currs.add("WLK");
				currs.add("ZRX");
				if(flag)
					System.out.println(getHistoricalRates(currs));
				else
					System.out.println(getLiveRates(currs));
			}
			
			System.out.print("�����?(Y/NO)");
			dat = inp.next();
			if(dat.equals("Y")) break;
		} 
		//
		
		inp.close();
	}
	
	/**
	 * endpoint: Reques thttps://api.coinlayer.com/live
	 * ���������� ����� ��� ��� ������ - ����, � ���������� - ��������
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
	 * ���������� ����� ��� ��� ������ - ����, � ���������� - ��������
	 * �������� "currencies" ������ �������� (�� �������� ���� ��� ����� ��� ��� ����������) 
	 * @throws IOException 
	 * @throws MalformedURLException 
	 * */
	public static HashMap<String,Float> getLiveRates(HashSet<String> currencies) throws MalformedURLException, IOException {
		
		for(String key: map_rates.keySet()){
			if(currencies.contains(key))
//			for(String code: currencies) {
//				if(code.equals(key) )
					hash_map_curr.put(key, Float.parseFloat(String.valueOf(map_rates.get(key))));
//			}
		}

		return hash_map_curr;
	}
	
	
	/**
	 * endpoint: https://api.coinlayer.com/YYYY-MM-DD
	 * ���������� ����� ��� ��� ������ - ����, � ���������� - �������� - �� ������������ ����
	 * */	
	public static HashMap<String,Float>  getHistoricalRates() {
		for(String key: map_rates.keySet()){
			hash_map_curr.put(key, Float.parseFloat(String.valueOf(map_rates.get(key))));
		}
		
		return hash_map_curr;
	}	

	/**
	 * endpoint: https://api.coinlayer.com/YYYY-MM-DD
	 * ���������� ����� ��� ��� ������ - ����, � ���������� - �������� - �� ������������ ����
	 * �������� "currencies" ������ �������� (�� �������� ���� ��� ����� ��� ��� ����������) 
	 * */	
	public static HashMap<String,Float>  getHistoricalRates(HashSet<String> currencies) {
		for(String key: map_rates.keySet()){
			for(String code: currencies) {
				if(code.equals(key) )
					hash_map_curr.put(key, Float.parseFloat(String.valueOf(map_rates.get(key))));
			}
		}

		return hash_map_curr;
	}	

}
