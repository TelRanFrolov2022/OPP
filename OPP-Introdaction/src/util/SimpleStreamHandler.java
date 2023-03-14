package util;

import java.io.PrintStream;

public class SimpleStreamHandler implements Handler {

	private PrintStream stream;

	public SimpleStreamHandler(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void publish(LoggerRecord loggerRecord) {
		stream.println(loggerRecord.toString());
	}
}