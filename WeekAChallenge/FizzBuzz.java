package com.revature;

import java.util.Scanner;

public class FizzBuzz extends FizzBuzzAdvanced{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter 1 for Basic FizzBuzz. Enter 2 for Advanced FizzBuzz: ");
		int option = sc.nextInt();
		if (option == 1) {
			fizzBuzzBasic();
		} else if (option == 2) {
			int[] numbers = new int[3];
			String[] terms = new String[4];
			int max = 0;
			int min = 0;
			fizzBuzzAdvanced(min, max, numbers, terms);
		}else {
			System.out.println("Please enter 1 or 2.");
		}
		sc.close();
	}
}