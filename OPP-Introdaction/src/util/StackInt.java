package util;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Deque;

public class StackInt {
	private Deque<Integer> listOfMaxValues;
	private int max;
	private LinkedList<Integer> intList;

	public StackInt() {
		intList = new LinkedList<>();
		listOfMaxValues = new LinkedList<>();
	}

	void push(int numиук) {
		if (intList.isEmpty()) {
			listOfMaxValues.offerLast(numиук);
			max = numиук;

		} else {
			if (numиук > max) {
				max = numиук;
				listOfMaxValues.offerLast(numиук);
			}
		}
		intList.add(numиук);
	}

	int pop() {
		if (intList.isEmpty()) {
			throw new NoSuchElementException();
		}
		int res = intList.pollLast();
		if (res == max) {
			listOfMaxValues.removeLast();
			max = listOfMaxValues.peekLast();
		}
		return res;
	}

	boolean isEmpty() {
		return this.intList.isEmpty();
	}

	int getMax() {
		if (intList.isEmpty()) {
			throw new NoSuchElementException();
		}
		return max;
	}

}