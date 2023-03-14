package util;

public class Logger {

	private Level level = Level.INFO;

	private Handler handler;

	private String name;

	public Logger(Handler handler, String name) {
		this.handler = handler;
		this.name = name;
	}

	private boolean check(Level settedLevel) {
		return level.getPriority() >= settedLevel.getPriority();
	}

	private LoggerRecord getRecord(Level level, String message) {
		return check(level) ? new LoggerRecord(name, level, message) : null;

	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public void error(String message) {
		handler.publish(getRecord(Level.ERROR, message));
	}

	public void warn(String message) {
		handler.publish(getRecord(Level.WARN, message));
	}

	public void info(String message) {
		handler.publish(getRecord(Level.INFO, message));
	}

	public void debug(String message) {
		handler.publish(getRecord(Level.ERROR, message));
	}

	public void trace(String message) {
		handler.publish(getRecord(Level.TRACE, message));
	}
}
