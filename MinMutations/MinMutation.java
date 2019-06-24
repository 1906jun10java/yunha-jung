package com.revature.minmutation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinMutation {
	public static int minMutation(String start, String end, String[] bank) {
		if (start.equals(end)) {
			return 0;
		}
		Set<String> bankSet = new HashSet<>();
		for (String b : bank) {
			bankSet.add(b);
		}
		char[] charSet = new char[] { 'A', 'C', 'G', 'T' };
		int increase = 0;
		Queue<String> q = new LinkedList<>();
		Set<String> s = new HashSet<>();
		q.offer(start);
		s.add(start);

		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				String c1 = q.poll();
				if (c1.equals(end)) {
					return increase;
				}
				char[] charA = c1.toCharArray();
				for (int i = 0; i < charA.length; i++) {
					char old = charA[i];
					for (char c2 : charSet) {
						charA[i] = c2;
						String next = new String(charA);
						if (!s.contains(next) && bankSet.contains(next)) {
							s.add(next);
							q.offer(next);
						}
					}
					charA[i] = old;
				}
			}
			increase++;
		}
		return -1;
	}
}