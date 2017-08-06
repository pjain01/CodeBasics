package functionTest;

class runnableTask implements Runnable{
	private Foo fooObj = null;
	private char threadName = 0;
	runnableTask(Foo foo, char i){
		fooObj = foo;
		threadName = i;
	}
	
	@Override
	public void run() {
		/**Parveen: Running this loop 5 times so that we can 
		 * check every time sequence is followed properly****/
		for(int i = 0; i< 5; i++){
			if(threadName == 'A'){
				fooObj.first();
			}else if(threadName == 'B'){
				fooObj.second();
			}else if(threadName == 'C'){
				fooObj.third();
			}
		}
		
	}
	
}

public class FunctionSequence {

	public static void main(String[] args) throws InterruptedException {
		/**Parveen: Just for randomization, I am starting C thread first, then B thread and then A thread***/
		
		Foo foo = new Foo();
		Thread task3 = new Thread(new runnableTask(foo,'C')); //C Thread
		Thread.sleep(1000); //Parveen: giving sleep time for some wait so that it can sufficient time to execute its function(if it can)
		Thread task1 = new Thread(new runnableTask(foo,'B')); //B Thread
		Thread.sleep(1000);
		Thread task2 = new Thread(new runnableTask(foo,'A')); //A Thread
		
		task1.start();
		task2.start();
		task3.start();	
	}

}
