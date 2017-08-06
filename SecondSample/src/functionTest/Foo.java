package functionTest;
 
class Foo {
	int sequenceVal = 0;
    Foo() {}
    
    synchronized  void first() {
    	/**Parveen: if sequenceVal is not 0 then wait. Need to check it in loop in case of spurious waleups**/
    	while(sequenceVal != 0){
    		try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Exception in First Function");
				e.printStackTrace();
			}
    	}
    	System.out.println("In First Function");
    	sequenceVal = 1;
    	this.notifyAll();
    }
    
    synchronized void second() {
    	while(sequenceVal != 1){
    		try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Exception in Second Function");
				e.printStackTrace();
			}
    	}
    	System.out.println("In Second Function");
    	sequenceVal = 2;
    	this.notifyAll();
    }
    synchronized void third() { 
    	while(sequenceVal != 2){
    		try {
				this.wait();
			} catch (InterruptedException e) {
				System.out.println("Exception in Third Function");
				e.printStackTrace();
			}
    	}
    	System.out.println("In Third Function");
    	
    	sequenceVal = 0;
    	this.notifyAll();
    }
  }