package traderTest;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**Parveen: This class has implementation for querying data***/
public class QueriesFromData {
	TraderTransaction[] traderTxn = null;
	Trader[] traders = null;
	
	/**Parveen: Used this file only fo rmy testing purpose - not needed anymore***/
	private final String FILE_PATH_FOR_TRADER = "D:\\test\\Trader.json";
	private final String FILE_PATH_FOR_TRANSACTION = "D:\\test\\transactions.json";
	
	public boolean getDataValues(){
		
		GetDataValues gv = new GetDataValues();
		traders =  gv.getTraderValues(FILE_PATH_FOR_TRADER);
		traderTxn = gv.getTransactionValues(FILE_PATH_FOR_TRANSACTION);
		
		if( (traders == null) || (traderTxn == null) ){
			return false;
		}
		return true;
	}
	
	/**Q1. Find all traders from Singapore and sort them by name**/
	public void findTradersFromSingaporeAndSort(){
		List<Trader> selectedTraders = new ArrayList<Trader>();

		for(int i = 0; i<traders.length; i++ ){
			if(traders[i].getCity().equalsIgnoreCase("Singapore")){
				selectedTraders.add(traders[i]) ;
			}
		}
		
		Collections.sort(selectedTraders,new TraderCityComparator());
		System.out.println("Traders from Singapore and sorted:: ");
		for(int i = 0 ; i<selectedTraders.size();i++ ){
			System.out.println(" "+i+" "+selectedTraders.get(i));
		}
	}
	
	/**Q2. Find the transaction with the highest value***/
	public void findTxWithHighestValue(){
		double highestVal = 0;
		for(int i = 0 ; i< traderTxn.length; i++){
			if (traderTxn[i].getValue() > highestVal){
				highestVal = traderTxn[i].getValue();
			}
		}
		System.out.println(" Highest value is = "+highestVal);
	}
	
	/**Q3. Find all transactions in the year 2016 and sort them by value (high to small)***/
	public void findTxnsInYear2016AndSort(){
		Calendar calendar = Calendar.getInstance();
		List<TraderTransaction> selectedTxns = new ArrayList<TraderTransaction>();
		for(int i = 0 ; i< traderTxn.length; i++){
			if( (2016 == getYearFromEpocTime( calendar,traderTxn[i].timestamp ) )){
				selectedTxns.add(traderTxn[i]);
			}
		}
		
		Collections.sort(selectedTxns,new TransactionsValueComparator() );
		System.out.println("Trnsactions in year 2016 and Sorted :: ");
		for(int i = 0 ; i<selectedTxns.size();i++ ){
			System.out.println(" "+i+" "+selectedTxns.get(i).value );
		}
	}
	
	/***Q4. Find the average of transactions' values from the traders living in Beijing***/
	public void findTxValueFromBeijingTrader(){
		/**Parveen: Keeping a Hashset so that I can easily search for trader id 
		 * while looking into transaction records***/
		Set<String> traderIdSet = new HashSet<String>();
		
		double sumVal = 0;
		int count = 0;
		for(int i = 0; i<traders.length; i++ ){
			if(traders[i].getCity().equalsIgnoreCase("Beijing")){
				traderIdSet.add(traders[i].getTraderId() ) ;
			}
		}
		
		for(int i = 0 ; i< traderTxn.length; i++){
			if(traderIdSet.contains(traderTxn[i].traderId)){
				sumVal = sumVal +traderTxn[i].getValue();
				count++;
			}
		}
		System.out.println("Average of transactions' values from Beijing traders: "+(sumVal/count));
	}
	
	private int getYearFromEpocTime(Calendar calendar, long epocTime){
		calendar.setTimeInMillis(epocTime);
		return calendar.get(Calendar.YEAR);
	}
}
