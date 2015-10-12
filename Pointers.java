
public class Pointers {
	private char firstChar;
	private int startReference, endReference;
	
	public Pointers(int startReference, int endReference,char firstChar){
		this.startReference = startReference;
		this.endReference = endReference;
		this.firstChar = firstChar;
	}
	
	public int  getStartReference(){
		return this.startReference;
	}
	
	public int getEndReference(){
		return this.endReference;
	}
	
	public char getFirstChar(){
		return this.firstChar;
	}
	
	public void setFirstChar(char firstChar){
		this.firstChar = firstChar;
	}
	
	

}
