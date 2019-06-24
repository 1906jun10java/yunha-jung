package com.revature.minmutation;

import java.util.Arrays;


public class MinMutationDriver extends MinMutation {

	public static void main(String[] args) throws ClassNotFoundException {
		String [] bank = {"AACCGGTA","AACAGGTA","AACCGGTA"};
		String start = "AACCGGTT";
		String end = "AACAGGTA";
		
		
		System.out.println(start);
		System.out.println(end);
		System.out.println(Arrays.toString(bank));
		System.out.println("Return: " + minMutation(start, end, bank));
	}

}
