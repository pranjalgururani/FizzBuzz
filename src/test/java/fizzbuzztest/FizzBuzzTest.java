package fizzbuzztest;

import static org.junit.Assert.*;

import org.junit.Test;

import superfizzbuzz.SuperFizzBuzz;
import fizzbuzzinputs.BasicFizzBuzzInputs;
import fizzbuzzinputs.AdvancedFizzBuzzInputs;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.TreeMap;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

/*
 * This class contains unit tests that were created to
 * test the functionality of various classes in 
 * FizzBuzzApplication
 */

public class FizzBuzzTest {

	private final PrintStream finalOutput = System.out;
	private final ByteArrayOutputStream programOutput = new ByteArrayOutputStream();

	@Before
	public void setUp() throws Exception {
		System.setOut(new PrintStream(programOutput));
	}

	@After
	public void tearDown() throws Exception {

		System.setOut(finalOutput);
	}

	// Test the functionality of function basicFunctionality in superFizzBuzz
	// package with a positive range including 0
	@Test
	public void testBasicFunctionalityPostiveRange() {

		int[] n = { 0, 15 };
		BasicFizzBuzzInputs basicInput = new BasicFizzBuzzInputs(n);
		SuperFizzBuzz superFizzBuzz = new SuperFizzBuzz();
		superFizzBuzz.basicFunctionality(basicInput);
		StringBuilder expectedOutput = new StringBuilder();
		expectedOutput.append("FizzBuzz\n1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz\n");
		String expected = expectedOutput.toString();
		String result = programOutput.toString();
		assertEquals(expected, result);

	}

	// Test the functionality of function basicFunctionality
	// in superFizzBuzz package
	// with a negative to positive range including 0
	@Test
	public void testBasicFunctionalityNegativeToPositive() {

		int[] n = { -15, 15 };
		BasicFizzBuzzInputs basicInput = new BasicFizzBuzzInputs(n);
		SuperFizzBuzz superFizzBuzz = new SuperFizzBuzz();
		superFizzBuzz.basicFunctionality(basicInput);
		StringBuilder expectedOutput = new StringBuilder();
		expectedOutput.append(
				"FizzBuzz\n-14\n-13\nFizz\n-11\nBuzz\nFizz\n-8\n-7\nFizz\nBuzz\n-4\nFizz\n-2\n-1\nFizzBuzz\n1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz\n");
		String expected = expectedOutput.toString();
		String result = programOutput.toString();
		assertEquals(expected, result);

	}

	// Test the functionality of function advancedFunctionality
	// in superFizzBuzz package
	// with a positive range including 0
	@Test
	public void testAdvancedFunctionalityPositiveRange() {

		int[] n = { 0, 15 };

		TreeMap<Integer, String> customTokens = new TreeMap<>();

		customTokens.put(4, "Frog");
		customTokens.put(13, "Duck");
		customTokens.put(9, "Chicken");

		AdvancedFizzBuzzInputs basicInput = new AdvancedFizzBuzzInputs(n, customTokens);

		SuperFizzBuzz superFizzBuzz = new SuperFizzBuzz();
		superFizzBuzz.advancedFunctionality(basicInput);
		StringBuilder expectedOutput = new StringBuilder();
		expectedOutput.append("FrogChickenDuck\n1\n2\n3\nFrog\n5\n6\n7\nFrog\nChicken\n10\n11\nFrog\nDuck\n14\n15\n");
		String expected = expectedOutput.toString();
		String result = programOutput.toString();
		assertEquals(expected, result);

	}

	// Test the functionality of function advancedFunctionality
	// in superFizzBuzz package
	// with a negative to positive range including 0
	@Test
	public void testAdvancedFunctionalityNegativetoPositive() {

		int[] n = { -4, 15 };
		TreeMap<Integer, String> customTokens = new TreeMap<>();
		customTokens.put(4, "Frog");
		customTokens.put(13, "Duck");
		customTokens.put(9, "Chicken");

		AdvancedFizzBuzzInputs basicInput = new AdvancedFizzBuzzInputs(n, customTokens);

		SuperFizzBuzz superFizzBuzz = new SuperFizzBuzz();
		superFizzBuzz.advancedFunctionality(basicInput);
		StringBuilder expectedOutput = new StringBuilder();

		expectedOutput.append(
				"Frog\n-3\n-2\n-1\nFrogChickenDuck\n1\n2\n3\nFrog\n5\n6\n7\nFrog\nChicken\n10\n11\nFrog\nDuck\n14\n15\n");

		String expected = expectedOutput.toString();
		String result = programOutput.toString();
		assertEquals(expected, result);

	}

	// Test the functionality of function basicFunctionality in superFizzBuzz
	// package with a positive range including 0
	@Test
	public void testBasicFunctionalityWithOnlyZero() {

		int[] n = { 0, 0 };
		BasicFizzBuzzInputs basicInput = new BasicFizzBuzzInputs(n);
		SuperFizzBuzz superFizzBuzz = new SuperFizzBuzz();
		superFizzBuzz.basicFunctionality(basicInput);
		StringBuilder expectedOutput = new StringBuilder();
		expectedOutput.append("FizzBuzz\n");
		String expected = expectedOutput.toString();
		String result = programOutput.toString();
		assertEquals(expected, result);

	}

	// Test the functionality of function advancedFunctionality in superFizzBuzz
	// package with a token that has divisor as zero leading to an Arithmetic
	// Exception
	@Test(expected = ArithmeticException.class)
	public void testAdvancedFunctionalityWithZeroToken() {

		int[] n = { -10, 20 };
		TreeMap<Integer, String> customTokens = new TreeMap<>();
		customTokens.put(0, "Frog");
		customTokens.put(13, "Duck");
		customTokens.put(9, "Chicken");

		AdvancedFizzBuzzInputs basicInput = new AdvancedFizzBuzzInputs(n, customTokens);

		SuperFizzBuzz superFizzBuzz = new SuperFizzBuzz();
		superFizzBuzz.advancedFunctionality(basicInput);

	}

}
