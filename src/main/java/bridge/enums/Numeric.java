package bridge.enums;

public enum Numeric {
	INITIALIZE(0),
	FIRST_TRY(1),
	COUNT(1),
	NON_COUNT(0),
	UP_SIGN(1);

	private final int value;

	Numeric(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}
