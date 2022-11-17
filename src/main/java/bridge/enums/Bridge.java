package bridge.enums;

public enum Bridge {
	FRONT("["),
	BACK("]"),
	DIV("|"),
	DEFAULT("   ");


	private String value;

	Bridge(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
