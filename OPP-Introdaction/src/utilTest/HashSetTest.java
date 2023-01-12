package utilTest;

import org.junit.jupiter.api.BeforeEach;

import util.*;

public class HashSetTest extends SetTest {

	@BeforeEach
	@Override
	void setUp() throws Exception {
		collection = new HashSet<>(4, 0.75f);
		super.setUp();
	}
}