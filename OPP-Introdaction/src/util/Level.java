package util;

public enum Level {

	TRACE(5), DEBUG(4), INFO(3), WARN(2), ERROR(1);

	private int levelImp;

	private Level(int priority) {
		this.levelImp = priority;
	}

	public int getPriority() {
		return levelImp;
	}

}
