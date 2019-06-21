package com.revature.codechallenge;
import java.util.*;

/*
 * Check if its Balanced using Stack.
 */

public class BalancedBrackets {
	public static void main(String args[]) throws Exception {
		int n = 1; // Condition.
		while (n != 0) { // If n does not equal 0 run code.
			String brac = "{{}()}"; // String array of brackets.
			Stack<String> sk = new Stack<String>(); // A String stack.
			String strArray[] = brac.split("");
			for (String sb : strArray) {
				if (sk.empty()) {
					sk.push(sb); // Push element into stack.
				} else {
					if (isBalanced(sk.lastElement(), sb)) {
						sk.pop();
					} else {
						sk.push(sb); // Pop an element in the stack and remove it.
					}
				}

			}
			n--; 
			// Counter going down every time it loops. Added a counter so
			// it doesn't constantly loops. Had a problem where it would constantly loop
			// when String is too big/long.
			if (sk.empty()) {
				System.out.println("Brackets: " + brac);
				System.out.println("It is balanced.");
			} else {
				System.out.println("Brackets: " + brac);
				System.out.println("It is not balanced.");
				return;
			}
		}

	}

	public static boolean isBalanced(String a, String b) {
		// Checks if its balanced.
		// If first ones true, checks if the other side is true.
		if ((a.equals("{") && b.equals("}"))) { // Check if '{' is in both sides.
			return true;
		} else if ((a.equals("(") && b.equals(")"))) { // Check if '(' is in both sides.
			return true;
		} else if ((a.equals("[") && b.equals("]"))) { // Check if '[' is in both sides.
			return true;
		}
		return false;
	}
}