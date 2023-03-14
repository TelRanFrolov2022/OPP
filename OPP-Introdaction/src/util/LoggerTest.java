package util;

import org.junit.jupiter.api.Test;

public class LoggerTest {

	@Test
	void myLoggerConsoleTest() {
		Logger logger = new Logger(new SimpleStreamHandler(System.out), "testLogger");
		logger.error("testE");
		logger.warn("testW");
		logger.info("testI");
	
	}
	
}