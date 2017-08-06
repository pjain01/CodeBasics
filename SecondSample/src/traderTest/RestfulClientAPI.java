package traderTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class RestfulClientAPI {
	final String key = "gaqcRZE4bd58gSAJH3XsLYBo1EvwIQo88IfYL1L5";
	final String baseURI = "https://fvjkpkflnc.execute-api.us-east-1.amazonaws.com/";
	
	String getURI(String path){
		return baseURI+path;
	}
	
	/**Parveen: Just get data from remote**/
	public String getData(String path) {
		StringBuilder queryResponse = new StringBuilder();
		try {
			URL url = new URL(getURI(path));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("x-api-key", key);
			
			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			System.out.println("Output from Server .... \n");
			String output = null;
			while ( (output = br.readLine()) != null) {
				queryResponse.append(output);
				System.out.println(output);
			}
			conn.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return queryResponse.toString();
	}
	
	public static void main(String[] args) {
		RestfulClientAPI cp = new RestfulClientAPI();
//		cp.getData("prod/transactions");
		cp.getData("prod/traders");
	}

}