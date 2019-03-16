package fizzbuzzinputs;

import superfizzbuzz.SuperFizzBuzz;
import interfaces.displayContract;

/* This class handles the class FizzBuzz functionality.
 * It calls the SuperFizzBuzz class to display the
 * FizzBuzz sequence.
 */
public class BasicFizzBuzzInputs implements displayContract {

	protected int startRange;
	protected int endRange;

	
	public BasicFizzBuzzInputs(int[] inputs) {
		startRange = inputs[0];
		endRange = inputs[1];
	}
	
	public void displayFizzBuzz() {

		SuperFizzBuzz superFizz = new SuperFizzBuzz();
		superFizz.basicFunctionality(this);
	}
	
	//Getter Methods are defined below
	public int getStartRange() {
		return startRange;
	}
	
	public int getEndRange() {
		return endRange;
	}
	
}
