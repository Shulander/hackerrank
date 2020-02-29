package us.vicentini.hackerrank.challenge;

import java.util.Scanner;

/**
 * https://www.hackerrank.com/contests/world-codesprint-april/challenges/beautiful-triplets
 * 
 * Sample Input
 * 7 3
 * 1 2 4 5 7 8 10
 * 
 * Sample Output
 * 3
 * 
 * @author Shulander
 */
public class BeautifulTriplets {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int d = in.nextInt();
		boolean[] c = new boolean[20001];
		int tmp;
		for (int c_i = 0; c_i < n; c_i++) {
			tmp = in.nextInt();
			if(tmp<=20001)
				c[tmp] = true;
		}

		System.out.println(findTriplets(c, d));
	}

	private static int findTriplets(boolean[] c, int d) {
		int returnValue=0;
		
		for (int i = 0; i+d+d < c.length; i++) {
			if(c[i] && c[i+d] && c[i+d+d]) {
				returnValue ++;
			}
		}
		
		return returnValue;
	}
}
