package sampleTest;

enum enumFinishOptions{
	GLOSSY(0),
	MATTE(1),
	DEFAULT(2);
	
	private int value; 
	private enumFinishOptions(int val){
		this.value = val;
	}
	
	public int getFinishOption(){
		return value;
	}
}

public class CustomerPaintRequests {
	@Override
	public String toString() {
		return "CustomerPaintRequests [colorNo=" + colorNo + ", colorFinishOption=" + colorFinishOption + "]";
	}
	int colorNo;
	enumFinishOptions colorFinishOption;
}
