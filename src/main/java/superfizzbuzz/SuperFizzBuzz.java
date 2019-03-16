package superfizzbuzz;

import fizzbuzzinputs.BasicFizzBuzzInputs;

import java.util.TreeMap;

import fizzbuzzinputs.AdvancedFizzBuzzInputs;

/* This class provides the functionality of calculating
 * and displaying the classic as well as advanced
 * FizzBuzz sequences.
 */

public class SuperFizzBuzz {

	// Provides functionality for basic FizzBuzz
	public void basicFunctionality(BasicFizzBuzzInputs userInputs) {

		int startRange = userInputs.getStartRange();
		int endRange = userInputs.getEndRange();
		
		for(int i = startRange; i <= endRange; i++) {

			StringBuilder outputFizzBuzz = new StringBuilder();
			
			if (i % 3 == 0)
				outputFizzBuzz.append("Fizz");
			
			if (i % 5 == 0)
				outputFizzBuzz.append("Buzz");
			
			if (outputFizzBuzz.length() == 0)
				outputFizzBuzz.append(i);

			System.out.print(outputFizzBuzz);
			System.out.print("\n");
		}
	}

	// Provides functionality for advanced FizzBuzz
	public void advancedFunctionality(AdvancedFizzBuzzInputs userInputs) {

		int startRange = userInputs.getStartRange();
		int endRange = userInputs.getEndRange();
		
		TreeMap<Integer, String> userTokens = userInputs.getCustomTokens();
		
		for(int i = startRange; i <= endRange; i++) {

			StringBuilder outputFizzBuzz = new StringBuilder();

			for (Integer userInput : userTokens.keySet()) {
				
				if (i % userInput == 0)
					outputFizzBuzz.append(userTokens.get(userInput));
				
			}

			if (outputFizzBuzz.length() == 0)
				outputFizzBuzz.append(i);
			
			System.out.print(outputFizzBuzz);
			System.out.print("\n");
		}
	}

}
