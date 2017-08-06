package traderTest;

import java.util.Comparator;

/**Parveen: Create comparaotr for comparing transaction values***/
public class TransactionsValueComparator implements Comparator<TraderTransaction>{

	@Override
	public int compare(TraderTransaction arg0, TraderTransaction arg1) {
		if(arg0== null){
			if(arg1==null){
				return 0;
			}else{
				return -1;
			}
		}else{
			if(arg1==null){
				return 1;
			}
			return Double.compare(arg0.getValue(),arg1.getValue()); 
		}
	}

}
