package bridge.enums;

public enum Constant {
	SUCCESS("성공"),
	FAIL("실패"),
	RESTART_YES("R"),
	RESTART_NO("Q");

	private final String value;

	Constant(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
