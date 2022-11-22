package bridge.ui;

public enum InputConstants {
	MIN_SIZE("3"),
	MAX_SIZE("20");

	private String str;

	private InputConstants(String str) {
		this.str = str;
	}

	public String getValue() {
		return this.str;
	}
}
