package bridge.enums;

public enum BridgeFrame {
	FRONT("["),
	BACK("]"),
	DIV("|"),
	BLANK("   "),
	TRUE(" O "),
	FALSE(" X ");


	private String value;

	BridgeFrame(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
