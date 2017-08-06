package sampleTest;

import java.util.Scanner;

public class PaintMain {
	
    StringBuilder finalResult = new StringBuilder();
    
    /***1. if we have not used given color option(still default) - return true
     * 2. If current color requirement is same as request earlier  - return true
     * 3. For all mismatch return false***/
	private boolean canColorBeAllocated(CustomerPaintRequests paintRequest,  
			enumFinishOptions paintSolution[] ){
		
		enumFinishOptions finisingOption = paintSolution[paintRequest.colorNo-1];
		if( finisingOption == enumFinishOptions.DEFAULT){
			return true;
		}
		else if(finisingOption == paintRequest.colorFinishOption ){
			return true;
		}
		
		return false;
	}
	
	private enumFinishOptions getCurrentFinishOption(CustomerPaintRequests paintRequests,enumFinishOptions paintSolution[]){
		return paintSolution[paintRequests.colorNo-1];
	}
	
	private void setFinishOptionInSolution(CustomerPaintRequests paintRequests,enumFinishOptions paintSolution[]){
		paintSolution[paintRequests.colorNo-1] = paintRequests.colorFinishOption;
	}
	
	private void unSetFinishOptionInSolution(CustomerPaintRequests paintRequests,
			enumFinishOptions paintSolution[],enumFinishOptions olderFinishoptions){
		paintSolution[paintRequests.colorNo-1] = olderFinishoptions ;
	}

	/***I consider first customer’s request and check for rest of the customer’s request recursively 
	 * (going in a DFS way).If for some color I find there is mismatch(earlier customer’s request was 
	 * for Glossy and current request was for Matte or vice versa) between earlier opted color option I leave that 
	 * path and consider another path considering next request. If I find even one possible path from 
	 * first customer’s request till last customer’s request I have found a solution.***/
	public boolean allocateColor ( int currCustIdx,CustomerPaintRequests paintRequests[][]
			,enumFinishOptions paintSolution[] 
			, int customerCount)	{
		
	  if(currCustIdx == customerCount)  {
	    return true;
	  }

	  for(int i=0 ; i < paintRequests[currCustIdx].length; i++ ){
		  
	      boolean result= canColorBeAllocated(paintRequests[currCustIdx][i],paintSolution );
	      
//	      System.out.println(" currCustIdx= ["+currCustIdx +"] i= ["+i +"] result= "+result);
	      if(result){
	    	  enumFinishOptions currentFinishOption = getCurrentFinishOption(paintRequests[currCustIdx][i],paintSolution);
	    	  setFinishOptionInSolution(paintRequests[currCustIdx][i],paintSolution);
	    	  boolean isCurrentSeqPossible = allocateColor(currCustIdx+1,paintRequests,paintSolution,customerCount);
	    	  if(!isCurrentSeqPossible){
	    		  unSetFinishOptionInSolution(paintRequests[currCustIdx][i],paintSolution,currentFinishOption);
	    		  continue;
	    	  }else{
	    		  return true;
	    	  }
	      }else{
	    	  continue;
	      }
	  }
	  
	  return false;
	}
	

	/***Sort array on Glossy and Matte finish options so that all Matte options come in last 
	 * and all Glossy options comes first for customer requests
	 * Why: In given question Matte is going to provided only once for every customer request 
	 * and in our Algo we are trying to find out best possible scnenario where we can minimise Matte color options
	 * in final solution, so by sorting we can will matte consider option only in last so that we can minimise its usage
	 * 
	 *  Given Question says that there is only one possible solution with minimum no of Matte Option
	 *  so this aproach will work***/
	private void sortBasedOnFinishing(CustomerPaintRequests paintRequests[][],InputCounts inputCounts){
		
		for(int customerIdx = 0; customerIdx<inputCounts.noOfCustomers; customerIdx++  ){
			int noOfRequests = paintRequests[customerIdx].length;
			int lastIndex = noOfRequests-1;
			int startIndex = 0;
			
			while(startIndex < lastIndex){
				while((startIndex < lastIndex) && 
						(paintRequests[customerIdx][lastIndex].colorFinishOption == enumFinishOptions.MATTE) ){
					lastIndex--;
				}
				
				while((startIndex < lastIndex) && 
						(paintRequests[customerIdx][startIndex].colorFinishOption == enumFinishOptions.GLOSSY) ){
					startIndex++;
				}

				if(startIndex < lastIndex){
					CustomerPaintRequests temp = paintRequests[customerIdx][startIndex];
					paintRequests[customerIdx][startIndex] = paintRequests[customerIdx][lastIndex];
					paintRequests[customerIdx][lastIndex] = temp;
					startIndex++;
					lastIndex--;
				}
			}
		}
}
	


	private enumFinishOptions[] intializePaintSolutionArray(int noOfPaints){
		enumFinishOptions paintSolution[] = new enumFinishOptions[noOfPaints];
		for(int i = 0; i< noOfPaints; i++){
			paintSolution[i] = enumFinishOptions.DEFAULT;
		}
		return paintSolution;
	}
	
	private void printPossibleOutput(enumFinishOptions paintSolution[], int testCaseCount){
		StringBuilder sbt = new StringBuilder("Case #");
		sbt.append(testCaseCount).append(":").append(" ");
		for(int i = 0; i< paintSolution.length; i++){
			if( (paintSolution[i] == enumFinishOptions.DEFAULT) || (paintSolution[i] == enumFinishOptions.GLOSSY)){
				sbt.append("0 ");
			}else{
				sbt.append("1 ");
			}
		}
		finalResult.append(sbt.toString()).append("\n") ;
	}
	
	
	public static void main(String[] args) {
		CustomerPaintRequests customerPaintRequests[][] = null;
		
		PaintMain paintMain = new PaintMain();
		
		//System.out.println("\n");
		Scanner scan = new Scanner(System.in);
		
		ReadStdinData readStdInData = new ReadStdinData();
		
		InputCounts inputCounts = new InputCounts();
		
		inputCounts.noOfTestCases = readStdInData.getNoOfTestCases(scan);
		
		for(int i= 0; i< inputCounts.noOfTestCases; i++){
			readStdInData.getInputCounts(scan,inputCounts);
			
			customerPaintRequests = readStdInData.getCustomerPaintRequests(scan,inputCounts);
			
			paintMain.sortBasedOnFinishing(customerPaintRequests,inputCounts);
//			paintMain.displayInputs(customerPaintRequests);
			
			enumFinishOptions paintSolution[] = paintMain.intializePaintSolutionArray(inputCounts.noOfPaints);
			
			boolean isPossible = paintMain.allocateColor ( 0,customerPaintRequests,paintSolution,inputCounts.noOfCustomers );
			if(isPossible){
				paintMain.printPossibleOutput(paintSolution,i+1);
			}else{
				paintMain.finalResult.append("Case #"+(i+1)+": IMPOSSIBLE").append("\n");
			}
		}
		scan.close();
		System.out.println(paintMain.finalResult.toString());
	}
	
	public void displayInputs(CustomerPaintRequests paintChoice[][]){
		
		StringBuilder sbt = new StringBuilder();
		for(int i = 0; i<paintChoice.length; i++ ){
			for(int j = 0; j < paintChoice[i].length ; j++){
				
				sbt.append(" ").append(paintChoice[i][j].colorNo).append(" ").append(paintChoice[i][j].colorFinishOption.ordinal()) ;
			}
			sbt.append("\n");
			
		}
		System.out.println(sbt.toString());
	}
}
