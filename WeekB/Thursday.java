package com.revature.challenge;

public class Thursday {
	public static void main(String [] args) {
		
	String str = "Hello my name is YunHa";
	String substr = "Hallo";
	System.out.println("This is the String: " + str);
	System.out.println("This is the subString: " + substr);
	System.out.println(containsSubString(str, substr));
	System.out.println("Triangle method number of blocks: " + triangle(4));
		
	}
	
	public static boolean containsSubString(String str, String substr) {
		if(str.contains(substr)) {
			System.out.println("There is a subString");
			return true;
		}else{
			System.out.println("There is no subString");
			return false;
		}
		
	}
	
	public static int triangle (int numbers) {
		if(numbers == 1) {
		return 1;
		}else{
		return numbers + triangle(numbers - 1);	
	}
	}
}
