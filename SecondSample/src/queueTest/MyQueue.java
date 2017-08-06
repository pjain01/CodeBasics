package queueTest;

import java.util.Stack;

/**Parveen: Making dequeue operation heavier implementing this stack
 * pop - just extract one item from stk1 and so one for every call
 * Push - First empty all content in second auxiliary queue and then return top item from second item***/
public class MyQueue<T>  {

	Stack<T> stk1 = new Stack<T>();
	Stack<T> stk2 = new Stack<T>();
	
	void push(T item){
		stk1.push(item);
	}
	
	boolean isEmpty(){
		return stk1.isEmpty();
	}
	
	T pop(){
		T item = null;
		if(stk1.isEmpty()){
			return item;
		}
		
		while(!stk1.isEmpty()){
			T tempItem = stk1.pop();
			stk2.push(tempItem);
		}
		
		
		item = stk2.pop();
		while(!stk2.isEmpty()){
			T tempItem = stk2.pop();
			stk1.push(tempItem);
		}
		return item;
	}
}
