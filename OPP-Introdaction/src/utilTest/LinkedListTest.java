package utilTest;


import static org.junit.Assert.assertTrue;
import util.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class LinkedListTest extends ListTest{
	@BeforeEach
	@Override 
	void setUp() throws Exception {
		collection = new LinkedList<>();
		super.setUp();
	}
	
	@Test
	void testLoop() {
		LinkedList<Integer> list1 = new LinkedList<>();
		list1.add(1);
		list1.add(2);
		list1.add(1);
		list1.add(3);
		list1.add(1);
		list1.add(1);
		list1.add(1);
		assertFalse(list1.hasLoop());
		list1.setNext(5, 0);
		assertTrue(list1.hasLoop());
	}
}