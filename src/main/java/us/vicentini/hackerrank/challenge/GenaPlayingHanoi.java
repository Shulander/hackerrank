package us.vicentini.hackerrank.challenge;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/contests/world-codesprint-april/challenges/gena
 *
 * Sample Input
 * 3
 * 1 4 1
 *
 * Sample Output
 * 3
 * 
 * @author Shulander
 */
public class GenaPlayingHanoi {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		Stack[] rods = new Stack[4];
		int[] diskPosition = new int[n + 1];
		for (int i = 0; i < rods.length; i++) {
			rods[i] = new Stack<>();
		}
		diskPosition[0] = -1;
		for (int i = 1; i <= n; i++) {
			int value = in.nextInt() - 1;
			rods[value].add(0, i);
			diskPosition[i] = value;
		}

		System.out.println(solveHanoi(rods, diskPosition, 1));
	}

	private static int solveHanoi(Stack[] rods, int[] diskPosition, int n) {
		if (n >= diskPosition.length) {
			return 0;
		}
		int returnValue = 0;
		if (diskPosition[n] != 0) {
			int tmp = returnTmpRod(0, diskPosition[0]);
			int moves = n-1;
			returnValue += move(rods, diskPosition, moves, 0, tmp);
			returnValue += move(rods, diskPosition, rods[diskPosition[n]].size(), diskPosition[n], 0);
			returnValue += move(rods, diskPosition, moves, tmp, 0);
		}
		returnValue += solveHanoi(rods, diskPosition, n+1);

		return returnValue;
	}

	private static int move(Stack<Integer>[] rods, int[] diskPosition, int elemToMove, int from, int to) {
		if (elemToMove <= 0) {
			return 0;
		}
		if (elemToMove == 1) {
			Integer diskValue = rods[from].pop();
			rods[to].push(diskValue);
			diskPosition[diskValue] = to;
			return 1;
		}

		int tmp = returnTmpRod(from, to);
		int returnValue = move(rods, diskPosition, elemToMove - 1, from, tmp);
		returnValue+= move(rods, diskPosition, 1, from, to);
		returnValue += move(rods, diskPosition, elemToMove - 1, tmp, to);
		return returnValue;
	}

	private static int returnTmpRod(int i, int i0) {
		int returnValue = 0;
		while (returnValue == i || returnValue == i0) {
			returnValue = (returnValue + 1) % 4;
		}
		return returnValue;
	}
}
