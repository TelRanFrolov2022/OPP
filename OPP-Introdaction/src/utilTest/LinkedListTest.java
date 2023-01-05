package utilTest;



import org.junit.jupiter.api.BeforeEach;

import util.*;

class LinkedListTest extends ListTest{
	@BeforeEach
	@Override 
	void setUp() throws Exception {
		collection = new LinkedList<>();
		super.setUp();
	}
	
}