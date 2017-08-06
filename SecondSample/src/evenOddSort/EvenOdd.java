package evenOddSort;

public class EvenOdd {

	/**Parveen: As we are iterating every element only once this is an O(n) loop
	 * i.e. we don't look back same item again once we are past that index****/
	public static void main(String[] args) {
		int arr[] = {2,4,7,6,1,3,5,4};
//		int arr[] = {5,7,9,1};
//		int arr[] = {1};
		
		int starIdx = 0; 
		int endIdx  = arr.length-1;
		
		while(starIdx < endIdx){
			while( (starIdx < endIdx) && (arr[starIdx]%2 == 0) ){
				starIdx++;
			}
			
			while((starIdx < endIdx) && (arr[endIdx]%2 == 1) ){
				endIdx--;
			}
			
			if( (starIdx < endIdx) && (arr[starIdx]%2 == 1) 
					&& (arr[endIdx]%2 == 0)){
				int temp = arr[starIdx];
				arr[starIdx] = arr[endIdx];
				arr[endIdx] = temp;
			}
		}
		
		StringBuilder sbt = new StringBuilder();
		for(int i = 0; i< arr.length; i++){
			sbt.append(arr[i]+",");
		}
		System.out.println(sbt.toString());
	}

}
