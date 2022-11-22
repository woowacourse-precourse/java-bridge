package bridge.enums;

public enum Command {
	UP("U"),
	DOWN("D"),
	RESTART("R"),
	QUIT("Q");

	private final String value;

	Command(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
