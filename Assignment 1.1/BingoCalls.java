 /*
 Name: Victor Sun
 Student Number: V00894734
 Project: Assignment 1 BingoCalls
 */
public class BingoCalls{
	private int number;
	private char letter;
	private int count;
	private BingoBall[] container;
	private static final int CAPACITY = 5;
	
	/*
	BingoCall Constructor
	Creates an empty array called container to hold the Bingo Balls
	CAPACITY - Size of the array
	Sets number of balls to zero (count is set to zero)
	*/
	public BingoCalls(){
		this.container = new BingoBall[CAPACITY];
		count = 0;
	}
	/*
	Inserts a ball into the container
	param@ - The ball being inserted into the array. It also checks to
	see if the ball being inserted is already in the array. If it is, it
	is not inserted, if not it is.
	If the array is full, it expands the array using the helper method
	*/
	public void insert(BingoBall ball){
		if(count == container.length){
			expand();
		}
		if(!wasCalled(ball)){
			container[count] = ball;
			count++;
		}
	}
	/*
	Helper method for insert
	It expands the array if there is no room to insert any more bingo balls
	*/
	private void expand(){
		BingoBall[] extendedArray = new BingoBall[container.length*2];
		for(int i = 0; i < count; i++){
			extendedArray[i] = container[i];
		}
		container = extendedArray;
	}
	/*
	Returns the number of balls in the array/container
	*/
	public int numBallsCalled(){
		return this.count;
	}
	/*
	Removes a ball that is found in the container. If no equivalent ball is found
	nothing changes. Decreases the count by one as well because a ball is removed
	param@ - The bingo ball that acts as the ball you want to remove
	*/
	public void remove(BingoBall ball){
		int foundBall = find(ball);
		BingoBall temp = null;
		if(foundBall != -1){
			temp = container[foundBall];
			for(int i = foundBall; i < count - 1; i++){
				container[i] = container[i+1];
			}
			container[count-1] = null;
			count--;
		}
	}
	/*
	Helper method for remove method
	Finds the ball in the array that matches the one you want to remove
	param@ - The bingo ball that you want to remove/find in the array to remove
	Returns a int value which tells where the ball is in the array 
	Returns a -1 if the ball is not found
	*/
	private int find(BingoBall ball){
		for(int i = 0; i < count; i++){
			if(container[i].getValue() == ball.getValue() && container[i].getLetter() == ball.getLetter()){
				return i;
			}
		}
		return -1;		
	}
	/*
	Checks the array/container to see if a ball was called or not 
	param@ - The bingo ball you want to check if it was called
	Returns True or False depending if the ball is found
	*/
	public boolean wasCalled(BingoBall ball){
		for(int i = 0; i < count; i++){
			if(ball.getValue() == container[i].getValue() && container[i].getLetter() == ball.getLetter()){
				return true;
			}
		}
		return false;
	}
	/*
	Empties the array
	Sets it to a new array with the starting capacity
	*/
	public void makeEmpty(){
		BingoBall[] temp = new BingoBall[CAPACITY];
		container = temp;
		count = 0;
	}
	/*
	Returns a string representation of the bingo balls called
	Bingo balls are printed as before (A letter followed by an integer
	*/
	public String toString(){
		String str = "";
		if(count == 0){
			return str;
		}
		else{
			for(int i = 0; i < count-1; i++){
				str = str + container[i].toString();
				str = str + "\n";
			}
			str = str + container[count-1].toString();
		}
		return str;
	}
	
	public static void main(String[] args){
		BingoCalls container = new BingoCalls();
		System.out.println(container);
		BingoBall a = new BingoBall(15);
		BingoBall b = new BingoBall(25);
		BingoBall c = new BingoBall(42);
		BingoBall d = new BingoBall(23);
		BingoBall e = new BingoBall(43);
		BingoBall f = new BingoBall(74);
		BingoBall g = new BingoBall(63);
		BingoBall h = new BingoBall(9);
		BingoBall i = new BingoBall(25);
		container.insert(a);
		container.insert(b);
		container.insert(c);
		container.insert(d);
		container.insert(e);
		container.insert(f);
		container.insert(g);
		container.insert(h);
		container.insert(i);
		System.out.println(container);
		System.out.println("Number of balls called: " + container.numBallsCalled() + "\n\n");
		container.remove(new BingoBall(42));
		container.remove(new BingoBall(21));
		System.out.println("After removal: " + "\n" + container);
		System.out.println("Number of balls called: " + container.numBallsCalled()+ "\n\n");
		container.makeEmpty();
		System.out.println("After makeEmpty: " + "\n" + container);
		System.out.println("Number of balls called: " + container.numBallsCalled());
	}
	
}