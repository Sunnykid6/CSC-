/**
 * Template created for CSC115 Assignment 1: Bingo
 */
 /*
 Name: Victor Sun
 Student Number: V00894734
 Project: Assignment 1 BingoBall
 */
 
public class BingoBall {

	private char letter;
	private int number;
	private static char[] bingo = {'B','I','N','G','O'};
	/*
	BingoBall Constructor
	param@ Int value - number value of a bingo ball 
	It checks what the value is and assigns a letter 
	of "BINGO" based on value
	Exception: Throws an IllegalArgumentException if 
	the value of the variable value is not between 1 and 75. 
	Does not assign a letter.
	*/
	public BingoBall(int value) {
		this.number = value;
		if (value > 0 && value < 76) {
			if(value <= 15){
				this.letter = bingo[0];
			}
			else if(value > 15 && value <= 30){
				this.letter = bingo[1];
			}
			else if(value > 30 && value <= 45){
				this.letter = bingo[2];
			}
			else if(value > 45 && value <= 60){
				this.letter = bingo[3];
			}
			else if(value > 60 && value <= 75){
				this.letter = bingo[4];
			}
			// do something
		} else {
			throw new IllegalArgumentException("number must be between 1 and 75; it was "+value);
		}
	}
	/*
	Helper method for setting the number of a bingo ball.
	param@ uses a value to assign a letter of BINGO based on the value
	*/
	private void setLetter(int value) {
		if (value > 0 && value < 76) {
			if(value <= 15){
				this.letter = bingo[0];
			}
			else if(value > 15 && value <= 30){
				this.letter = bingo[1];
			}
			else if(value > 30 && value <= 45){
				this.letter = bingo[2];
			}
			else if(value > 45 && value <= 60){
				this.letter = bingo[3];
			}
			else if(value > 60 && value <= 75){
				this.letter = bingo[4];
			}
		}else {
			throw new IllegalArgumentException("number must be between 1 and 75; it was "+value);
		}
	}
	/*
	Returns the number value of the bingo ball
	*/
	public int getValue() {
		return this.number;
	}
	/*
	Returns the letter value of the bingo ball
	*/
	public char getLetter() {
		return this.letter; 
	}
	/*
	Sets the number value of the bingo ball
	Uses the helper method to set the Letter
	of the bingo ball based on the number value
	param@ Int value - number value of a bingo ball
	*/
	public void setValue(int value) {
		this.number = value;
		setLetter(value);
		
		//System.out.println("hello world");
	}
	/*
	Determines if this BingoBall is equivalent to another bingo ball
	param@ other - The BingoBall that is compared to the first one.
	Returns true if the two balls are equivalent
	*/
	public boolean equals(BingoBall other) {
		if(other.getValue() == this.number){
			return true;
		}
		return false;
	}
	/*
	Returns a string representation of the ball as a letter
	followed by an integer like in bingo.
	*/
	public String toString() {
		return String.valueOf(letter) + number;
	}
	
	public static void main(String[] args) {
		BingoBall b = new BingoBall(42);
		System.out.println("Created a BingoBall: "+b);
		System.out.println("The number is "+b.getValue());
		System.out.println("The letter is "+b.getLetter());
		BingoBall c = null;
		try {
			c = new BingoBall(76);
		} catch (Exception e) {
			System.out.println("Correctly caught the exception");
		}
		System.out.println("Created a second BingoBall: "+c);
		c = new BingoBall(14);
		System.out.println("The second ball has been changed to "+c);
		if (!b.equals(c)) {
			System.out.println("The two balls are not equivalent");
		}
		c.setValue(42);
		System.out.println("The second ball has been changed to "+c);
		if (b.equals(c)) {
			System.out.println("They are now equivalent");
		}
		c.setValue(74);	
		System.out.println("The second bingo ball has been changed to "+c);
		if (!b.equals(c)) {
			System.out.println("The two balls are not equivalent");
		}
		else if (b.equals(c)) {
			System.out.println("They are now equivalent");
		}
		System.out.println(b.getValue());
		System.out.println(b.getLetter());
	}
	
}
