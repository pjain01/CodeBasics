package traderTest;

public class TraderTxnMain {

	/**Parveen: Main function: First get data either from the file or form the API link
	 * And then run queries one by one.***/
	public static void main(String[] args) {
		
		QueriesFromData qsm = new QueriesFromData();
		if(qsm.getDataValues()){
			qsm.findTradersFromSingaporeAndSort();
			qsm.findTxWithHighestValue();
			qsm.findTxValueFromBeijingTrader();
			qsm.findTxnsInYear2016AndSort();	
		}else{
			System.out.println("Data Could not be obtained..");
		}
		
	}

}
