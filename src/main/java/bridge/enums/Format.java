package bridge.enums;

public enum Format {
	COMMA(", "),
	BAR("|");

	private final String value;

	Format(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
