package utilTest;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import util.*;

public abstract class CollectionTest {
	protected Integer[] numbers = { 18, 2, -1, 145, 100555, 2055 };
	protected Integer[] ar = new Integer[numbers.length + 100];
	protected Collection<Integer> collection;
	protected Integer[] empty = {};
	static ArrayList<Integer> list;

	@BeforeEach
	void setUp() throws Exception {

		for (Integer num : numbers) {
			collection.add(num);
		}
	}

	abstract void testAdd();

	abstract void testIterator();

	@Test
	void testRemove() {
		Integer[] expected = { 10, 100, -5, 280, 120, 15 };
		assertTrue(collection.remove((Integer) 134));
		assertArrayEquals(expected, collection.toArray(empty));
		assertFalse(collection.remove((Integer) 134));
	}

	@Test
	void testRemoveIf() {
		Integer[] expected = { -5, 15 };
		assertTrue(collection.removeIf(n -> n % 2 == 0));
		assertArrayEquals(expected, collection.toArray(empty));
		assertFalse(collection.removeIf(n -> n % 2 == 0));
		assertTrue(collection.removeIf(n -> true));
		assertTrue(collection.isEmpty());

	}

	@Test
	void testIsEmpty() {
		assertFalse(collection.isEmpty());
		collection.removeIf(n -> true);
		assertTrue(collection.isEmpty());
	}

	@Test
	void testSize() {
		assertEquals(numbers.length, collection.size());
	}

	@Test
	void testContains() {
		assertTrue(collection.contains(numbers[0]));
		assertFalse(collection.contains(Integer.MIN_VALUE));
	}

	@Test
	void testToArray() {

		Arrays.fill(ar, 10);
		assertTrue(ar == collection.toArray(ar));
		for (int i = 0; i < numbers.length; i++) {
			assertEquals(ar[i], numbers[i]);
		}
		for (int i = numbers.length; i < ar.length; i++) {
			assertNull(ar[i]);
		}

	}
	
	@Test
	void shuffleArrayTest() {
		Integer[] expected = { -1, 2, 18, 145, 2055, 100555 };
		for (int i = 0; i < 100; i++) {
			Integer[] shuffledArray = list.toArrayShuffling(expected);
			assertFalse(expected.equals(shuffledArray));
			Arrays.sort(shuffledArray);
			assertTrue(expected.equals(shuffledArray));
		}
	}

}