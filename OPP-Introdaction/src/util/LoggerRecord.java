package util;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class LoggerRecord {

	private final Instant timestamp;

	private final String zoneId;

	private final Level level;

	private final String loggerName;

	private final String message;

	public LoggerRecord(String loggerName, Level level, String message) {
		timestamp = Instant.now();
		zoneId = ZoneId.systemDefault().toString();
		this.level = level;
		this.loggerName = loggerName;
		this.message = message;
	}

	@Override
	public String toString() {
		return getDateTime(timestamp, zoneId).toLocalDate().toString() + " "
				+ getDateTime(timestamp, zoneId).toLocalTime().toString() + " " + loggerName + " " + level.name() + ": "
				+ message;
	}

	LocalDateTime getDateTime(Instant instant, String zone) {
		return LocalDateTime.ofInstant(instant, ZoneId.of(zone));

	}
}