package fizzbuzzinputs;

import java.util.TreeMap;

import superfizzbuzz.SuperFizzBuzz;

/* This class extends the BasicFizzBuzzInputs and hence
 * inherits startRange and endRange.
 * It create a TreeMap to store custom user tokens
 * It overrides the dispayFizzBuzz function in the
 * BasicFizzBuzzInputs class
 */
public class AdvancedFizzBuzzInputs extends BasicFizzBuzzInputs {

	private TreeMap<Integer, String> userTokens;

	public AdvancedFizzBuzzInputs(int[] inputs, TreeMap<Integer, String> currentTokens) {
		super(inputs);
		userTokens = currentTokens;
	}

	public void displayFizzBuzz() {

		SuperFizzBuzz superFizz = new SuperFizzBuzz();
		superFizz.advancedFunctionality(this);
	}
	
	//Getter Method are defined below
	public TreeMap<Integer, String> getCustomTokens() {
		return userTokens;
	}
}
