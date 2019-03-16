package fizzbuzzapplication;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import fizzbuzzinputs.BasicFizzBuzzInputs;
import fizzbuzzinputs.AdvancedFizzBuzzInputs;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.InputMismatchException;

/* This class is responsible to get the user input
 * and run FizzBuzz Application.It uses the concept of Runtime 
 * Polymorphism to select basic or advanced FizzBuzz 
 * Functionality by calling displayFizzBuzz function of
 * either the parent class i.e BasicFizzBuzzInputs or 
 * the derived class AdvancedFizzBuzzInputs at runtime.
 */

public class FizzBuzzApplication {

	// This is an unmodifiable set used to check if user wants continue or not
	static Set<String> userDecision = Collections
			.unmodifiableSet(new HashSet<>(Arrays.asList("Yes", "Y", "YES", "yes", "y")));

	// This function starts the FizzBuzz Application
	public static void main(String[] args) {

		System.out.println("#####Welcome to this exciting FizzBuzz Application#####");
		System.out.println("*****Please enter the range for FizzBuzz (from -21474843647 to  2147483647)*****");

		runFizzBuzz();

		System.out.println("Hope to see you again!");

	}

	// This function gets user inputs, checks for any invalid inputs
	// and creates a FizzBuzz input object
	public static void runFizzBuzz() {

		Scanner userInput = new Scanner(System.in);

		int[] inputs = new int[2];
		
		TreeMap<Integer, String> customTokens = new TreeMap<Integer, String>();

		String decision;
		
		try {

			do {
				inputs = getInputRange(userInput);

				customTokens = getCustomTokens(userInput);

				BasicFizzBuzzInputs inputFizzBuzz = createFizzBuzzInputs(inputs, customTokens);

				intiateFizzBuzz(inputFizzBuzz);

				System.out.println("#####Do you want to run the application again?#####");
				decision = userInput.next();

			} while (userDecision.contains(decision));

		} catch (InputMismatchException e) {
			System.out.println("Fizzbuzz recieved incorrect data types. Please enter inputs as per the directions.");

		} catch (ArithmeticException e) {
			System.out.println("Fizzbuzz has received invalid input. Please enter inputs as per the directions");
		} catch (Exception e) {
			System.out.println("An exception has occured. Please restart FizzBuzz!");
		} finally {
			userInput.close();
		}
	}

	// This function calls the appropriate display function as per the object.
	// This function is resolved at runtime
	public static void intiateFizzBuzz(BasicFizzBuzzInputs inputFizzBuzz) {

		inputFizzBuzz.displayFizzBuzz();

	}

	// This function returns an actual user input object
	public static BasicFizzBuzzInputs createFizzBuzzInputs(int[] inputs, TreeMap<Integer, String> customTokens) {

		if (customTokens.size() > 0)
			return new AdvancedFizzBuzzInputs(inputs, customTokens);

		return new BasicFizzBuzzInputs(inputs);

	}

	// This function returns a sorted array with two numbers.
	// Index 0 of the array provides start point and Index 0 provides end point.
	// Sorting assures that user can enter ranges in any sequence.
	public static int[] getInputRange(Scanner userInput) {

		int firstUserInput = 0;
		int secondUserInput = 0;
		System.out.println("1. Please enter the First Input :");
		firstUserInput = userInput.nextInt();
		System.out.println("2. Please enter the Second Input:");
		secondUserInput = userInput.nextInt();

		int[] inputs = new int[2];
		inputs[0] = firstUserInput;
		inputs[1] = secondUserInput;

		Arrays.sort(inputs);
		return inputs;
	}

	// This function return a TreeMap which stores the entered input tokens
	// in ascending order. The ascending order is required as we need lower
	// integers to be processed before the bigger ones so as to form
	// the correct string
	public static TreeMap<Integer, String> getCustomTokens(Scanner userInput) {

		TreeMap<Integer, String> customTokens = new TreeMap<Integer, String>();

		System.out.println("Do you want to enter custom tokens(Yes/Y/yes,y, No/N/n/no)");
		String nextToken = userInput.next();

		while (userDecision.contains(nextToken)) {

			System.out.println("1. Enter Number (from -2147483647 to  2147483647):");
			int number = userInput.nextInt();
			System.out.println("1. Enter Token :");
			String token = userInput.next();
			customTokens.put(number, token);

			System.out.println("Do you want to enter more tokens(Yes/Y/yes,y, No/N/n/no)");
			nextToken = userInput.next().trim();

		}
		return customTokens;
	}
}
