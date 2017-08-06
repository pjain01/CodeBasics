package traderTest;

//import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**Parveen: This class is used for getting data values(using RestfulClientAPI class) from and desrealizing 
 * json data***/
public class GetDataValues {
	private final String REST_TXNS_PATH = "prod/transactions"; 
	private final String REST_TRADERS_PATH = "prod/traders";
	
	RestfulClientAPI restfulClient = new  RestfulClientAPI();
	public Trader[] getTraderValues(String filePath){
		Trader[] traderObjects = null;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			String response = restfulClient.getData(REST_TRADERS_PATH);
			if(response != null){
				traderObjects = mapper.readValue(response,Trader[].class );
			}
			//traderObjects = mapper.readValue(new File(filePath), Trader[].class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return traderObjects;
	}
	
	public TraderTransaction[] getTransactionValues(String filePath){
		TraderTransaction[] traderTxns = null;
		ObjectMapper mapper = new ObjectMapper();
		try {
			String response = restfulClient.getData(REST_TXNS_PATH);
			if(response != null){
			    traderTxns = mapper.readValue(restfulClient.getData(REST_TXNS_PATH),TraderTransaction[].class );
			}
//			traderTxns = mapper.readValue(new File(filePath), TraderTransaction[].class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return traderTxns;
	}
}

/**public static void main(String[] args) {
//		String filePathForTrader = "D:\\test\\Trader.json";
		String filePathForTrnsaction = "D:\\test\\transactions.jason";
		GetDataValues go = new GetDataValues();
		TraderTransaction[] traderTxn = go.getTransactionValues(filePathForTrnsaction);
		for(int i = 0;i<traderTxn.length; i++ ){
			System.out.println("values: "+i+" "+traderTxn[i]);
		}

	}***/
