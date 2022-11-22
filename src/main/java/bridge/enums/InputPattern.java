package bridge.enums;

public enum InputPattern {
	BRIDGE_SIZE("^[3-9]|1[0-9]|20$"),
	MOVE("^U|D$");

	private final String value;

	InputPattern(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
