package com.revature;

import java.util.Scanner;

public class FizzBuzzAdvanced {
	public static void fizzBuzzBasic() {
		int i;
		int n = 100;
		for (i = 1; i <= n; i++) {

			if (i % 15 == 0) {
				System.out.println("FizzBuzz" + " ");
			} else if (i % 5 == 0) {
				System.out.println("Buzz" + " ");
			} else if (i % 3 == 0) {
				System.out.println("Fizz" + " ");
			} else
				System.out.println(i + " ");
		}
	}

	public static void fizzBuzzAdvanced(int min, int max, int[] numbers, String[] terms) {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		System.out.println("Enter min: ");
		min = sc.nextInt();
		System.out.println("Enter max: ");
		max = sc.nextInt();

		System.out.println("Enter numbers to replace: ");
		for (i = 0; i < numbers.length; i++) {
			numbers[i] = sc.nextInt();
		}

		System.out.println("Enter words to replace: ");
		for (i = 0; i < terms.length; i++) {
			terms[i] = sc.nextLine();
		}

		// for (i = 0; i<numbers.length; i++) {
		// System.out.println(numbers[i]);
		// }
		// for (i = 0; i<terms.length; i++) {
		// System.out.println(terms[i]);
		// }
		for (i = min; i <= max; i++) {
			if (i % numbers[0] == 0 && i % numbers[1] == 0 && i % numbers[2] == 0) {
				System.out.println(terms[1] + terms[2] + terms[3] + " ");
			} else if (i % numbers[0] == 0 && i % numbers[1] == 0) {
				System.out.println(terms[1] + terms[2] + " ");
			} else if (i % numbers[0] == 0 && i % numbers[2] == 0) {
				System.out.println(terms[1] + terms[3] + " ");
			} else if (i % numbers[1] == 0 && i % numbers[2] == 0) {
				System.out.println(terms[2] + terms[3] + " ");
			} else if (i % numbers[0] == 0) {
				System.out.println(terms[1] + " ");
			} else if (i % numbers[1] == 0) {
				System.out.println(terms[2] + " ");
			} else if (i % numbers[2] == 0) {
				System.out.println(terms[3] + " ");
			} else {
				System.out.println(i + " ");
			}
		}
		sc.close();
	}
}