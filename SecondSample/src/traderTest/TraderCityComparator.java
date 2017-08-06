package traderTest;

import java.util.Comparator;

public class TraderCityComparator implements Comparator<Trader>{

	/***Parveen: let's sort the traders based on city name in ascending order
    returns a negative integer, zero, or a positive integer as this trader city
    is less than, equal to, or greater than the specified object.
	***/
	@Override
	public int compare(Trader arg0, Trader arg1) {
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
			return arg0.getName().compareTo(arg1.getName()); 
		}
		 
	}

}
