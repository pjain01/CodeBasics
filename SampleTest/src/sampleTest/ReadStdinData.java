package sampleTest;

import java.util.Scanner;

class InputCounts{
	int noOfTestCases = 0;
	int noOfCustomers = 0; 
	int noOfPaints = 0;
}

/**This class is used for reading values from standard input console**/
public class ReadStdinData {
	
	public int getNoOfTestCases(Scanner scan){
		return scan.nextInt();
	}
	/**Get count of No Of test cases, no of customers and no of paints**/
	public void getInputCounts(Scanner scan,InputCounts inputData){
		inputData.noOfPaints = scan.nextInt();
		inputData.noOfCustomers = scan.nextInt();
		scan.nextLine();
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

	public CustomerPaintRequests[][] getCustomerPaintRequests(Scanner scan,InputCounts inputData){
		
		
		CustomerPaintRequests paintChoice[][] = new CustomerPaintRequests[inputData.noOfCustomers][];

		for(int i = 0; i < inputData.noOfCustomers; i++ ){
			String customerRequestLine = scan.nextLine();
			String RequestLineInput[] = customerRequestLine.split(" ");
			
			int noOfCustomerRequests = Integer.parseInt(RequestLineInput[0]);
			paintChoice[i] = new CustomerPaintRequests[noOfCustomerRequests];
			
			
			int k = 1;
			for(int j = 0; j < noOfCustomerRequests ; j++){
				paintChoice[i][j] = new CustomerPaintRequests();
				paintChoice[i][j].colorNo = Integer.parseInt(RequestLineInput[k]);
				int finishOption = Integer.parseInt(RequestLineInput[k+1]);
				if(finishOption == 1){
					paintChoice[i][j].colorFinishOption = enumFinishOptions.MATTE;
				}else{
					paintChoice[i][j].colorFinishOption = enumFinishOptions.GLOSSY;
				}
//				System.out.println(" length= "+RequestLineInput.length);
				k = k+2;
			}
		}
//		displayInputs(paintChoice);
		return paintChoice;
	}
	
}
