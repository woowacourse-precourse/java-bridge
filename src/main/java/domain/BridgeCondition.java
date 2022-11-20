package domain;

public enum BridgeCondition {
	RIGHT(" O "),
	WRONG(" X "),
	EMPTY("   ");

	private final String condition;

	private BridgeCondition(String condition) {
		this.condition = condition;
	}

	public String getCondition() {
		return condition;
	}
}
