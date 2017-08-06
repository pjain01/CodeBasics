package queueTest;

public class MyQueueTest {

	public static void main(String[] args) {
		MyQueue<String> myQueue = new MyQueue<String>();
		String entry = "Entry";
		
		/***Parveen: Test for few push and pops****/
		int i = 0;
		
		//Add 10 items
		for(i =0;i<10; i++){
			myQueue.push(entry+i);
		}
		
		//thn pop 5 items
		for(int j =0;j<5; j++){
			String popVal = myQueue.pop();
			System.out.println("Popped Val = "+popVal);
		}
		
		//then add 15 more items , now it will have 20 items
		for(; i< 15; i++){
			myQueue.push(entry+i);
		}
		
		//Now pop all items and check that items are popped in proper order.
		while(!myQueue.isEmpty()){
			String popVal = myQueue.pop();
			System.out.println("Popped Val = "+popVal);
		}
		
		//An Edge case: Test for single Item
		myQueue.push("singleItemTest");
		System.out.println(" "+myQueue.pop());
	}

}
