package bridge.enums;

public enum Map {
	SAFE(" O "),
	DIE(" X "),
	BLANK("   ");

	private final String value;

	Map(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
