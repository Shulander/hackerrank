package com.hackerrrank.challenge;

import java.util.Scanner;
import java.util.Stack;

/**
 * https://www.hackerrank.com/contests/world-codesprint-april/challenges/gena
 *
 * Sample Input 3 1 4 1
 *
 * Sample Output 3
 *
 * @author Shulander
 */
public class GenaPlayingHanoi2 {

	private final Stack<Integer>[] rods;
	private final int[] diskPosition;

	private GenaPlayingHanoi2(Stack[] rods, int[] diskPosition) {
		this.rods = rods.clone();
		this.diskPosition = diskPosition.clone();
	}

	private int solveHanoiImpl(int n) {
		if (n <= 0) {
			return 0;
		}
		int returnValue = 0;
		if (diskPosition[n] != 0) {
			System.out.println("move " + n + " to 0");
			int moves = rods[0].size() - (diskPosition.length - 1 - n);
			int tmp = returnEmptyTmpRod(n, 0, diskPosition[n]);
			while (tmp == -1) {
				returnValue = moveLowerValues();
				tmp = returnEmptyTmpRod(n, 0, diskPosition[n]);
			}
			returnValue += move(moves, 0, tmp);
			returnValue += move(rods[diskPosition[n]].size(), diskPosition[n], 0);
//			returnValue += move(moves, tmp, 0);
		}
		returnValue += solveHanoiImpl(n - 1);

		return returnValue;
	}

	private int move(int elemToMove, int from, int to) {
		if (elemToMove <= 0) {
			return 0;
		}
		if (elemToMove == 1) {
			int returnValue = 0;
			while (!rods[to].isEmpty() && !rods[from].isEmpty() && rods[from].peek() > rods[to].peek()) {
				returnValue += moveLowerValues();
			}
			
			Integer diskValue = rods[from].pop();
			rods[to].push(diskValue);
			diskPosition[diskValue] = to;
			printRods();
			return returnValue+1;
		}

		int returnValue = 0;
		int tmp = returnTmpRod(from, to);
		returnValue += move(elemToMove - 1, from, tmp);
		returnValue += move(1, from, to);
//		returnValue += move(elemToMove - 1, tmp, to);
		return returnValue;
	}

	private int returnTmpRod(int from, int to) {
		for (int i = 0; i < 4; i++) {
			if (i != from && i != to) {
				return i;
			}
		}
		return -1;
	}

	private int returnEmptyTmpRod(int value, int from, int to) {
		int count=0;
		int returnValue = -1;
		for (int i = 1; i < 4 && count<2; i++) {
			if (i != from && i != to && (rods[i].empty() || rods[i].peek() > value)) {
				return i;
			}
		}
		return count == 2 ? returnValue : -1;
	}

	public int solveHanoi() {
		printRods();
		int returnValue = solveHanoiImpl(diskPosition.length - 1);
		printRods();
		return returnValue;
	}

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

		GenaPlayingHanoi2 hanoi = new GenaPlayingHanoi2(rods, diskPosition);

		System.out.println(hanoi.solveHanoi());
	}

	private void printRods() {
		System.out.println("--------------------------");
		for (int i = 0; i < rods.length; i++) {
			System.out.print(i + ": ");
			for (Integer rod : rods[i]) {
				System.out.print(rod + " ");
			}
			System.out.println("");
		}
		System.out.println("--------------------------");
	}

	private int moveLowerValues() {
		int returnValue = 0;

		for (int i = 1; i < diskPosition.length - 1; i++) {
			if(diskPosition[i] != diskPosition[i+1]) {
				System.out.println("moving lower elements "+i+"["+diskPosition[i]+"] to "+(i+1)+"["+diskPosition[i+1]+"]");
				return move(i, diskPosition[i], diskPosition[i+1]);
			}
		}

		return returnValue;
	}
}
