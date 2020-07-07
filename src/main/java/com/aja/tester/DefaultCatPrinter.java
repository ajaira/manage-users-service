/**
 * 
 */
package com.aja.tester;


/**
 * @author user
 *
 */
public class DefaultCatPrinter implements ICatPrinter {

	private static String SHAPE = "*";
	private static String STEP = ".";
	private static int LEAP_LENGTH_MAX = 4;

	public String print(int leapCount) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < leapCount; i++) {
			result.append(SHAPE);
			result.append(buildLeapLength(i + 1));
		}
		result.append(SHAPE);
		return result.toString();
	}

	private Object buildLeapLength(int step) {
		StringBuilder voidResult = new StringBuilder();
		int stepsLength = calculateLeapLength(step);
		for (int j = 0; j < stepsLength; j++) {
			voidResult.append(STEP);
		}

		return voidResult;
	}

	private int calculateLeapLength(int step) {
		if (step > LEAP_LENGTH_MAX) {
			return LEAP_LENGTH_MAX;
		}
		return step;
	}

}
