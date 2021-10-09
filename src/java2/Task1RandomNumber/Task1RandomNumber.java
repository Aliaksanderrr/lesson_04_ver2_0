package java2.Task1RandomNumber;

import java.util.Arrays;
import java.util.Random;

public class Task1RandomNumber {

	private static final int MAX_RANDOM_NUMBER = 999;
	private static final int MIN_RANDOM_NUMBER = 100;

	public static void main(String[] args) {

		//TASK1_1
		System.out.print("\nTASK1_1\n");
		Task1RandomNumber task1_1 = new Task1RandomNumber();
		int randomNum = task1_1.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
		int biggestDigit = task1_1.getBiggestDigit(randomNum);
		System.out.printf("Into random number \"%d\" maximum digit is \"%d\".\n", randomNum, biggestDigit);

		//TASK1_2
		System.out.print("\nTASK1_2\n");
		Task1RandomNumber task1_2 = new Task1RandomNumber();
		int[] numList = new int[3];
		int sumFirstDigit = 0;
		for (int i = 0; i < numList.length; i++) {
			numList[i] = task1_2.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
			sumFirstDigit += task1_2.getFirstDigit(numList[i]);
		}
		System.out.printf("The random numbers are %s.\n", Arrays.toString(numList));
		System.out.printf("The sum of its first digits are %d\n", sumFirstDigit);

		//TASK1_3
		System.out.print("\nTASK1_3\n");
		Task1RandomNumber task1_3 = new Task1RandomNumber();
		randomNum = task1_3.getRandomNumber(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
		int sumOfDigits = getDigitsSum(randomNum);
		System.out.printf("The random number is %d.\n", randomNum);
		System.out.printf("The sum of it digits are %d\n", sumOfDigits);
	}

	private int getRandomNumber(int minValue, int maxValue) {
		int range = (maxValue - minValue) + 1;
		return new Random().nextInt(range) + minValue;
	}

	private int getBiggestDigit(int number) {
		int maxDigit = 0;

		while (number > 0) {
			if ((number % 10) > maxDigit) {
				maxDigit = number % 10;
			}
			number /= 10;
		}
		return maxDigit;
	}

	private int getFirstDigit(int number) {
		int firstDigit = 0;

		while (number > 0) {
			firstDigit = number % 10;
			number /= 10;
		}
		return firstDigit;
	}

	private static int getDigitsSum(int number) {
		int digitsSum = 0;

		while (number > 0) {
			digitsSum += number % 10;
			number /= 10;
		}
		return digitsSum;
	}

}
